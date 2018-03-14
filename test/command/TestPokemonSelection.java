package command;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.FirePokemon;
import pokemon.GrassPokemon;
import pokemon.Pokemon;
import pokemon.WaterPokemon;
import stadium.Stadium;
import state.MenuContext;
import state.PlayerContext;
import state.PlayerState;

/**
 * Test that the game starts after the pokemon are created
 * @author Austin
 *
 */
public class TestPokemonSelection {

	/**
	 * Test that the game starts at the start menu
	 */
	@Test
	public void testPokemonSelectionCommand() {
		PokemonSelectionCommand ps = new PokemonSelectionCommand();
		Stadium.clearStadium();
		Stadium s = Stadium.getStadium();
		//set player 1 pokemon
		Pokemon p1 = new FirePokemon("charmander", 100);
		Pokemon p2 = new WaterPokemon("blastoise", 100);
		Pokemon p3 = new GrassPokemon("caterpie", 100);
		s.getPlayer1().addPokemon(p1);
		s.getPlayer1().addPokemon(p2);
		s.getPlayer1().addPokemon(p3);
		s.getPlayer1().setActivePokemon(p1);
		MenuContext.getInstance().setState(MenuContext.getInstance().getAttackMenu());
		PlayerContext.getInstance().setState(PlayerContext.getInstance().getPlayer1Turn());
		ps.execute("1");
		assertEquals(WaterPokemon.class, s.getPlayer1().getActivePokemon().getClass());
		PlayerContext.getInstance().setState(PlayerContext.getInstance().getPlayer1Turn());
	}

}
