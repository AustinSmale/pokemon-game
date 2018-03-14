package state;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exception.EmptyPlayerState;
import stadium.Player;

/**
 * Tests that a player state maintains the proper
 * references to context and player
 * @author Elisabeth Ostrow
 *
 */
public class TestPlayerState
{
	
	/**
	 * Makes sure the PlayerContext is reset before every test runs
	 */
	@Before
	public void init(){
		PlayerContext c = PlayerContext.getInstance();
		c.reset();
	}

	/**
	 * tests that context and player are set correctly
	 */
	@Test
	public void testInit()
	{
		PlayerContext c = PlayerContext.getInstance();
		Player p = new Player();
		PlayerState s = new MockPlayerState(c, p);

		assertEquals(c, s.getContext());
		assertEquals(p, s.getPlayer());
	}
	
	/**
	 * tests that the handle method will make changes to the context
	 * @throws EmptyPlayerState 
	 */
	@Test
	public void testHandle() throws EmptyPlayerState{
		
		PlayerContext c = PlayerContext.getInstance();
		Player p = new Player();
		PlayerState s = new MockPlayerState(c, p);

		s.handle();
		//current state should now be set to player2Turn
		assertEquals(Player2TurnState.getInstance(), c.getState());
	}

}
