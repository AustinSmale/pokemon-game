package attacks;
/**
 * @author Nathaniel Manning
 */
import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.*;
import stadium.Player;

public class TestFireMove
{
	/**
	 * Tests that the move was created and returns the description
	 * for the proper type and has the correct accuracy.
	 */
	@Test
	public void testInitialization()
	{
		AttackMove move = new Move("Fire Blast", 50);
		move = new FireType(move);
		assertEquals(move.getBaseDamage(), 50);
		assertEquals(move.getDescription(), "Fire Blast, FireType");
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
		AttackMove move = new Move("Fire Blast", 50);
		move = new FireType(move);
		player1.addPokemon(grassDude);
		player1.addPokemon(fireDude);
		player1.addPokemon(waterDude);
		player1.setActivePokemon(grassDude);
		assertEquals(move.calculateDamage(player1), 100);
		player1.setActivePokemon(fireDude);
		assertEquals(move.calculateDamage(player1), 50);
		player1.setActivePokemon(waterDude);
		assertEquals(move.calculateDamage(player1), 25);
		assertEquals(move.getBaseDamage(), 50);
	}
}
