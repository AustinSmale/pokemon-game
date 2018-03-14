package attacks;

/**
 * @author Nathaniel Manning
 */
import pokemon.*;
import stadium.Player;

public class FireType extends MoveType
{
	/**
	 * Constructor for fire type moves
	 *
	 * Adds "FireType" to the description to note that it
	 * is a fire type move.
	 * @param move is the move that you are making a
	 * fire type move.
	 */
	public FireType(AttackMove move)
	{
		this.move = move;
		description = ", FireType";
	}

	/**
	 * Calculates how much damage will be dealt based on the
	 * base damage of the move and the type that the move
	 * is being used on.
	 * If the move you are using is strong against the type
	 * of the enemy pokemon, it will do twice as much.  If
	 * it is weak against the enemy pokemon, it will do half
	 * as much.  If it is the same type as the pokemon that
	 * you are attacking, it just deals the base damage.
	 * Only deals the damage if Math.random is greater than
	 * or equal to accuracy.
	 * @return the damage that will be  dealt to the enemy
	 * pokemon
	 */
	public int calculateDamage(Player enemyPlayer)
	{
		int damage = 0;
		Pokemon enemyPokemon = enemyPlayer.getActivePokemon();
		if(enemyPokemon.getClass() == FirePokemon.class)
		{
				damage = move.getBaseDamage();
		}
		if(enemyPokemon.getClass() == GrassPokemon.class)
		{
			damage = move.getBaseDamage() * 2;
		}
		if(enemyPokemon.getClass() == WaterPokemon.class)
		{
			damage = (int)Math.round((move.getBaseDamage() * .5));
		}
		return damage;
	}
}
