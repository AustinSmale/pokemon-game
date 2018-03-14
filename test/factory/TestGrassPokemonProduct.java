package factory;

import static org.junit.Assert.*;

import org.junit.Test;

import attacks.Move;
import pokemon.GrassPokemon;
import pokemon.Pokemon;

/**
 * @author Nick Rummel
 * SWE200
 * Tests for the abstract Grass Pokemon
 * Factory, using a mock class
 */
public class TestGrassPokemonProduct
{

	/**
	 * Tests functionality of the abstract
	 * Grass Pokemon Factory with the mock class
	 */
	@Test
	public void testGrassPokemon()
	{
		MockGrassPokemonProduct product = new MockGrassPokemonProduct();
		Pokemon pokemon = product.createGrassPokemon("Test");
		assertNotNull(pokemon);
		assertEquals(pokemon.getName(), "Grass Test");
		assertEquals(pokemon.getHP(), 110);
		for(int i = 0; i < 4; i++)
		{
			assertEquals(pokemon.getAttack(i).getDescription(), "A" + (i + 1));
			assertEquals(pokemon.getAttack(i).getBaseDamage(), (i + 1));
		}
	}

}

/**
 * @author Nick Rummel
 * A Mock extension of the abstract type GrassPokemonProduct,
 * used to test functionality
 */
class MockGrassPokemonProduct extends GrassPokemonProduct
{
	@Override
	public Pokemon createGrassPokemon(String name)
	{
		GrassPokemon grassTest = new GrassPokemon("Grass Test", 110);
		grassTest.setAttack(new Move("A1", 1), 0);
		grassTest.setAttack(new Move("A2", 2), 1);
		grassTest.setAttack(new Move("A3", 3), 2);
		grassTest.setAttack(new Move("A4", 4), 3);
		return grassTest;
	}
}