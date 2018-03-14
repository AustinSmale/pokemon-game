package factory;

import static org.junit.Assert.*;

import org.junit.Test;

import attacks.AttackMove;
import pokemon.Pokemon;


/**
 * Tests that this factory creates the 4 specified
 * pokemon with each having its proper, unique stats
 * @author Elisabeth Ostrow
 *
 */
public class TestFireFactory
{

	/**
	 * Tests that charmander is made properly:
	 * HP: 98
	 * Ember - damage: 20
	 * Fire Fang - damage: 33
	 * Flame Burst - damage: 35
	 * Fire Spin - damage: 18
	 */
	@Test
	public void testCharmander()
	{
		FireFactory f = new FireFactory();
		Pokemon p = f.createCharmander();
		
		assertEquals("Charmander", p.getName());
		assertEquals(98, p.getHP());
		
		AttackMove a = p.getAttack(0);
		assertEquals("Ember, FireType", a.getDescription());
		assertEquals(20, a.getBaseDamage());
		
		a = p.getAttack(1);
		assertEquals("Fire Fang, FireType", a.getDescription());
		assertEquals(33, a.getBaseDamage());
		
		a = p.getAttack(2);
		assertEquals("Flame Burst, FireType", a.getDescription());
		assertEquals(35, a.getBaseDamage());
		
		a = p.getAttack(3);
		assertEquals("Fire Spin, FireType", a.getDescription());
		assertEquals(18, a.getBaseDamage());
		
	}
	
	/**
	 * Tests that charmeleon is made properly:
	 * HP: 145
	 * Fire Fang - damage: 33
	 * Flame Burst - damage: 35
	 * Flamethrower - damage: 45
	 * Inferno - damage: 50
	 */
	@Test
	public void testCharmeleon()
	{
		FireFactory f = new FireFactory();
		Pokemon p = f.createCharmeleon();
		
		assertEquals("Charmeleon", p.getName());
		assertEquals(145, p.getHP());
		
		AttackMove a = p.getAttack(0);
		assertEquals("Fire Fang, FireType", a.getDescription());
		assertEquals(33, a.getBaseDamage());
		
		a = p.getAttack(1);
		assertEquals("Flame Burst, FireType", a.getDescription());
		assertEquals(35, a.getBaseDamage());
		
		a = p.getAttack(2);
		assertEquals("Flamethrower, FireType", a.getDescription());
		assertEquals(45, a.getBaseDamage());
		
		a = p.getAttack(3);
		assertEquals("Inferno, FireType", a.getDescription());
		assertEquals(50, a.getBaseDamage());
		
	}
	
	/**
	 * Tests that charizard is made properly:
	 * HP: 195
	 * Inferno - damage: 50
	 * Overheat - damage: 65
	 * Flamethrower - damage: 45
	 * Fire Blast - damage: 55
	 */
	@Test
	public void testCharizard()
	{
		FireFactory f = new FireFactory();
		Pokemon p = f.createCharizard();
		
		assertEquals("Charizard", p.getName());
		assertEquals(195, p.getHP());
		
		AttackMove a = p.getAttack(0);
		assertEquals("Inferno, FireType", a.getDescription());
		assertEquals(50, a.getBaseDamage());
		
		a = p.getAttack(1);
		assertEquals("Overheat, FireType", a.getDescription());
		assertEquals(65, a.getBaseDamage());
		
		a = p.getAttack(2);
		assertEquals("Flamethrower, FireType", a.getDescription());
		assertEquals(45, a.getBaseDamage());
		
		a = p.getAttack(3);
		assertEquals("Fire Blast, FireType", a.getDescription());
		assertEquals(55, a.getBaseDamage());
		
	}
	
	/**
	 * Tests that vulpix is made properly:
	 * HP: 95
	 * Ember - damage: 20
	 * Fire Spin - damage: 18
	 * Flame Burst - damage: 35
	 * Flamethrower - damage: 45
	 */
	@Test
	public void testVulpix()
	{
		FireFactory f = new FireFactory();
		Pokemon p = f.createVulpix();
		
		assertEquals("Vulpix", p.getName());
		assertEquals(95, p.getHP());
		
		AttackMove a = p.getAttack(0);
		assertEquals("Ember, FireType", a.getDescription());
		assertEquals(20, a.getBaseDamage());
		
		a = p.getAttack(1);
		assertEquals("Fire Spin, FireType", a.getDescription());
		assertEquals(18, a.getBaseDamage());
		
		a = p.getAttack(2);
		assertEquals("Flame Burst, FireType", a.getDescription());
		assertEquals(35, a.getBaseDamage());
		
		a = p.getAttack(3);
		assertEquals("Flamethrower, FireType", a.getDescription());
		assertEquals(45, a.getBaseDamage());
		
	}

}
