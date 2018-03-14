package command;

import ui.GameDisplay;
/**
 * open the choose pokemon menu
 * @author Austin Smale
 *
 */
public class OpenPokemonMenuCommand implements Command {

	/**
	 * Open the pokemon menu and close the move menu
	 */
	@Override
	public void execute(String string) {
		GameDisplay gd = GameDisplay.getInstance();
		gd.setVisable("pokemon", true);
		gd.setVisable("move", false);
	}

}
