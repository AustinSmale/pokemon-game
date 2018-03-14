package factory;

import static org.junit.Assert.*;

import org.junit.Test;

import attacks.Move;
import pokemon.Pokemon;
import pokemon.WaterPokemon;

/**
 * @author Nick Rummel
 * SWE200
 * Tests for the abstract Water Pokemon
 * Factory, using a mock class
 */
public class TestWaterPokemonProduct
{
	/**
	 * Tests functionality of the abstract
	 * Water Pokemon Factory with the mock class
	 */
	@Test
	public void testWaterPokemon()
	{
		MockWaterPokemonProduct product = new MockWaterPokemonProduct();
		Pokemon pokemon = product.createWaterPokemon("Test");
		assertNotNull(pokemon);
		assertEquals(pokemon.getName(), "Water Test");
		assertEquals(pokemon.getHP(), 105);
		for(int i = 0; i < 4; i++)
		{
			assertEquals(pokemon.getAttack(i).getDescription(), "A" + (i + 1));
			assertEquals(pokemon.getAttack(i).getBaseDamage(), (i + 1));
		}
	}

}

/**
 * @author Nick Rummel
 * A Mock extension of the abstract type WaterPokemonProduct,
 * used to test functionality
 */
class MockWaterPokemonProduct extends WaterPokemonProduct
{
	@Override
	public Pokemon createWaterPokemon(String name)
	{
		WaterPokemon waterTest = new WaterPokemon("Water Test", 105);
		waterTest.setAttack(new Move("A1", 1), 0);
		waterTest.setAttack(new Move("A2", 2), 1);
		waterTest.setAttack(new Move("A3", 3), 2);
		waterTest.setAttack(new Move("A4", 4), 3);
		return waterTest;
	}
}