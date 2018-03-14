package pokemon;

import static org.junit.Assert.*;

import org.junit.Test;

import attacks.FireType;
import attacks.Move;
/**
 * Test the Pokemon class
 * @author Austin Smale
 *
 */
public class TestPokemon {

	/**
	 * Test to make sure the Pokemon class can initialize correctly 
	 */
	@Test
	public void testInitialization()
	{
		//Pokemon has a name and health points
		MockPokemon charmander = new MockPokemon("Charmander", 40);
		assertEquals("Charmander", charmander.getName());
		assertEquals(40, charmander.getHP());
	}
	
	/**
	 * Test that Pokemon takes the correct amount of damage
	 */
	@Test
	public void testDamage() {
		MockPokemon charmander = new MockPokemon("Charmander", 40);
		charmander.takeDamage(5);
		assertEquals(35, charmander.getHP());
	}
	
	/**
	 * Test adding an AttackMove
	 */
	@Test
	public void testAddingAttackMove() {
		MockPokemon charmander = new MockPokemon("Charmander", 40);
		FireType fm = new FireType(new Move("Fire", 10));
		charmander.setAttack(fm, 0);
		assertEquals(fm, charmander.getAttack(0));
		//Test to see if other moves are null
		assertNull(charmander.getAttack(1));
		assertNull(charmander.getAttack(2));
		assertNull(charmander.getAttack(3));
	}
	
	/**
	 * Test to see if you can override a move in the array
	 */
	@Test
	public void testOverrideAttackMove() {
		MockPokemon charmander = new MockPokemon("Charmander", 40);
		FireType fm = new FireType(new Move("Fire", 10));
		charmander.setAttack(fm, 0);
		assertEquals(fm, charmander.getAttack(0));
		//New move
		FireType nfm = new FireType(new Move("Fire2", 10));
		charmander.setAttack(nfm, 0);
		assertEquals(nfm, charmander.getAttack(0));
		assertNotEquals(fm, charmander.getAttack(0));	
	}
}
