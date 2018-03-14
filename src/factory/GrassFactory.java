package factory;

import attacks.AttackMove;
import attacks.GrassType;
import attacks.Move;
import pokemon.GrassPokemon;
import pokemon.Pokemon;

/**
 * Creates grass type pokemon with 
 * specific grass type moves
 * @author Elisabeth Ostrow
 *
 */
public class GrassFactory {

	/**
	 * Creates a bulbasaur with 113 HP and 
	 * specific attacks
	 * @return a reference to the created bulbasaur
	 */
	public Pokemon createBulbasaur(){
		//make pokemon
		Pokemon bulbasaur = new GrassPokemon("Bulbasaur", 113);
		
		//build attacks
		AttackMove vineWhip = new Move("Vine Whip", 23);
		vineWhip = new GrassType(vineWhip);
		AttackMove razorLeaf = new Move("Razor Leaf", 28);
		razorLeaf = new GrassType(razorLeaf);
		AttackMove magicalLeaf = new Move("Magical Leaf", 30);
		magicalLeaf = new GrassType(magicalLeaf);
		AttackMove bulletSeed = new Move("Bullet Seed", 13);
		bulletSeed = new GrassType(bulletSeed);
		
		//give pokemon attacks
		bulbasaur.setAttack(vineWhip, 0);
		bulbasaur.setAttack(razorLeaf, 1);
		bulbasaur.setAttack(magicalLeaf, 2);
		bulbasaur.setAttack(bulletSeed, 3);
		
		return bulbasaur;
	}
	
	/**
	 * Creates a ivysaur with 150 HP and 
	 * specific attacks
	 * @return a reference to the created ivysaur
	 */
	public Pokemon createIvysaur(){
		//make pokemon
		Pokemon ivysaur = new GrassPokemon("Ivysaur", 150);
		
		//build attacks
		AttackMove razorLeaf = new Move("Razor Leaf", 28);
		razorLeaf = new GrassType(razorLeaf);
		AttackMove magicalLeaf = new Move("Magical Leaf", 30);
		magicalLeaf = new GrassType(magicalLeaf);
		AttackMove seedBomb = new Move("Seed Bomb", 40);
		seedBomb = new GrassType(seedBomb);
		AttackMove gigaDrain = new Move("Giga Drain", 38);
		gigaDrain = new GrassType(gigaDrain);
		
		//give pokemon attacks
		ivysaur.setAttack(razorLeaf, 0);
		ivysaur.setAttack(magicalLeaf, 1);
		ivysaur.setAttack(seedBomb, 2);
		ivysaur.setAttack(gigaDrain, 3);
		
		return ivysaur;
	}
	
	/**
	 * Creates a venusaur with 200 HP and 
	 * specific attacks
	 * @return a reference to the created venusaur
	 */
	public Pokemon createVenusaur(){
		//make pokemon
		Pokemon venusaur = new GrassPokemon("Venusaur", 200);
		
		//build attacks
		AttackMove seedBomb = new Move("Seed Bomb", 40);
		seedBomb = new GrassType(seedBomb);
		AttackMove petalBlizzard = new Move("Petal Blizzard", 45);
		petalBlizzard = new GrassType(petalBlizzard);
		AttackMove solarBeam = new Move("Solar Beam", 60);
		solarBeam = new GrassType(solarBeam);
		AttackMove leafStorm = new Move("Leaf Storm", 65);
		leafStorm = new GrassType(leafStorm);
		
		//give pokemon attacks
		venusaur.setAttack(seedBomb, 0);
		venusaur.setAttack(petalBlizzard, 1);
		venusaur.setAttack(solarBeam, 2);
		venusaur.setAttack(leafStorm, 3);
		
		return venusaur;
	}
	
	/**
	 * Creates a caterpie with 113 HP and 
	 * specific attacks
	 * @return a reference to the created caterpie
	 */
	public Pokemon createCaterpie(){
		//make pokemon
		Pokemon caterpie = new GrassPokemon("Caterpie", 113);
		
		//build attacks
		AttackMove bugBite = new Move("Bug Bite", 30);
		bugBite = new GrassType(bugBite);
		AttackMove gigaDrain = new Move("Giga Drain", 38);
		gigaDrain = new GrassType(gigaDrain);
		AttackMove solarBeam = new Move("Solar Beam", 60);
		solarBeam = new GrassType(solarBeam);
		AttackMove bugBuzz = new Move("Bug Buzz", 45);
		bugBuzz = new GrassType(bugBuzz);
		
		//give pokemon attacks
		caterpie.setAttack(bugBite, 0);
		caterpie.setAttack(gigaDrain, 1);
		caterpie.setAttack(solarBeam, 2);
		caterpie.setAttack(bugBuzz, 3);
		
		return caterpie;
	}
}
