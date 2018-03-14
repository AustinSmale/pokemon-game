package state;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import org.junit.Before;
import org.junit.Test;

import command.Invoker;
import command.InvokerBuilder;

/**
 * Tests the basic functionality of a parent menu state
 * @author Elisabeth Ostrow
 *
 */
public class TestMenuState
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

	/**
	 * tests that both contexts are set properly
	 */
	@Test
	public void testInit()
	{
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = InvokerBuilder.createCommands();
		MenuState s = new MockMenuState(m, p, Invoker.getInstance());
	
		assertEquals(m, s.getContext());
		assertEquals(p, s.getTurnContext());
		assertEquals(p.player1Turn, s.getTurn());
		assertEquals(i, s.getInvoker());
	}
	
	/**
	 * tests that a handle method case cause a change
	 * in both menu and player context (if appropriate)
	 */
	@Test
	public void testHandle(){
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		MenuState s = new MockMenuState(m, p, Invoker.getInstance());
		
		//set current event in menu context so that mockmenustate
		//will handle predictably
		ActionEvent e = new ActionEvent(this, 0, "Button1");
		m.actionPerformed(e);
		
		s.handle();
		
		//should have caused a change in menu context
		assertEquals(m.attackMenu, m.getState());
	}

}
