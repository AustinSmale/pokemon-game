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

public class TestBasicMove
{
	/**
	 * Tests that the move was created and returns the proper description
	 * and base damage.
	 */
	@Test
	public void testInitialization()
	{
		AttackMove move = new Move("Basic Move", 50);
		assertEquals(move.getBaseDamage(), 50);
		assertEquals(move.getDescription(), "Basic Move");
	}

	/**
	 * Tests that the basic moves deals the base damage to all types.
	 * Because it shouldn't be strong or weak to anything.
	 */
	@Test
	public void testCalculateDamage()
	{
		Player player1 = new Player();
		Pokemon grassDude = new GrassPokemon("Grass Dude", 100);
		Pokemon fireDude = new FirePokemon("Fire Dude", 100);
		Pokemon waterDude = new WaterPokemon("Water Dude", 100);
		AttackMove move = new Move("Basic Move", 50);
		player1.addPokemon(grassDude);
		player1.addPokemon(fireDude);
		player1.addPokemon(waterDude);
		player1.setActivePokemon(grassDude);
		assertEquals(move.calculateDamage(player1), 50);
		player1.setActivePokemon(fireDude);
		assertEquals(move.calculateDamage(player1), 50);
		player1.setActivePokemon(waterDude);
		assertEquals(move.calculateDamage(player1), 50);
		assertEquals(move.getBaseDamage(), 50);
	}
}
