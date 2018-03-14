package command;

import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Test;

import attacks.FireType;
import attacks.Move;
import pokemon.FirePokemon;
import pokemon.Pokemon;
import stadium.Stadium;
import state.PlayerContext;
/**
 * Test to see if the attack menu opens up
 * @author Austin Smale
 *
 */
public class TestOpenAttackMenuCommand {

	/**
	 * Test to see if the attack menu opens up and displays player1 moves
	 */
	@Test
	public void testPlayer1Moves() {
		OpenAttackMenuCommand oam = new OpenAttackMenuCommand();
		Pokemon p1 = new FirePokemon("charmander", 100);
		p1.setAttack(new FireType(new Move("Test Move 1 P1", 5)), 0);
		p1.setAttack(new FireType(new Move("Test Move 2 P1", 10)), 1);
		p1.setAttack(new FireType(new Move("Test Move 3 P1", 15)), 2);
		p1.setAttack(new FireType(new Move("Test Move 4 P1", 20)), 3);
		Stadium.getStadium().getPlayer1().addPokemon(p1);
		Stadium.getStadium().getPlayer1().setActivePokemon(p1);
		PlayerContext.getInstance().setState(PlayerContext.getInstance().getPlayer1Turn());
		oam.execute("");
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Does the game show correct moves for player 1?"));
	}
	
	/**
	 * Test to see if the attack menu opens up and displays player2 moves
	 */
	@Test
	public void testPlayer2Moves() {
		OpenAttackMenuCommand oam = new OpenAttackMenuCommand();
		Pokemon p2 = new FirePokemon("charmander", 100);
		p2.setAttack(new FireType(new Move("Test Move 1 P2", 5)), 0);
		p2.setAttack(new FireType(new Move("Test Move 2 P2", 10)), 1);
		p2.setAttack(new FireType(new Move("Test Move 3 P2", 15)), 2);
		p2.setAttack(new FireType(new Move("Test Move 4 P2", 20)), 3);
		Stadium.getStadium().getPlayer2().addPokemon(p2);
		Stadium.getStadium().getPlayer2().setActivePokemon(p2);
		PlayerContext.getInstance().setState(PlayerContext.getInstance().getPlayer2Turn());
		oam.execute("");
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Does the game show correct moves for player 2?"));
	}

}
