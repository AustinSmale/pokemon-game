package pokemon;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFirePokemon {

	/**
	 * Test to make sure the Fire class can initialize correctly 
	 */
	@Test
	public void testInitialization()
	{
		//Fire pokemon has a name and health points
		FirePokemon charmander = new FirePokemon("Charmander", 40);
		assertEquals("Charmander", charmander.getName());
		assertEquals(40, charmander.getHP());
	}

}
