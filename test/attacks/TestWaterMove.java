package attacks;
/**
 * @author Nathaniel Manning
 */
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pokemon.FirePokemon;
import pokemon.GrassPokemon;
import pokemon.Pokemon;
import pokemon.WaterPokemon;
import stadium.Player;

public class TestWaterMove
{
	/**
	 * Tests that the move was created and returns the proper description.
	 */
	@Test
	public void testInitialization()
	{
		AttackMove move = new Move("Water Gun", 50);
		move = new WaterType(move);
		assertEquals(move.getBaseDamage(), 50);
		assertEquals(move.getDescription(), "Water Gun, WaterType");
	}

	/**
	 * Tests that the correct damage is calculated depending on the
	 * type of pokemon that the enemy trainer is currently using.
	 */
	@Test
	public void testCalculateDamage()
	{
		Player player1 = new Player();
		Pokemon grassDude = new GrassPokemon("Grass Dude", 100);
		Pokemon fireDude = new FirePokemon("Fire Dude", 100);
		Pokemon waterDude = new WaterPokemon("Water Dude", 100);
		AttackMove move = new Move("Water Gun", 50);
		move = new WaterType(move);
		player1.addPokemon(grassDude);
		player1.addPokemon(fireDude);
		player1.addPokemon(waterDude);
		player1.setActivePokemon(grassDude);
		assertEquals(move.calculateDamage(player1), 25);
		player1.setActivePokemon(fireDude);
		assertEquals(move.calculateDamage(player1), 100);
		player1.setActivePokemon(waterDude);
		assertEquals(move.calculateDamage(player1), 50);
		assertEquals(move.getBaseDamage(), 50);
	}
}
