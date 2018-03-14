package state;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import org.junit.Before;
import org.junit.Test;

import exception.EmptyMenuState;

/**
 * Tests that MenuContext will properly switch
 * menus and handle information from a gui
 * @author Lis
 *
 */
public class TestMenuContext
{
	
	/**
	 * Makes sure that menu and player context are reset
	 * before every test runs
	 */
	@Before
	public void init(){
		PlayerContext c = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		c.reset();
		m.reset();
	}
	
	
	/****************************************
	 *             State Pattern
	 *                 Tests
	 */
	
	/**
	 * test that MenuContext has a reference to each instance
	 * of the menu states
	 * @throws EmptyMenuState 
	 */
	@Test
	public void testInit() throws EmptyMenuState
	{
		MenuContext c = MenuContext.getInstance();
		
		assertEquals(StartMenuState.getInstance(), c.startMenu);
		assertEquals(PokemonMenuState.getInstance(), c.pokemonMenu);
		assertEquals(AttackMenuState.getInstance(), c.attackMenu);
		assertEquals(NoMenuState.getInstance(), c.noMenu);
		
	}
	
	/**
	 * Tests that the current state can be changed
	 */
	@Test
	public void testSetState(){
		MenuContext c = MenuContext.getInstance();
		
		c.setState(c.noMenu);
		
		assertEquals(c.noMenu, c.getState());
	}
	
	
	
	/*********************************************
	 *             Singleton Pattern
	 *                  Tests   
	 */
	
	/**
	 * Tests that only one instance of this class can be referenced
	 */
	@Test
	public void testSingleton(){
		MenuContext c = MenuContext.getInstance();
		//doing this again should return the same instance
		assertEquals(c, MenuContext.getInstance());
	}
	
	/**
	 * Tests that a reset will return current state to its default
	 * and current event to null
	 */
	@Test
	public void testReset(){
		MenuContext c = MenuContext.getInstance();
		ActionEvent e = new ActionEvent(this, 0, "Button1");
		c.actionPerformed(e);
		c.setState(c.pokemonMenu);
		
		c.reset();
		
		assertEquals(c.startMenu, c.getState());
		assertNull(c.getEvent());
	}
	
	
	/***************************************
	 *           Action Listener
	 *                Tests    
	 */
	
	/**
	 * Tests that current even is stored and updated properly
	 */
	@Test
	public void testActionPerformed(){
		MenuContext c = MenuContext.getInstance();
		PlayerContext p = PlayerContext.getInstance();
		ActionEvent e = new ActionEvent(this, 0, "Button1");
		
		//should be null to start
		assertNull(c.getEvent());
		
		//change to store "Button1"
		c.actionPerformed(e);
		
		assertEquals("Button1", c.getEvent());
	}
	
	/**
	 * Tests that a button press is handled properly
	 * using MockGUI and MockMenuState
	 */
	@Test
	public void testButtonPress(){
		MenuContext c = MenuContext.getInstance();
		PlayerContext p = PlayerContext.getInstance();
		ActionEvent e = new ActionEvent(this, 0, "Button1");
		MenuState s = new MockMenuState(c, p, c.getInvoker());
		//so we can predict what it will do
		c.setState(s);
		//this should cause a change in currentState
		c.actionPerformed(e);
		
		assertEquals(c.attackMenu, c.getState());
	}
	

}
