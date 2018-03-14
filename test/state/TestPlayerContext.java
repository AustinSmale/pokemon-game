package state;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exception.EmptyPlayerState;
import gameplay.TurnObserver;
import stadium.Player;

/**
 * tests that player context will properly switch
 * turns
 * @author Elisabeth Ostrow
 *
 */
public class TestPlayerContext {

	/**
	 * Makes sure the PlayerContext is reset before every test runs
	 */
	@Before
	public void init(){
		PlayerContext c = PlayerContext.getInstance();
		c.reset();
	}


	/*******************************************
	 *              State Pattern
	 *                  Tests
	 */

	/**
	 * Test that playerContext is created
	 * with a state for each turn and is
	 * set to player1Turn to start
	 * @throws EmptyPlayerState
	 */
	@Test
	public void testInit() throws EmptyPlayerState {
		PlayerContext c = PlayerContext.getInstance();
		//see that we have a singleton instance of each turn state
		assertEquals(Player1TurnState.getInstance(), c.player1Turn);
		assertEquals(Player2TurnState.getInstance(), c.player2Turn);
		//see that player1state is set to current
		assertEquals(Player1TurnState.getInstance(), c.getState());
	}

	/**
	 * Tests that we can set the current state
	 * @throws EmptyPlayerState
	 */
	@Test
	public void testSetState() throws EmptyPlayerState{
		PlayerContext c = PlayerContext.getInstance();
		c.setState(c.player2Turn);
		assertEquals(Player2TurnState.getInstance(), c.getState());
	}

	/**
	 * Tests that a request will be handled by a mock player state
	 * @throws EmptyPlayerState
	 */
	@Test
	public void testRequest() throws EmptyPlayerState{
		PlayerContext c = PlayerContext.getInstance();
		Player p = new Player();
		PlayerState s = new MockPlayerState(c, p);
		//sets the mock state as current state so that it
		//will be the one to handle the request
		c.setState(s);

		//cause the mock state to call it's handle method
		c.request();

		//mock state should set current state to player2Turn
		assertEquals(Player2TurnState.getInstance(), c.getState());
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
		PlayerContext c = PlayerContext.getInstance();
		//doing this again should return the same instance
		assertEquals(c, PlayerContext.getInstance());
	}

	/**
	 * Tests that reset will set the current state back to the default
	 */
	@Test
	public void testReset(){
		PlayerContext c = PlayerContext.getInstance();
		c.setState(c.player2Turn);

		c.reset();

		assertEquals(c.player1Turn, c.getState());
	}

	/*********************************************
	 *             Observer Pattern
	 *                  Tests
	 */


	/**
	 * Tests functionality of Observer, including add,
	 * remove, and notify/update
	 * @author Nick Rummel
	 */
	@Test
	public void testObserver()
	{
		PlayerContext c = PlayerContext.getInstance();
		MockTurnObserver mto = new MockTurnObserver();
		assertTrue(c.addObserver(mto));
		// both variables will be false after creation
		assertFalse(mto.player1);
		assertFalse(mto.player2);

		// updates to default PlayerContext current state
		c.notifyObservers();
		assertTrue(mto.player1);
		assertFalse(mto.player2);

		// update current state and make sure variables switch
		c.setState(c.player2Turn);
		assertFalse(mto.player1);
		assertTrue(mto.player2);

		// removed observers are no longer updated
		c.removeObserver(mto);
		c.setState(c.player1Turn);
		assertFalse(mto.player1);
		assertTrue(mto.player2);

	}

	/**
	 * Mock Turn Observer class for testing
	 * purposes only
	 * @author Nick Rummel
	 *
	 */
	class MockTurnObserver implements TurnObserver
	{
		protected boolean player1;
		protected boolean player2;

		public MockTurnObserver()
		{
			player1 = false;
			player2 = false;
		}

		@Override
		public void update()
		{
			PlayerState current = PlayerContext.getInstance().getState();
			if(current.getClass() == Player1TurnState.class)
			{
				player1 = true;
				player2 = false;
			}
			else if(current.getClass() == Player2TurnState.class)
			{
				player1 = false;
				player2 = true;
			}
		}

	}
}
