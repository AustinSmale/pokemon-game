package factory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import attacks.Move;
import pokemon.FirePokemon;
import pokemon.GrassPokemon;
import pokemon.Pokemon;
import pokemon.WaterPokemon;
import stadium.Player;

/**
 * @author Nick Rummel
 * SWE200
 * Tests for the abstract Pokemon
 * Factory, using a mock class
 */
public class TestPokemonFactory
{
	// instances used for each test
	Player p1;
	MockPlayerFactory mpf;

	/**
	 * Initializes instances before each test
	 */
	@Before
	public void setUp()
	{
		p1 = new Player();
		mpf = new MockPlayerFactory();
	}

	/**
	 * Tests functionality of creating Fire Pokemon
	 * with a mock class
	 */
	@Test
	public void testCreateFirePokemon()
	{
		p1.addPokemon(mpf.createFirePokemon("Test"));
		assertEquals(p1.getPokemon(0).getClass(), FirePokemon.class);
		assertEquals(p1.getPokemon(0).getName(), "Fire");
		assertEquals(p1.getPokemon(0).getHP(), 50);
		for(int i = 0; i < 4; i++)
		{
			assertEquals(p1.getPokemon(0).getAttack(i).getDescription(), "A" + (i + 1));
			assertEquals(p1.getPokemon(0).getAttack(i).getBaseDamage(), (i + 1));
		}
	}

	/**
	 * Tests functionality of creating Water Pokemon
	 * with a mock class
	 */
	@Test
	public void testCreateWaterPokemon()
	{
		p1.addPokemon(mpf.createWaterPokemon("Test"));
		assertEquals(p1.getPokemon(0).getClass(), WaterPokemon.class);
		assertEquals(p1.getPokemon(0).getName(), "Water");
		assertEquals(p1.getPokemon(0).getHP(), 45);
		for(int i = 0; i < 4; i++)
		{
			assertEquals(p1.getPokemon(0).getAttack(i).getDescription(), "A" + (i + 1));
			assertEquals(p1.getPokemon(0).getAttack(i).getBaseDamage(), (i + 1));
		}
	}

	/**
	 * Tests functionality of creating Grass Pokemon
	 * with a mock class
	 */
	@Test
	public void testCreateGrassPokemon()
	{
		p1.addPokemon(mpf.createGrassPokemon("Test"));
		assertEquals(p1.getPokemon(0).getClass(), GrassPokemon.class);
		assertEquals(p1.getPokemon(0).getName(), "Grass");
		assertEquals(p1.getPokemon(0).getHP(), 55);
		for(int i = 0; i < 4; i++)
		{
			assertEquals(p1.getPokemon(0).getAttack(i).getDescription(), "A" + (i + 1));
			assertEquals(p1.getPokemon(0).getAttack(i).getBaseDamage(), (i + 1));
		}
	}


}
/**
 * @author Nick Rummel
 * A Mock extension of the abstract type PokemonFactory,
 * used to test functionality
 */
class MockPlayerFactory extends PokemonFactory
{

	@Override
	public Pokemon createFirePokemon(String name)
	{
		FirePokemon fireTest = new FirePokemon("Fire", 50);
		fireTest.setAttack(new Move("A1", 1), 0);
		fireTest.setAttack(new Move("A2", 2), 1);
		fireTest.setAttack(new Move("A3", 3), 2);
		fireTest.setAttack(new Move("A4", 4), 3);
		return fireTest;
	}

	@Override
	public Pokemon createWaterPokemon(String name)
	{
		WaterPokemon waterTest = new WaterPokemon("Water", 45);
		waterTest.setAttack(new Move("A1", 1), 0);
		waterTest.setAttack(new Move("A2", 2), 1);
		waterTest.setAttack(new Move("A3", 3), 2);
		waterTest.setAttack(new Move("A4", 4), 3);
		return waterTest;
	}

	@Override
	public Pokemon createGrassPokemon(String name)
	{
		GrassPokemon grassTest = new GrassPokemon("Grass", 55);
		grassTest.setAttack(new Move("A1", 1), 0);
		grassTest.setAttack(new Move("A2", 2), 1);
		grassTest.setAttack(new Move("A3", 3), 2);
		grassTest.setAttack(new Move("A4", 4), 3);
		return grassTest;
	}

}