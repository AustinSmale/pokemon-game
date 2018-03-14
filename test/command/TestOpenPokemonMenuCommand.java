package command;

import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Test;

import exception.InvalidPokemonException;
import factory.Player1Factory;
import factory.Player2Factory;
import stadium.Stadium;
import state.PlayerContext;
/**
 * Test to see that pokemon menu opens with displaying player 1 and 2's pokemon
 * @author Austin
 *
 */
public class TestOpenPokemonMenuCommand {

	/**
	 * Test to see that player 1's pokemon show up properly and disable the button
	 * if they are dead
	 */
	@Test
	public void testPlayer1Pokemon() {
		OpenPokemonMenuCommand opm = new OpenPokemonMenuCommand();
		Player1Factory p1f = new Player1Factory();
		//create pokemon
		try {
			Stadium.getStadium().getPlayer1().addPokemon(p1f.createFirePokemon("Charmander"));
		} catch (InvalidPokemonException e1) {
			e1.printStackTrace();
		}
		try {
			Stadium.getStadium().getPlayer1().addPokemon(p1f.createWaterPokemon("Poliwag"));
		} catch (InvalidPokemonException e) {
			e.printStackTrace();
		}
		try {
			Stadium.getStadium().getPlayer1().addPokemon(p1f.createGrassPokemon("Caterpie"));
		} catch (InvalidPokemonException e) {
			e.printStackTrace();
		}
		//set player 1 turn
		PlayerContext.getInstance().setState(PlayerContext.getInstance().getPlayer1Turn());
		opm.execute("");
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Does the game show correct pokemon for player 1?"));
		
		//kill poliwag
		Stadium.getStadium().getPlayer1().getPokemon(1).setHp(0);
		opm.execute("");
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Does the game disable the poliwag button?"));

	}
	
	/**
	 * Test to see that player 1's pokemon show up properly
	 */
	@Test
	public void testPlayer2Pokemon() {
		OpenPokemonMenuCommand opm = new OpenPokemonMenuCommand();
		Player2Factory p2f = new Player2Factory();
		//create pokemon
		try {
			Stadium.getStadium().getPlayer2().addPokemon(p2f.createFirePokemon("Charizard"));
		} catch (InvalidPokemonException e1) {
			e1.printStackTrace();
		}
		try {
			Stadium.getStadium().getPlayer2().addPokemon(p2f.createWaterPokemon("Blastoise"));
		} catch (InvalidPokemonException e) {
			e.printStackTrace();
		}
		try {
			Stadium.getStadium().getPlayer2().addPokemon(p2f.createGrassPokemon("Bulbasaur"));
		} catch (InvalidPokemonException e) {
			e.printStackTrace();
		}
		//set player 2 turn
		PlayerContext.getInstance().setState(PlayerContext.getInstance().getPlayer2Turn());
		opm.execute("");
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Does the game show correct pokemon for player 2?"));
	}


}
