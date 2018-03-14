package factory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exception.InvalidPokemonException;
import pokemon.Pokemon;

/**
 * @author Nick Rummel
 * SWE200
 * Tests for GrassPokemon2, a concrete
 * product of the GrassPokemonProduct factory
 */
public class TestGrassPokemon2
{
	// instances used every time
	GrassPokemon2 product;
	Pokemon pokemon;

	/**
	 * Initializes a new GrassPokemon2
	 * object before each test and makes
	 * the Pokemon null
	 */
	@Before
	public void setUp()
	{
		product = new GrassPokemon2();
		pokemon = null;
	}

	/**
	 * Make sure Bulbasaur is created correctly
	 * @throws InvalidPokemonException
	 */
	@Test
	public void testBulbasaur() throws InvalidPokemonException
	{
		pokemon = product.createGrassPokemon("Bulbasaur");
		assertNotNull(pokemon);
		assertEquals(pokemon.getName(), "Bulbasaur");
		assertEquals(pokemon.getHP(), 113);
		assertEquals(pokemon.getAttack(0).getDescription(), "Vine Whip, GrassType");
		assertEquals(pokemon.getAttack(0).getBaseDamage(), 23);
		assertEquals(pokemon.getAttack(1).getDescription(), "Razor Leaf, GrassType");
		assertEquals(pokemon.getAttack(1).getBaseDamage(), 28);
		assertEquals(pokemon.getAttack(2).getDescription(), "Magical Leaf, GrassType");
		assertEquals(pokemon.getAttack(2).getBaseDamage(), 30);
		assertEquals(pokemon.getAttack(3).getDescription(), "Bullet Seed, GrassType");
		assertEquals(pokemon.getAttack(3).getBaseDamage(), 13);
	}

	/**
	 * Make sure Ivysaur is created correctly
	 * @throws InvalidPokemonException
	 */
	@Test
	public void testIvysaur() throws InvalidPokemonException
	{
		pokemon = product.createGrassPokemon("Ivysaur");
		assertNotNull(pokemon);
		assertEquals(pokemon.getName(), "Ivysaur");
		assertEquals(pokemon.getHP(), 150);
		assertEquals(pokemon.getAttack(0).getDescription(), "Razor Leaf, GrassType");
		assertEquals(pokemon.getAttack(0).getBaseDamage(), 28);
		assertEquals(pokemon.getAttack(1).getDescription(), "Magical Leaf, GrassType");
		assertEquals(pokemon.getAttack(1).getBaseDamage(), 30);
		assertEquals(pokemon.getAttack(2).getDescription(), "Seed Bomb, GrassType");
		assertEquals(pokemon.getAttack(2).getBaseDamage(), 40);
		assertEquals(pokemon.getAttack(3).getDescription(), "Giga Drain, GrassType");
		assertEquals(pokemon.getAttack(3).getBaseDamage(), 38);
	}

	/**
	 * Make sure Venusaur is created correctly
	 * @throws InvalidPokemonException
	 */
	@Test
	public void testVenusaur() throws InvalidPokemonException
	{
		pokemon = product.createGrassPokemon("Venusaur");
		assertNotNull(pokemon);
		assertEquals(pokemon.getName(), "Venusaur");
		assertEquals(pokemon.getHP(), 200);
		assertEquals(pokemon.getAttack(0).getDescription(), "Seed Bomb, GrassType");
		assertEquals(pokemon.getAttack(0).getBaseDamage(), 40);
		assertEquals(pokemon.getAttack(1).getDescription(), "Petal Blizzard, GrassType");
		assertEquals(pokemon.getAttack(1).getBaseDamage(), 45);
		assertEquals(pokemon.getAttack(2).getDescription(), "Solar Beam, GrassType");
		assertEquals(pokemon.getAttack(2).getBaseDamage(), 60);
		assertEquals(pokemon.getAttack(3).getDescription(), "Leaf Storm, GrassType");
		assertEquals(pokemon.getAttack(3).getBaseDamage(), 65);
	}

	/**
	 * Make sure Caterpie is created correctly
	 * @throws InvalidPokemonException
	 */
	@Test
	public void testCaterpie() throws InvalidPokemonException
	{
		pokemon = product.createGrassPokemon("Caterpie");
		assertNotNull(pokemon);
		assertEquals(pokemon.getName(), "Caterpie");
		assertEquals(pokemon.getHP(), 113);
		assertEquals(pokemon.getAttack(0).getDescription(), "Bug Bite, GrassType");
		assertEquals(pokemon.getAttack(0).getBaseDamage(), 30);
		assertEquals(pokemon.getAttack(1).getDescription(), "Giga Drain, GrassType");
		assertEquals(pokemon.getAttack(1).getBaseDamage(), 38);
		assertEquals(pokemon.getAttack(2).getDescription(), "Solar Beam, GrassType");
		assertEquals(pokemon.getAttack(2).getBaseDamage(), 60);
		assertEquals(pokemon.getAttack(3).getDescription(), "Bug Buzz, GrassType");
		assertEquals(pokemon.getAttack(3).getBaseDamage(), 45);
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
		pokemon = product.createGrassPokemon("Bulbasaur ");
		assertNull(pokemon);

		pokemon = product.createGrassPokemon(" Bulbasaur");
		assertNull(pokemon);
	}

}
