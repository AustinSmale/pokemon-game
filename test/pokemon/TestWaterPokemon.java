package pokemon;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestWaterPokemon {

	/**
	 * Test to make sure the Water class can initialize correctly 
	 */
	@Test
	public void testInitialization()
	{
		//Water pokemon has a name and health points
		WaterPokemon squirtle = new WaterPokemon("Squirtle", 40);
		assertEquals("Squirtle", squirtle.getName());
		assertEquals(40, squirtle.getHP());
	}
}
