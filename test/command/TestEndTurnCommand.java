package command;

import static org.junit.Assert.*;

import org.junit.Test;

import state.MenuContext;
import state.PlayerContext;
/**
 * Test that end turn switches the player context and menu context
 * @author Austin
 *
 */
public class TestEndTurnCommand {

	/**
	 * Test the ending of player 1
	 */
	@Test
	public void testEndTurnPlayer1() {
		EndTurnCommand et = new EndTurnCommand();
		PlayerContext.getInstance().setState(PlayerContext.getInstance().getPlayer1Turn());
		et.execute("");
		//Player Context was switched
		assertEquals(PlayerContext.getInstance().getState(), PlayerContext.getInstance().getPlayer2Turn());
		//Menu Conext was switched
		assertEquals(MenuContext.getInstance().getState(), MenuContext.getInstance().getNoMenu());
	}
	/**
	 * Test the ending of player 2
	 */
	@Test
	public void testEndTurnPlayer2() {
		EndTurnCommand et = new EndTurnCommand();
		PlayerContext.getInstance().setState(PlayerContext.getInstance().getPlayer2Turn());
		et.execute("");
		//Player Context was switched
		assertEquals(PlayerContext.getInstance().getState(), PlayerContext.getInstance().getPlayer1Turn());
		//Menu Conext was switched
		assertEquals(MenuContext.getInstance().getState(), MenuContext.getInstance().getNoMenu());
	}

}
