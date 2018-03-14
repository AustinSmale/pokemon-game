package state;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import org.junit.Before;
import org.junit.Test;

import command.Invoker;
import exception.EmptyMenuState;

/**
 * Tests that when a player is viewing no menus (the battle view)
 * a button selection will take them to a different menu, or end the turn
 * @author Elisabeth Ostrow
 *
 */
public class TestNoMenuState
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
	 *              State Pattern
	 *                  Tests
	 */

	/**
	 * Pressing the end turn button should cause to PlayerContext
	 * to change turns
	 * 
	 */
	@Test
	public void testEndTurn()
	{
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = Invoker.getInstance();
		MenuState s = NoMenuState.getInstance(m, p, i);
		
		
		//set menuContext's current event
		ActionEvent e = new ActionEvent(this, 0, "End Turn");
		m.actionPerformed(e);
		
		s.handle();
		
		assertEquals(p.player2Turn, p.getState());
	}
	
	/**
	 * Pressing the attack menu button will open the attack menu
	 */
	@Test
	public void testAttackMenu(){
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = Invoker.getInstance();
		MenuState s = NoMenuState.getInstance(m, p, i);
		
		//set menuContext's current event
		ActionEvent e = new ActionEvent(this, 0, "Attack Menu");
		m.actionPerformed(e);
		
		s.handle();
		
		assertEquals(m.attackMenu, m.getState());
	}
	
	/**
	 * Pressing the pokemon button should open the pokemon menu
	 */
	@Test
	public void testPokemonMenu(){
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = Invoker.getInstance();
		MenuState s = NoMenuState.getInstance(m, p, i);
		
		//set menuContext's current event
		ActionEvent e = new ActionEvent(this, 0, "Pokemon Menu");
		m.actionPerformed(e);
		
		s.handle();
		
		assertEquals(m.pokemonMenu, m.getState());
	}
	
	
	/****************************************
	 *            Singleton Pattern
	 *                  Tests
	 */

	/**
	 * Tests that only one instance of the NoMenuState
	 * can be obtained
	 * @throws EmptyMenuState 
	 */
	@Test
	public void testSingleton() throws EmptyMenuState{
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = Invoker.getInstance();
		MenuState s = NoMenuState.getInstance(m, p, i);
		
		//this should return the same instance
		assertEquals(s, NoMenuState.getInstance());
	}
	
}
