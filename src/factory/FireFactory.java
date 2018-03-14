package factory;

import attacks.AttackMove;
import attacks.FireType;
import attacks.Move;
import pokemon.FirePokemon;
import pokemon.Pokemon;

/**
 * Makes specific fire type pokemon with
 * unique health and attacks
 * @author Elisabeth
 *
 */
public class FireFactory {

	/**
	 * Creates a charmander with 98 HP
	 * and specific attacks
	 * @return a reference to the created charmander
	 */
	public Pokemon createCharmander(){
		//create pokemon
		Pokemon charmander = new FirePokemon("Charmander", 98);
		
		//build attacks
		AttackMove ember = new Move("Ember", 20);
		ember = new FireType(ember);
		AttackMove fireFang = new Move("Fire Fang", 33);
		fireFang = new FireType(fireFang);
		AttackMove flameBurst = new Move("Flame Burst", 35);
		flameBurst = new FireType(flameBurst);
		AttackMove fireSpin = new Move("Fire Spin", 18);
		fireSpin =  new FireType(fireSpin);
		
		//give pokemon attacks
		charmander.setAttack(ember, 0);
		charmander.setAttack(fireFang, 1);
		charmander.setAttack(flameBurst, 2);
		charmander.setAttack(fireSpin, 3);
		
		return charmander;
	}
	
	/**
	 * Creates a charmeleon with 145 HP
	 * and specific attacks
	 * @return a reference to the created charmeleon
	 */
	public Pokemon createCharmeleon(){
		//create pokemon
		Pokemon charmeleon = new FirePokemon("Charmeleon", 145);
		
		//build attacks
		AttackMove fireFang = new Move("Fire Fang", 33);
		fireFang = new FireType(fireFang);
		AttackMove flameBurst = new Move("Flame Burst", 35);
		flameBurst = new FireType(flameBurst);
		AttackMove flamethrower = new Move("Flamethrower", 45);
		flamethrower = new FireType(flamethrower);
		AttackMove inferno = new Move("Inferno", 50);
		inferno = new FireType(inferno);
		
		//give pokemon attacks
		charmeleon.setAttack(fireFang, 0);
		charmeleon.setAttack(flameBurst, 1);
		charmeleon.setAttack(flamethrower, 2);
		charmeleon.setAttack(inferno, 3);
		
		return charmeleon;
	}
	
	/**
	 * Creates a charizard with 195 HP
	 * and specific attacks
	 * @return a reference to the created charizard
	 */
	public Pokemon createCharizard(){
		//create pokemon
		Pokemon charizard = new FirePokemon("Charizard", 195);
		
		//build attacks
		AttackMove inferno = new Move("Inferno", 50);
		inferno = new FireType(inferno);
		AttackMove overheat = new Move("Overheat", 65);
		overheat = new FireType(overheat);
		AttackMove flamethrower = new Move("Flamethrower", 45);
		flamethrower = new FireType(flamethrower);
		AttackMove fireBlast = new Move("Fire Blast", 55);
		fireBlast = new FireType(fireBlast);
		
		//give pokemon attacks
		charizard.setAttack(inferno, 0);
		charizard.setAttack(overheat, 1);
		charizard.setAttack(flamethrower, 2);
		charizard.setAttack(fireBlast, 3);
		
		return charizard;
	}
	
	/**
	 * Creates a vulpix with 95 HP
	 * and specific attacks
	 * @return a reference to the created charizard
	 */
	public Pokemon createVulpix(){
		//create pokemon
		Pokemon vulpix = new FirePokemon("Vulpix", 95);
		
		//build attacks
		AttackMove ember = new Move("Ember", 20);
		ember = new FireType(ember);
		AttackMove fireSpin = new Move("Fire Spin", 18);
		fireSpin = new FireType(fireSpin);
		AttackMove flameBurst = new Move("Flame Burst", 35);
		flameBurst = new FireType(flameBurst);
		AttackMove flamethrower = new Move("Flamethrower", 45);
		flamethrower = new FireType(flamethrower);
		
		//give pokemon attacks
		vulpix.setAttack(ember, 0);
		vulpix.setAttack(fireSpin, 1);
		vulpix.setAttack(flameBurst, 2);
		vulpix.setAttack(flamethrower, 3);
		
		return vulpix;
	}
}
