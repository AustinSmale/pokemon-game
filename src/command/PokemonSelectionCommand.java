package command;

import stadium.Stadium;
import state.MenuContext;
import state.PlayerContext;
import ui.GameDisplay;
/**
 * Pokemon Selection Command, select the pokemon at the beginning of the game
 * @author Austin Smale
 *
 */
public class PokemonSelectionCommand implements Command {

	/**
	 * when the game starts no menu should open but the pokemon selection
	 */
	@Override
	public void execute(String string) {
		Stadium s = Stadium.getStadium();
		MenuContext mc = MenuContext.getInstance();
		PlayerContext state = PlayerContext.getInstance();
		//if player 1 turn
		if(state.getState() == state.getPlayer1Turn()) {
			if(string.equals("0"))
				s.getPlayer1().setActivePokemon(s.getPlayer1().getPokemon(0));
			if(string.equals("1"))
				s.getPlayer1().setActivePokemon(s.getPlayer1().getPokemon(1));
			if(string.equals("2"))
				s.getPlayer1().setActivePokemon(s.getPlayer1().getPokemon(2));
			state.setState(state.getPlayer2Turn());
			mc.setState(mc.getNoMenu());
			GameDisplay.getInstance().setVisable("pokemon", false);
		}
		//if player 2 turn
		else if(state.getState() == state.getPlayer2Turn()) {
			if(string.equals("0"))
				s.getPlayer2().setActivePokemon(s.getPlayer2().getPokemon(0));
			if(string.equals("1"))
				s.getPlayer2().setActivePokemon(s.getPlayer2().getPokemon(1));
			if(string.equals("2"))
				s.getPlayer2().setActivePokemon(s.getPlayer2().getPokemon(2));
			state.setState(state.getPlayer1Turn());
			mc.setState(mc.getNoMenu());
			GameDisplay.getInstance().setVisable("pokemon", false);
		}
	}
}
