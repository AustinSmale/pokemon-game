package command;

import state.MenuContext;
import state.PlayerContext;
import ui.GameDisplay;

/**
 * End the players turn
 * @author Austin Smale
 *
 */
public class EndTurnCommand implements Command {

	private PlayerContext state;
	/**
	 * Store the state
	 */
	public EndTurnCommand() {
		state = PlayerContext.getInstance();
	}

	/**
	 * Switch the player turn and close both menus
	 */
	@Override
	public void execute(String string) {
		//if player 1 turn switch to player 2 turn
		if(state.getState() == state.getPlayer1Turn()) {
			state.setState(state.getPlayer2Turn());
			MenuContext mc = MenuContext.getInstance();
			mc.setState(mc.getNoMenu());
			GameDisplay gd = GameDisplay.getInstance();
			gd.setVisable("attack", false);
			gd.setVisable("pokemon", false);
		}
		//if player 2 turn switch to player 1 turn
		else if(state.getState() == state.getPlayer2Turn()) {
			state.setState(state.getPlayer1Turn());
			MenuContext mc = MenuContext.getInstance();
			mc.setState(mc.getNoMenu());
			GameDisplay gd = GameDisplay.getInstance();
			gd.setVisable("attack", false);
			gd.setVisable("pokemon", false);
		}
	}

}
