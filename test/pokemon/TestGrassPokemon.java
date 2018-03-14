package pokemon;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGrassPokemon {

	/**
	 * Test to make sure the Grass class can initialize correctly 
	 */
	@Test
	public void testInitialization()
	{
		//Grass pokemon has a name and health points
		GrassPokemon bulbasar = new GrassPokemon("Bulbasar", 40);
		assertEquals("Bulbasar", bulbasar.getName());
		assertEquals(40, bulbasar.getHP());
	}

}
