package factory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exception.InvalidPokemonException;
import pokemon.Pokemon;

/**
 * @author Nick Rummel
 * SWE200
 * Tests for FirePokemon2, a concrete
 * product of the FirePokemonProduct factory
 */
public class TestFirePokemon2
{
	// instances used every time
	FirePokemon1 product;
	Pokemon pokemon;

	/**
	 * Initializes a new FirePokemon2
	 * object before each test and makes
	 * the Pokemon null
	 */
	@Before
	public void setUp()
	{
		product = new FirePokemon1();
		pokemon = null;
	}

	/**
	 * Make sure Charmander is created correctly
	 * @throws InvalidPokemonException
	 */
	@Test
	public void testCharmander() throws InvalidPokemonException
	{
		pokemon = product.createFirePokemon("Charmander");
		assertNotNull(pokemon);
		assertEquals(pokemon.getName(), "Charmander");
		assertEquals(pokemon.getHP(), 98);
		assertEquals(pokemon.getAttack(0).getDescription(), "Ember, FireType");
		assertEquals(pokemon.getAttack(0).getBaseDamage(), 20);
		assertEquals(pokemon.getAttack(1).getDescription(), "Fire Fang, FireType");
		assertEquals(pokemon.getAttack(1).getBaseDamage(), 33);
		assertEquals(pokemon.getAttack(2).getDescription(), "Flame Burst, FireType");
		assertEquals(pokemon.getAttack(2).getBaseDamage(), 35);
		assertEquals(pokemon.getAttack(3).getDescription(), "Fire Spin, FireType");
		assertEquals(pokemon.getAttack(3).getBaseDamage(), 18);
	}

	/**
	 * Make sure Charmeleon is created correctly
	 * @throws InvalidPokemonException
	 */
	@Test
	public void testCharmeleon() throws InvalidPokemonException
	{
		pokemon = product.createFirePokemon("Charmeleon");
		assertNotNull(pokemon);
		assertEquals(pokemon.getName(), "Charmeleon");
		assertEquals(pokemon.getHP(), 145);
		assertEquals(pokemon.getAttack(0).getDescription(), "Fire Fang, FireType");
		assertEquals(pokemon.getAttack(0).getBaseDamage(), 33);
		assertEquals(pokemon.getAttack(1).getDescription(), "Flame Burst, FireType");
		assertEquals(pokemon.getAttack(1).getBaseDamage(), 35);
		assertEquals(pokemon.getAttack(2).getDescription(), "Flamethrower, FireType");
		assertEquals(pokemon.getAttack(2).getBaseDamage(), 45);
		assertEquals(pokemon.getAttack(3).getDescription(), "Inferno, FireType");
		assertEquals(pokemon.getAttack(3).getBaseDamage(), 50);
	}

	/**
	 * Make sure Charizard is created correctly
	 * @throws InvalidPokemonException
	 */
	@Test
	public void testCharizard() throws InvalidPokemonException
	{
		pokemon = product.createFirePokemon("Charizard");
		assertNotNull(pokemon);
		assertEquals(pokemon.getName(), "Charizard");
		assertEquals(pokemon.getHP(), 195);
		assertEquals(pokemon.getAttack(0).getDescription(), "Inferno, FireType");
		assertEquals(pokemon.getAttack(0).getBaseDamage(), 50);
		assertEquals(pokemon.getAttack(1).getDescription(), "Overheat, FireType");
		assertEquals(pokemon.getAttack(1).getBaseDamage(), 65);
		assertEquals(pokemon.getAttack(2).getDescription(), "Flamethrower, FireType");
		assertEquals(pokemon.getAttack(2).getBaseDamage(), 45);
		assertEquals(pokemon.getAttack(3).getDescription(), "Fire Blast, FireType");
		assertEquals(pokemon.getAttack(3).getBaseDamage(), 55);
	}

	/**
	 * Make sure Vulpix is created correctly
	 * @throws InvalidPokemonException
	 */
	@Test
	public void testVulpix() throws InvalidPokemonException
	{
		pokemon = product.createFirePokemon("Vulpix");
		assertNotNull(pokemon);
		assertEquals(pokemon.getName(), "Vulpix");
		assertEquals(pokemon.getHP(), 95);
		assertEquals(pokemon.getAttack(0).getDescription(), "Ember, FireType");
		assertEquals(pokemon.getAttack(0).getBaseDamage(), 20);
		assertEquals(pokemon.getAttack(1).getDescription(), "Fire Spin, FireType");
		assertEquals(pokemon.getAttack(1).getBaseDamage(), 18);
		assertEquals(pokemon.getAttack(2).getDescription(), "Flame Burst, FireType");
		assertEquals(pokemon.getAttack(2).getBaseDamage(), 35);
		assertEquals(pokemon.getAttack(3).getDescription(), "Flamethrower, FireType");
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
		pokemon = product.createFirePokemon("Charmander ");
		assertNull(pokemon);

		pokemon = product.createFirePokemon(" Charmander");
		assertNull(pokemon);
	}
}
