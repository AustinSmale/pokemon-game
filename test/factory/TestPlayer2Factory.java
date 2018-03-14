package factory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exception.InvalidPokemonException;
import pokemon.FirePokemon;
import pokemon.GrassPokemon;
import pokemon.WaterPokemon;
import stadium.Player;

/**
 * @author Nick Rummel
 * SWE200
 * Test Player2Factory
 */
public class TestPlayer2Factory
{
	// instances used every time
	Player p2;
	Player2Factory pf;

	/**
	 * Initializes instance variables
	 * before every test
	 */
	@Before
	public void setUp()
	{
		p2 = new Player();
		pf = new Player2Factory();
	}

	/**
	 * Tests to make sure that Player 2 can receive
	 * and use a Fire Pokemon from the factory
	 * @throws InvalidPokemonException
	 */
	@Test
	public void testCreateFirePokemon() throws InvalidPokemonException
	{
		p2.addPokemon(pf.createFirePokemon("Vulpix"));
		assertEquals(p2.getPokemon(0).getClass(), FirePokemon.class);
		assertEquals(p2.getPokemon(0).getName(), "Vulpix");
		assertEquals(p2.getPokemon(0).getHP(), 95);
		assertEquals(p2.getPokemon(0).getAttack(0).getDescription(), "Ember, FireType");
		assertEquals(p2.getPokemon(0).getAttack(0).getBaseDamage(), 20);
		assertEquals(p2.getPokemon(0).getAttack(1).getDescription(), "Fire Spin, FireType");
		assertEquals(p2.getPokemon(0).getAttack(1).getBaseDamage(), 18);
		assertEquals(p2.getPokemon(0).getAttack(2).getDescription(), "Flame Burst, FireType");
		assertEquals(p2.getPokemon(0).getAttack(2).getBaseDamage(), 35);
		assertEquals(p2.getPokemon(0).getAttack(3).getDescription(), "Flamethrower, FireType");
		assertEquals(p2.getPokemon(0).getAttack(3).getBaseDamage(), 45);
	}

	/**
	 * Tests to make sure that Player 2 can receive
	 * and use a Water Pokemon from the factory
	 * @throws InvalidPokemonException
	 */
	@Test
	public void testCreateWaterPokemon() throws InvalidPokemonException
	{
		p2.addPokemon(pf.createWaterPokemon("Poliwag"));
		assertEquals(p2.getPokemon(0).getClass(), WaterPokemon.class);
		assertEquals(p2.getPokemon(0).getName(), "Poliwag");
		assertEquals(p2.getPokemon(0).getHP(), 100);
		assertEquals(p2.getPokemon(0).getAttack(0).getDescription(), "Water Gun, WaterType");
		assertEquals(p2.getPokemon(0).getAttack(0).getBaseDamage(), 20);
		assertEquals(p2.getPokemon(0).getAttack(1).getDescription(), "Bubble, WaterType");
		assertEquals(p2.getPokemon(0).getAttack(1).getBaseDamage(), 20);
		assertEquals(p2.getPokemon(0).getAttack(2).getDescription(), "Bubble Beam, WaterType");
		assertEquals(p2.getPokemon(0).getAttack(2).getBaseDamage(), 33);
		assertEquals(p2.getPokemon(0).getAttack(3).getDescription(), "Hydro Pump, WaterType");
		assertEquals(p2.getPokemon(0).getAttack(3).getBaseDamage(), 55);
	}

	/**
	 * Tests to make sure that Player 2 can receive
	 * and use a Grass Pokemon from the factory
	 * @throws InvalidPokemonException
	 */
	@Test
	public void testCreateGrassPokemon() throws InvalidPokemonException
	{
		p2.addPokemon(pf.createGrassPokemon("Caterpie"));
		assertEquals(p2.getPokemon(0).getClass(), GrassPokemon.class);
		assertEquals(p2.getPokemon(0).getName(), "Caterpie");
		assertEquals(p2.getPokemon(0).getHP(), 113);
		assertEquals(p2.getPokemon(0).getAttack(0).getDescription(), "Bug Bite, GrassType");
		assertEquals(p2.getPokemon(0).getAttack(0).getBaseDamage(), 30);
		assertEquals(p2.getPokemon(0).getAttack(1).getDescription(), "Giga Drain, GrassType");
		assertEquals(p2.getPokemon(0).getAttack(1).getBaseDamage(), 38);
		assertEquals(p2.getPokemon(0).getAttack(2).getDescription(), "Solar Beam, GrassType");
		assertEquals(p2.getPokemon(0).getAttack(2).getBaseDamage(), 60);
		assertEquals(p2.getPokemon(0).getAttack(3).getDescription(), "Bug Buzz, GrassType");
		assertEquals(p2.getPokemon(0).getAttack(3).getBaseDamage(), 45);
	}

}
