package factory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exception.InvalidPokemonException;
import pokemon.Pokemon;

/**
 * @author Nick Rummel
 * SWE200
 * Tests for WaterPokemon2, a concrete
 * product of the WaterPokemonProduct factory
 */
public class TestWaterPokemon2
{
	// instances used for every test
	WaterPokemon2 product;
	Pokemon pokemon;

	/**
	 * Initializes a new WaterPokemon2
	 * object before each test and makes
	 * the Pokemon null
	 */
	@Before
	public void setUp()
	{
		product = new WaterPokemon2();
		pokemon = null;
	}

	/**
	 * Make sure Squirtle is created correctly
	 * @throws InvalidPokemonException
	 */
	@Test
	public void testSquirtle() throws InvalidPokemonException
	{
		pokemon = product.createWaterPokemon("Squirtle");
		assertNotNull(pokemon);
		assertEquals(pokemon.getName(), "Squirtle");
		assertEquals(pokemon.getHP(), 110);
		assertEquals(pokemon.getAttack(0).getDescription(), "Water Gun, WaterType");
		assertEquals(pokemon.getAttack(0).getBaseDamage(), 20);
		assertEquals(pokemon.getAttack(1).getDescription(), "Bubble, WaterType");
		assertEquals(pokemon.getAttack(1).getBaseDamage(), 20);
		assertEquals(pokemon.getAttack(2).getDescription(), "Water Pulse, WaterType");
		assertEquals(pokemon.getAttack(2).getBaseDamage(), 30);
		assertEquals(pokemon.getAttack(3).getDescription(), "Aqua Tail, WaterType");
		assertEquals(pokemon.getAttack(3).getBaseDamage(), 45);
	}

	/**
	 * Make sure Wartortle is created correctly
	 * @throws InvalidPokemonException
	 */
	@Test
	public void testWartortle() throws InvalidPokemonException
	{
		pokemon = product.createWaterPokemon("Wartortle");
		assertNotNull(pokemon);
		assertEquals(pokemon.getName(), "Wartortle");
		assertEquals(pokemon.getHP(), 148);
		assertEquals(pokemon.getAttack(0).getDescription(), "Water Pulse, WaterType");
		assertEquals(pokemon.getAttack(0).getBaseDamage(), 30);
		assertEquals(pokemon.getAttack(1).getDescription(), "Aqua Tail, WaterType");
		assertEquals(pokemon.getAttack(1).getBaseDamage(), 45);
		assertEquals(pokemon.getAttack(2).getDescription(), "Surf, WaterType");
		assertEquals(pokemon.getAttack(2).getBaseDamage(), 45);
		assertEquals(pokemon.getAttack(3).getDescription(), "Waterfall, WaterType");
		assertEquals(pokemon.getAttack(3).getBaseDamage(), 40);
	}

	/**
	 * Make sure Blastoise is created correctly
	 * @throws InvalidPokemonException
	 */
	@Test
	public void testBlastoise() throws InvalidPokemonException
	{
		pokemon = product.createWaterPokemon("Blastoise");
		assertNotNull(pokemon);
		assertEquals(pokemon.getName(), "Blastoise");
		assertEquals(pokemon.getHP(), 198);
		assertEquals(pokemon.getAttack(0).getDescription(), "Aqua Tail, WaterType");
		assertEquals(pokemon.getAttack(0).getBaseDamage(), 45);
		assertEquals(pokemon.getAttack(1).getDescription(), "Surf, WaterType");
		assertEquals(pokemon.getAttack(1).getBaseDamage(), 45);
		assertEquals(pokemon.getAttack(2).getDescription(), "Muddy Water, WaterType");
		assertEquals(pokemon.getAttack(2).getBaseDamage(), 45);
		assertEquals(pokemon.getAttack(3).getDescription(), "Hydro Pump, WaterType");
		assertEquals(pokemon.getAttack(3).getBaseDamage(), 55);
	}

	/**
	 * Make sure Poliwag is created correctly
	 * @throws InvalidPokemonException
	 */
	@Test
	public void testPoliwag() throws InvalidPokemonException
	{
		pokemon = product.createWaterPokemon("Poliwag");
		assertNotNull(pokemon);
		assertEquals(pokemon.getName(), "Poliwag");
		assertEquals(pokemon.getHP(), 100);
		assertEquals(pokemon.getAttack(0).getDescription(), "Water Gun, WaterType");
		assertEquals(pokemon.getAttack(0).getBaseDamage(), 20);
		assertEquals(pokemon.getAttack(1).getDescription(), "Bubble, WaterType");
		assertEquals(pokemon.getAttack(1).getBaseDamage(), 20);
		assertEquals(pokemon.getAttack(2).getDescription(), "Bubble Beam, WaterType");
		assertEquals(pokemon.getAttack(2).getBaseDamage(), 33);
		assertEquals(pokemon.getAttack(3).getDescription(), "Hydro Pump, WaterType");
		assertEquals(pokemon.getAttack(3).getBaseDamage(), 55);
	}

	/**
	 * Make sure incorrectly entered/misspelled
	 * Pokemon don't get created
	 * @throws InvalidPokemonException if no Pokemon is found
	 */
	@Test (expected = InvalidPokemonException.class)
	public void testNoPokemonFound() throws InvalidPokemonException
	{
		// won't find Pokemon if spelling doesn't match
		pokemon = product.createWaterPokemon("Squirtle ");
		assertNull(pokemon);

		pokemon = product.createWaterPokemon(" Squirtle");
		assertNull(pokemon);
	}



}
