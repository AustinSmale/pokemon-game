package stadium;

import static org.junit.Assert.*;

import org.junit.Test;

import attacks.*;
import pokemon.*;

public class TestPlayer
{
	@Test
	public void testInitialization()
	{
		Player player1 = new Player();
		assertEquals(player1.getActivePokemon(), null);
		assertTrue(player1.getList() != null);
	}

	@Test
	public void testAddPokemon()
	{
		Player player1 = new Player();
		Pokemon charizard = new FirePokemon("Charizard", 200);
		player1.addPokemon(charizard);
		assertEquals(charizard, player1.getPokemon(0));
	}

	@Test
	public void testActivePokemon()
	{
		Player player1 = new Player();
		Pokemon charizard = new FirePokemon("Charizard", 200);
		Pokemon blastoise = new WaterPokemon("Blastoise", 200);
		player1.addPokemon(charizard);
		player1.addPokemon(blastoise);
		player1.setActivePokemon(charizard);
		assertEquals(charizard, player1.getActivePokemon());
		player1.setActivePokemon(blastoise);
		assertEquals(blastoise, player1.getActivePokemon());
	}

	@Test
	public void testAttack()
	{
		Player player1 = new Player();
		Player player2 = new Player();
		Pokemon blastoise = new WaterPokemon("Blastoise", 200);
		Pokemon charizard = new FirePokemon("Charizard", 200);
		AttackMove fireBlast = new Move("Fire Blast", 50);
		player1.addPokemon(charizard);
		player1.setActivePokemon(charizard);
		charizard.setAttack(fireBlast, 0);
		player2.addPokemon(blastoise);
		player2.setActivePokemon(blastoise);
		player1.attack(player2, 0);
	}
	
	@Test
	public void testPokemonChangedOnKO()
	{
		Player player1 = new Player();
		Player player2 = new Player();
		Pokemon blastoise = new WaterPokemon("Blastoise", 200);
		Pokemon charizard = new FirePokemon("Charizard", 200);
		Pokemon venusaur = new GrassPokemon("Venusaur", 200);
		AttackMove waterPulse = new Move("Water Pulse", 100);
		waterPulse = new WaterType(waterPulse);
		player1.addPokemon(blastoise);
		player1.setActivePokemon(blastoise);
		blastoise.setAttack(waterPulse, 0);
		player2.addPokemon(charizard);
		player2.addPokemon(venusaur);
		player2.setActivePokemon(charizard);
		player1.attack(player2, 0);
		assertEquals(venusaur, player2.getActivePokemon());
	}
	
	/**
	 * Test that rest re-initialized pokemon array to be full of nulls
	 * @author Elisabeth Ostrow
	 */
	@Test
	public void testReset(){
		Player p = new Player();
		//put a pokemon in to sully the array
		Pokemon k = new WaterPokemon("Poke", 100);
		p.addPokemon(k);
		
		p.reset();
		
		//now the array list should be squeaky clean and it's size should be 0
		assertEquals(0, p.pokemon.size());
	}
}
