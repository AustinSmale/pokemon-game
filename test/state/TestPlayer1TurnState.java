package state;

import static org.junit.Assert.*;


import org.junit.Test;

import exception.EmptyPlayerState;
import stadium.Stadium;

/**
 * Tests that this class allows reference to its player
 * and functions as a singleton
 * @author Elisabeth Ostrow
 *
 */
public class TestPlayer1TurnState
{
	
	/************************************
	 *            State Pattern
	 *                Tests
	 */
	
	/**
	 * NOTE: handle does not do anything because it never has to
	 * PlayerState is used to reference the proper player variable
	 */

	/**
	 * test the we can get a reference to 
	 * the player1 variable that's in stadium
	 */
	@Test
	public void testGetPlayer()
	{
		PlayerContext p = PlayerContext.getInstance();
		Stadium s = Stadium.getStadium();
		PlayerState p1 = p.player1Turn;
		
		assertEquals(s.getPlayer1(), p1.getPlayer());
	}
	
	
	/************************************
	 *         Singleton Pattern
	 *               Tests
	 */
	
	/**
	 * Tests that player1State functions as a singleton
	 * @throws EmptyPlayerState
	 */
	@Test
	public void testSingleton() throws EmptyPlayerState{
		PlayerContext p = PlayerContext.getInstance();
		PlayerState p1 = p.player1Turn;
		
		//this should return the same instance
		assertEquals(p1, Player1TurnState.getInstance());
	}

}
