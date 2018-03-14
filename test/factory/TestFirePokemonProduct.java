package factory;

import static org.junit.Assert.*;

import org.junit.Test;

import attacks.Move;
import pokemon.FirePokemon;

/**
 * @author Nick Rummel
 * SWE200
 * Tests for the abstract Fire Pokemon
 * Factory, using a mock class
 */
public class TestFirePokemonProduct
{
	/**
	 * Tests functionality of the abstract
	 * Fire Pokemon Factory with the mock class
	 */
	@Test
	public void testFirePokemon()
	{
		MockFirePokemonProduct product = new MockFirePokemonProduct();
		FirePokemon pokemon = product.createFirePokemon("Test");
		assertNotNull(pokemon);
		assertEquals(pokemon.getName(), "Fire Test");
		assertEquals(pokemon.getHP(), 100);
		for(int i = 0; i < 4; i++)
		{
			assertEquals(pokemon.getAttack(i).getDescription(), "A" + (i + 1));
			assertEquals(pokemon.getAttack(i).getBaseDamage(), (i + 1));
		}
	}

}

/**
 * @author Nick Rummel
 * A Mock extension of the abstract type FirePokemonProduct,
 * used to test functionality
 */
class MockFirePokemonProduct extends FirePokemonProduct
{

	@Override
	public FirePokemon createFirePokemon(String name)
	{
		FirePokemon fireTest = new FirePokemon("Fire Test", 100);
		fireTest.setAttack(new Move("A1", 1), 0);
		fireTest.setAttack(new Move("A2", 2), 1);
		fireTest.setAttack(new Move("A3", 3), 2);
		fireTest.setAttack(new Move("A4", 4), 3);
		return fireTest;
	}
}