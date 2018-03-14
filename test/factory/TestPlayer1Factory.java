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
 * Tests Player1Factory class
 */
public class TestPlayer1Factory
{
	// instances used every time
	Player p1;
	Player1Factory pf;

	/**
	 * Initializes instance variables
	 * before every test
	 */
	@Before
	public void setUp()
	{
		p1 = new Player();
		pf = new Player1Factory();
	}

	/**
	 * Tests to make sure that Player 1 can receive
	 * and use a Fire Pokemon from the factory
	 * @throws InvalidPokemonException
	 */
	@Test
	public void testCreateFirePokemon() throws InvalidPokemonException
	{
		p1.addPokemon(pf.createFirePokemon("Charmander"));
		assertEquals(p1.getPokemon(0).getClass(), FirePokemon.class);
		assertEquals(p1.getPokemon(0).getName(), "Charmander");
		assertEquals(p1.getPokemon(0).getHP(), 98);
		assertEquals(p1.getPokemon(0).getAttack(0).getDescription(), "Ember, FireType");
		assertEquals(p1.getPokemon(0).getAttack(0).getBaseDamage(), 20);
		assertEquals(p1.getPokemon(0).getAttack(1).getDescription(), "Fire Fang, FireType");
		assertEquals(p1.getPokemon(0).getAttack(1).getBaseDamage(), 33);
		assertEquals(p1.getPokemon(0).getAttack(2).getDescription(), "Flame Burst, FireType");
		assertEquals(p1.getPokemon(0).getAttack(2).getBaseDamage(), 35);
		assertEquals(p1.getPokemon(0).getAttack(3).getDescription(), "Fire Spin, FireType");
		assertEquals(p1.getPokemon(0).getAttack(3).getBaseDamage(), 18);
	}

	/**
	 * Tests to make sure that Player 1 can receive
	 * and use a Water Pokemon from the factory
	 * @throws InvalidPokemonException
	 */
	@Test
	public void testCreateWaterPokemon() throws InvalidPokemonException
	{
		p1.addPokemon(pf.createWaterPokemon("Squirtle"));
		assertEquals(p1.getPokemon(0).getClass(), WaterPokemon.class);
		assertEquals(p1.getPokemon(0).getName(), "Squirtle");
		assertEquals(p1.getPokemon(0).getHP(), 110);
		assertEquals(p1.getPokemon(0).getAttack(0).getDescription(), "Water Gun, WaterType");
		assertEquals(p1.getPokemon(0).getAttack(0).getBaseDamage(), 20);
		assertEquals(p1.getPokemon(0).getAttack(1).getDescription(), "Bubble, WaterType");
		assertEquals(p1.getPokemon(0).getAttack(1).getBaseDamage(), 20);
		assertEquals(p1.getPokemon(0).getAttack(2).getDescription(), "Water Pulse, WaterType");
		assertEquals(p1.getPokemon(0).getAttack(2).getBaseDamage(), 30);
		assertEquals(p1.getPokemon(0).getAttack(3).getDescription(), "Aqua Tail, WaterType");
		assertEquals(p1.getPokemon(0).getAttack(3).getBaseDamage(), 45);
	}

	/**
	 * Tests to make sure that Player 1 can receive
	 * and use a Grass Pokemon from the factory
	 * @throws InvalidPokemonException
	 */
	@Test
	public void testCreateGrassPokemon() throws InvalidPokemonException
	{
		p1.addPokemon(pf.createGrassPokemon("Bulbasaur"));
		assertEquals(p1.getPokemon(0).getClass(), GrassPokemon.class);
		assertEquals(p1.getPokemon(0).getName(), "Bulbasaur");
		assertEquals(p1.getPokemon(0).getHP(), 113);
		assertEquals(p1.getPokemon(0).getAttack(0).getDescription(), "Vine Whip, GrassType");
		assertEquals(p1.getPokemon(0).getAttack(0).getBaseDamage(), 23);
		assertEquals(p1.getPokemon(0).getAttack(1).getDescription(), "Razor Leaf, GrassType");
		assertEquals(p1.getPokemon(0).getAttack(1).getBaseDamage(), 28);
		assertEquals(p1.getPokemon(0).getAttack(2).getDescription(), "Magical Leaf, GrassType");
		assertEquals(p1.getPokemon(0).getAttack(2).getBaseDamage(), 30);
		assertEquals(p1.getPokemon(0).getAttack(3).getDescription(), "Bullet Seed, GrassType");
		assertEquals(p1.getPokemon(0).getAttack(3).getBaseDamage(), 13);
	}

}
