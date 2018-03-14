package command;

import stadium.Stadium;
import state.MenuContext;
import state.Player1TurnState;
import state.Player2TurnState;
import state.PlayerContext;
import ui.GameDisplay;

/**
 * Have the current pokemon attack the other pokemon
 * @author Austin Smale
 *
 */
public class AttackCommand implements Command {

	private PlayerContext state;
	private Stadium world;
	
	/**
	 * Store the current MenuContext
	 */
	public AttackCommand() {
	}

	/**
	 * If the attack command is executed find out if whose turn it is and attack the other
	 * pokemon
	 */
	public void execute(String string) {
		state = PlayerContext.getInstance();
		world = Stadium.getStadium();
		//if player 1 turn
		if(state.getState().getClass() == Player1TurnState.class) {
			if (string.equals("0"))
				world.getPlayer2().getActivePokemon().takeDamage(
						world.getPlayer1().getActivePokemon().getAttack(0).calculateDamage(world.getPlayer2()));
			if (string.equals("1"))
				world.getPlayer2().getActivePokemon().takeDamage(
						world.getPlayer1().getActivePokemon().getAttack(1).calculateDamage(world.getPlayer2()));
			if (string.equals("2"))
				world.getPlayer2().getActivePokemon().takeDamage(
						world.getPlayer1().getActivePokemon().getAttack(2).calculateDamage(world.getPlayer2()));
			if (string.equals("3"))
				world.getPlayer2().getActivePokemon().takeDamage(
						world.getPlayer1().getActivePokemon().getAttack(3).calculateDamage(world.getPlayer2()));
			state.setState(state.getPlayer2Turn());
			MenuContext mc = MenuContext.getInstance();
			mc.setState(mc.getNoMenu());
			GameDisplay.getInstance().setVisable("move", false);
		}
		//if player 2 turn
		else if(state.getState().getClass() == Player2TurnState.class) {
			if (string.equals("0"))
				world.getPlayer1().getActivePokemon().takeDamage(
						world.getPlayer2().getActivePokemon().getAttack(0).calculateDamage(world.getPlayer1()));
			if (string.equals("1"))
				world.getPlayer1().getActivePokemon().takeDamage(
						world.getPlayer2().getActivePokemon().getAttack(1).calculateDamage(world.getPlayer1()));
			if (string.equals("2"))
				world.getPlayer1().getActivePokemon().takeDamage(
						world.getPlayer2().getActivePokemon().getAttack(2).calculateDamage(world.getPlayer1()));
			if (string.equals("3"))
				world.getPlayer1().getActivePokemon().takeDamage(
						world.getPlayer2().getActivePokemon().getAttack(3).calculateDamage(world.getPlayer1()));
			state.setState(state.getPlayer1Turn());
			MenuContext mc = MenuContext.getInstance();
			GameDisplay.getInstance().setVisable("move", false);
			mc.setState(mc.getNoMenu());
		}
	}
}
