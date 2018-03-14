package factory;

import attacks.AttackMove;
import attacks.Move;
import attacks.WaterType;
import pokemon.Pokemon;
import pokemon.WaterPokemon;

/**
 * Creates the 4 available water type pokemon
 * with specific stats and attacks
 * @author Lis
 *
 */
public class WaterFactory {

	/**
	 * Creates a squirtle with 110 HP
	 * and the proper attacks
	 * @return a reference to the created squirtle
	 */
	public Pokemon createSquirtle(){
		//build pokemon
		Pokemon squirtle = new WaterPokemon("Squirtle", 110);
		
		//build attacks
		AttackMove waterGun = new Move("Water Gun", 20);
		waterGun = new WaterType(waterGun);
		AttackMove bubble = new Move("Bubble", 20);
		bubble = new WaterType(bubble);
		AttackMove waterPulse = new Move("Water Pulse", 30);
		waterPulse = new WaterType(waterPulse);
		AttackMove aquaTail = new Move("Aqua Tail", 45);
		aquaTail = new WaterType(aquaTail);
		
		//give attacks
		squirtle.setAttack(waterGun, 0);
		squirtle.setAttack(bubble, 1);
		squirtle.setAttack(waterPulse, 2);
		squirtle.setAttack(aquaTail, 3);
		
		return squirtle;
	}  
	
	/**
	 * Creates a Wartortle with 148 HP
	 * @return a reference to the created wartortle
	 */
	public Pokemon createWartortle(){
		Pokemon wartortle = new WaterPokemon("Wartortle", 148);
		
		//build attacks
		AttackMove waterPulse = new Move("Water Pulse", 30);
		waterPulse = new WaterType(waterPulse);
		AttackMove aquaTail = new Move("Aqua Tail", 45);
		aquaTail = new WaterType(aquaTail);
		AttackMove surf = new Move("Surf", 45);
		surf = new WaterType(surf);
		AttackMove waterfall = new Move("Waterfall", 40);
		waterfall = new WaterType(waterfall);
				
		//give attacks
		wartortle.setAttack(waterPulse, 0);
		wartortle.setAttack(aquaTail, 1);
		wartortle.setAttack(surf, 2);
		wartortle.setAttack(waterfall, 3);
				
		return wartortle;
		
	}
	
	/**
	 * Creates a Blastoise with 198 HP 
	 * and the proper attacks
	 * @return a reference to the created blastoise
	 */
	public Pokemon createBlastoise(){
		Pokemon blastoise = new WaterPokemon("Blastoise", 198);
		
		//build attacks
		AttackMove aquaTail = new Move("Aqua Tail", 45);
		aquaTail = new WaterType(aquaTail);
		AttackMove surf = new Move("Surf", 45);
		surf = new WaterType(surf);
		AttackMove muddyWater = new Move("Muddy Water", 45);
		muddyWater = new WaterType(muddyWater);
		AttackMove hydroPump = new Move("Hydro Pump", 55);
		hydroPump = new WaterType(hydroPump);
				
		//give attacks
		blastoise.setAttack(aquaTail, 0);
		blastoise.setAttack(surf, 1);
		blastoise.setAttack(muddyWater, 2);
		blastoise.setAttack(hydroPump, 3);
				
		return blastoise;
	}
	
	/**
	 * Creates a poliwag with 100 HP
	 * and the proper attacks
	 * @return a reference to the created poliwag
	 */
	public Pokemon createPoliwag(){
		Pokemon poliwag = new WaterPokemon("Poliwag", 100);
		
		//build attacks
		AttackMove waterGun = new Move("Water Gun", 20);
		waterGun = new WaterType(waterGun);
		AttackMove bubble = new Move("Bubble", 20);
		bubble = new WaterType(bubble);
		AttackMove bubbleBeam = new Move("Bubble Beam", 33);
		bubbleBeam = new WaterType(bubbleBeam);
		AttackMove hydroPump = new Move("Hydro Pump", 55);
		hydroPump = new WaterType(hydroPump);
				
		//give attacks
		poliwag.setAttack(waterGun, 0);
		poliwag.setAttack(bubble, 1);
		poliwag.setAttack(bubbleBeam, 2);
		poliwag.setAttack(hydroPump, 3);
				
		return poliwag;
	}
}
