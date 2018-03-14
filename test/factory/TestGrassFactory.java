package factory;

import static org.junit.Assert.*;

import org.junit.Test;

import attacks.AttackMove;
import pokemon.Pokemon;

/**
 * Tests that grass factory makes grass type
 * pokemon with proper grass type attacks
 * @author Elisabeth Ostrow
 *
 */
public class TestGrassFactory
{

	/**
	 * Tests that bulbasaur is created properly:
	 * HP: 113
	 * Vine Whip - damage: 23
	 * Razor Leaf - damage: 28
	 * Magical Leaf - damage: 30
	 * Bullet Seed - damage: 13
	 */
	@Test
	public void testBulbasaur()
	{
		GrassFactory f = new GrassFactory();
		Pokemon p = f.createBulbasaur();
		
		assertEquals("Bulbasaur", p.getName());
		assertEquals(113, p.getHP());
		
		AttackMove a = p.getAttack(0);
		assertEquals("Vine Whip, GrassType", a.getDescription());
		assertEquals(23, a.getBaseDamage());
		
		a = p.getAttack(1);
		assertEquals("Razor Leaf, GrassType", a.getDescription());
		assertEquals(28, a.getBaseDamage());
		
		a = p.getAttack(2);
		assertEquals("Magical Leaf, GrassType", a.getDescription());
		assertEquals(30, a.getBaseDamage());
		
		a = p.getAttack(3);
		assertEquals("Bullet Seed, GrassType", a.getDescription());
		assertEquals(13, a.getBaseDamage());
	}
	
	/**
	 * Tests that Ivysaur is created properly:
	 * HP: 150
	 * Razor Leaf - damage: 28
	 * Magical Leaf - damage: 30
	 * Seed Bomb - damage: 40
	 * Giga Drain - damage: 38
	 */
	@Test
	public void testIvysaur()
	{
		GrassFactory f = new GrassFactory();
		Pokemon p = f.createIvysaur();
		
		assertEquals("Ivysaur", p.getName());
		assertEquals(150, p.getHP());
		
		AttackMove a = p.getAttack(0);
		assertEquals("Razor Leaf, GrassType", a.getDescription());
		assertEquals(28, a.getBaseDamage());
		
		a = p.getAttack(1);
		assertEquals("Magical Leaf, GrassType", a.getDescription());
		assertEquals(30, a.getBaseDamage());
		
		a = p.getAttack(2);
		assertEquals("Seed Bomb, GrassType", a.getDescription());
		assertEquals(40, a.getBaseDamage());
		
		a = p.getAttack(3);
		assertEquals("Giga Drain, GrassType", a.getDescription());
		assertEquals(38, a.getBaseDamage());
	}
	
	/**
	 * Tests that Venusaur is created properly:
	 * HP: 200
	 * Seed Bomb - damage: 40
	 * Petal Blizzard - damage: 45
	 * Solar Beam - damage: 60
	 * Leaf Storm - damage: 65
	 */
	@Test
	public void testVenusaur()
	{
		GrassFactory f = new GrassFactory();
		Pokemon p = f.createVenusaur();
		
		assertEquals("Venusaur", p.getName());
		assertEquals(200, p.getHP());
		
		AttackMove a = p.getAttack(0);
		assertEquals("Seed Bomb, GrassType", a.getDescription());
		assertEquals(40, a.getBaseDamage());
		
		a = p.getAttack(1);
		assertEquals("Petal Blizzard, GrassType", a.getDescription());
		assertEquals(45, a.getBaseDamage());
		
		a = p.getAttack(2);
		assertEquals("Solar Beam, GrassType", a.getDescription());
		assertEquals(60, a.getBaseDamage());
		
		a = p.getAttack(3);
		assertEquals("Leaf Storm, GrassType", a.getDescription());
		assertEquals(65, a.getBaseDamage());
	}
	
	/**
	 * Tests that Caterpie is created properly:
	 * HP: 113
	 * Bug Bite - damage: 30
	 * Giga Drain - damage: 38
	 * Solar Beam - damage: 60
	 * Bug Buzz - damage: 45
	 */
	@Test
	public void testCaterpie()
	{
		GrassFactory f = new GrassFactory();
		Pokemon p = f.createCaterpie();
		
		assertEquals("Caterpie", p.getName());
		assertEquals(113, p.getHP());
		
		AttackMove a = p.getAttack(0);
		assertEquals("Bug Bite, GrassType", a.getDescription());
		assertEquals(30, a.getBaseDamage());
		
		a = p.getAttack(1);
		assertEquals("Giga Drain, GrassType", a.getDescription());
		assertEquals(38, a.getBaseDamage());
		
		a = p.getAttack(2);
		assertEquals("Solar Beam, GrassType", a.getDescription());
		assertEquals(60, a.getBaseDamage());
		
		a = p.getAttack(3);
		assertEquals("Bug Buzz, GrassType", a.getDescription());
		assertEquals(45, a.getBaseDamage());
	}

}
