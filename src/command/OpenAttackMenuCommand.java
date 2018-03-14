package command;

import ui.GameDisplay;

/**
 * Command to open the attack menu
 * @author Austin Smale
 *
 */
public class OpenAttackMenuCommand implements Command {
	
	/**
	 * Open move menu and close pokemon menu
	 */
	@Override
	public void execute(String string) {
		GameDisplay gd = GameDisplay.getInstance();
		gd.setVisable("move", true);
		gd.setVisable("pokemon", false);
	}
}
