package attacks;
import stadium.Player;

/**
 * @author Nathaniel Manning
 */
public abstract class MoveType implements AttackMove
{
	protected AttackMove move;
	protected String description;

	/**
	 * Calculates how much damage will be dealt based on the
	 * base damage of the move and the type that the move
	 * is being used on.
	 * If the move you are using is strong against the type
	 * of the enemy pokemon, it will do twice as much.  If
	 * it is weakagainst the enemy pokemon, it will do half
	 * as much.  If it is the same type as the pokemon that
	 * you are attacking, it just deals the base damage.
	 * The move will only do damage if Math.random is greater
	 * than or equal to the accuracy of the move.
	 * @param enemyPlayer is the enemy player that you are
	 * attacking.
	 * @return the damage that will be  dealt to the enemy
	 * pokemon
	 */
	@Override
	abstract public int calculateDamage(Player enemyPlayer);

	/**
	 * @return the description of the move by getting the name
	 * of the move and concatenating the description of the type
	 * onto it
	 */
	public String getDescription()
	{
		return move.getDescription() + description;
	}

	/**
	 * @return the base damage of the move
	 */
	public int getBaseDamage()
	{
		return move.getBaseDamage();
	}
}
