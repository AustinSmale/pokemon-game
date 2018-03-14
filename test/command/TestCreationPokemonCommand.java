package command;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.FirePokemon;
import stadium.Stadium;
import state.PlayerContext;
/**
 * Test the creation of pokemon
 * @author Austin Smale
 *
 */
public class TestCreationPokemonCommand {

	/**
	 * Test to see if player 1 gets correct pokemon
	 */
	@Test
	public void testPlayer1Creation() {
		CreatePokemonCommand cp = new CreatePokemonCommand();
		//set player 1 turn
		PlayerContext.getInstance().setState(PlayerContext.getInstance().getPlayer1Turn());
		for(int i=0; i<3; i++)
			cp.execute("fire", "charmander");
		//check to see if the player has 3 pokemon
		for(int i=0; i<3; i++)
			assertEquals(FirePokemon.class, Stadium.getStadium().getPlayer1().getPokemon(i).getClass());
	}
	
	/**
	 * Test to see that player 2 gets correct pokemon
	 */
	@Test
	public void testPlayer2Creation() {
		CreatePokemonCommand cp = new CreatePokemonCommand();
		//set player 1 turn
		PlayerContext.getInstance().setState(PlayerContext.getInstance().getPlayer2Turn());
		for(int i=0; i<3; i++)
			cp.execute("fire", "charmander");
		//check to see if the player has 3 pokemon
		for(int i=0; i<3; i++)
			assertNotNull(Stadium.getStadium().getPlayer2().getPokemon(i));
	}
}
