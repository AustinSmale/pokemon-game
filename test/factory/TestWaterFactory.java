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
public class TestWaterFactory
{

	/**
	 * Tests that a squirtle is made properly:
	 * HP: 110
	 * Water Gun - damage: 20
	 * Bubble - damage: 20
	 * Water Pulse - damage: 30
	 * Aqua Tail - damage : 45
	 */
	@Test
	public void testSquirtle()
	{
		WaterFactory f = new WaterFactory();
		Pokemon p = f.createSquirtle();
		
		//see that squirtle has the correct name and HP
		assertEquals("Squirtle", p.getName());
		assertEquals(110, p.getHP());
		
		//see that squirtle's attacks are in the proper order,
		//have the proper type, and the proper damage amount
		AttackMove a = p.getAttack(0);
		assertEquals("Water Gun, WaterType", a.getDescription());
		assertEquals(20, a.getBaseDamage());
		
		a = p.getAttack(1);
		assertEquals("Bubble, WaterType", a.getDescription());
		assertEquals(20, a.getBaseDamage());
		
		a = p.getAttack(2);
		assertEquals("Water Pulse, WaterType", a.getDescription());
		assertEquals(30, a.getBaseDamage());
		
		a = p.getAttack(3);
		assertEquals("Aqua Tail, WaterType", a.getDescription());
		assertEquals(45, a.getBaseDamage());
	}
	
	/**
	 * Tests that a Wartortle is made properly:
	 * HP: 148
	 * Water Pulse - damage: 30
	 * Aqua Tail - damage: 45
	 * Surf - damage: 45
	 * Waterfall - damage: 40
	 */
	@Test
	public void testWartortle(){
		WaterFactory f = new WaterFactory();
		Pokemon p = f.createWartortle();
		
		//see that wartortle has the correct name and HP
		assertEquals("Wartortle", p.getName());
		assertEquals(148, p.getHP());
		
		//see that wartortle's attacks are in the proper order,
		//have the proper type, and the proper damage amount
		AttackMove a = p.getAttack(0);
		assertEquals("Water Pulse, WaterType", a.getDescription());
		assertEquals(30, a.getBaseDamage());
		
		a = p.getAttack(1);
		assertEquals("Aqua Tail, WaterType", a.getDescription());
		assertEquals(45, a.getBaseDamage());
		
		a = p.getAttack(2);
		assertEquals("Surf, WaterType", a.getDescription());
		assertEquals(45, a.getBaseDamage());
		
		a = p.getAttack(3);
		assertEquals("Waterfall, WaterType", a.getDescription());
		assertEquals(40, a.getBaseDamage());
	}

	
	/**
	 * Test that a balstoise is made properly:
	 * HP: 198
	 * Aqua Tail - damage: 45
	 * Surf - damage: 45
	 * Muddy Water - damage: 45
	 * Hydro Pump - damage: 55
	 */
	@Test
	public void testBlastoise(){
		WaterFactory f = new WaterFactory();
		Pokemon p = f.createBlastoise();
		
		//see that wartortle has the correct name and HP
		assertEquals("Blastoise", p.getName());
		assertEquals(198, p.getHP());
		
		//see that wartortle's attacks are in the proper order,
		//have the proper type, and the proper damage amount
		AttackMove a = p.getAttack(0);
		assertEquals("Aqua Tail, WaterType", a.getDescription());
		assertEquals(45, a.getBaseDamage());
		
		a = p.getAttack(1);
		assertEquals("Surf, WaterType", a.getDescription());
		assertEquals(45, a.getBaseDamage());
		
		a = p.getAttack(2);
		assertEquals("Muddy Water, WaterType", a.getDescription());
		assertEquals(45, a.getBaseDamage());
		
		a = p.getAttack(3);
		assertEquals("Hydro Pump, WaterType", a.getDescription());
		assertEquals(55, a.getBaseDamage());
	}
	
	
	/**
	 * Tests that Poliwag is made properly:
	 * HP: 100
	 * Water Gun - damage: 20
	 * Bubble - damage: 20
	 * Bubble Beam - damage: 33
	 * Hydro Pump - damage: 55
	 */
	@Test
	public void createPoliwag(){
		WaterFactory f = new WaterFactory();
		Pokemon p = f.createPoliwag();
		
		//see that wartortle has the correct name and HP
		assertEquals("Poliwag", p.getName());
		assertEquals(100, p.getHP());
		
		//see that wartortle's attacks are in the proper order,
		//have the proper type, and the proper damage amount
		AttackMove a = p.getAttack(0);
		assertEquals("Water Gun, WaterType", a.getDescription());
		assertEquals(20, a.getBaseDamage());
		
		a = p.getAttack(1);
		assertEquals("Bubble, WaterType", a.getDescription());
		assertEquals(20, a.getBaseDamage());
		
		a = p.getAttack(2);
		assertEquals("Bubble Beam, WaterType", a.getDescription());
		assertEquals(33, a.getBaseDamage());
		
		a = p.getAttack(3);
		assertEquals("Hydro Pump, WaterType", a.getDescription());
		assertEquals(55, a.getBaseDamage());
	}

}
