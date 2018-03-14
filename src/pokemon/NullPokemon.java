package pokemon;

import attacks.AttackMove;
import attacks.Move;

/**
 * @author Nick Rummel
 * SWE200
 * If a Pokemon faints, it becomes a NullPokemon
 * type where it can't attack or function like
 * regular Pokemon
 */

public class NullPokemon extends Pokemon
{
	/**
	 * Constructor for Null Pokemon
	 * HP will remain 0 because
	 * the Pokemon will be dead
	 * @param name name of Pokemon
	 * @param hp Amount of health points
	 */
	public NullPokemon(String name, int hp)
	{
		super(name, 0);
		AttackMove nullAttack = new Move("Null Attack", 0);
		for(int i = 0; i < 4; i++)
		{
			setAttack(nullAttack, i);
		}
	}


	/**
	 * No functionality to change
	 * HP for Null Pokemon, HP will be 0
	 * every time
	 */
	public void setHp(int hp)
	{
		health = 0;
	}

	/**
	 * Null Pokemon can't take damage,
	 * because they are already dead.
	 * Therefore, the damage received
	 * is always 0.
	 */
	public void takeDamage(int dmg)
	{
		health -= 0;
	}

	/**
	 * Null Pokemon can't have an
	 * attack with damage since it
	 * is dead. The damage dealt is
	 * always 0, even if it is
	 * "wrapped" with an attack type.
	 */
	public void setAttack(AttackMove attack, int attackNum)
	{
		if(attacks[attackNum] == null)
		{
			AttackMove nullAttack = new Move("Null Attack", 0);
			attacks[attackNum] = nullAttack;
		}
	}


}
