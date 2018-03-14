package pokemon;

import static org.junit.Assert.*;

import org.junit.Test;

import attacks.AttackMove;
import attacks.FireType;
import attacks.Move;

/**
 * Tests for the Null Pokemon
 * @author Nick Rummel
 * SWE200
 */

public class TestNullPokemon
{

	/**
	 * Tests to make sure constructor works properly
	 * for the Null Pokemon type
	 */
	@Test
	public void testInitialization()
	{
		NullPokemon dead = new NullPokemon("Dead Pokemon", 50);
		assertEquals("Dead Pokemon", dead.getName());
		assertEquals(0, dead.getHP());
	}

	/**
	 * Tests to make sure actions don't do anything
	 * for the Null Pokemon type
	 */
	@Test
	public void testActions()
	{
		NullPokemon dead = new NullPokemon("Dead Pokemon", 50);
		// When getHP() is called, it will be Null
		dead.setHp(100);
		assertEquals(0, dead.getHP());

		// HP will still be 0, can't have negative
		// HP and can't take damage when Null (HP always 0)
		dead.takeDamage(20);
		assertEquals(0, dead.getHP());

		// Has 0 base damage, and therefore can't deal damage
		// Tests if a new attack move (and it is also wrapped)
		// to verify the attacks can't be change. It also
		// attacks another Pokemon with the base damage
		// to show that nothing changes
		AttackMove attack = new Move("Normal Move", 40);
		attack = new FireType(attack);
		FirePokemon test = new FirePokemon("Fire Dummy", 50);
		assertEquals(test.getHP(), 50);
		for(int i = 0; i < 4; i++)
		{
			assertEquals(dead.getAttack(i).getBaseDamage(), 0);
			assertEquals(dead.getAttack(i).getDescription(), "Null Attack");
			dead.setAttack(attack, i);
			assertEquals(dead.getAttack(i).getBaseDamage(), 0);
			assertEquals(dead.getAttack(i).getDescription(), "Null Attack");
			test.takeDamage(dead.getAttack(i).getBaseDamage());
			assertEquals(test.getHP(), 50);
		}

	}

}
