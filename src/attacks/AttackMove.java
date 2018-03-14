package attacks;

/**
 * @author Nathaniel Manning
 */
import stadium.Player;

public interface AttackMove
{
	/**
	 * Calculates how much damage will be dealt based on the
	 * base damage of the move and the type of pokemon
	 * that the move is being used on.
	 * If the move you are using is strong against the type
	 * of the enemy pokemon, it will do twice as much.  If
	 * it is weakagainst the enemy pokemon, it will do half
	 * as much.  If it is the same type as the pokemon that
	 * you are attacking, it just deals the base damage.
	 * @param enemyPlayer is the enemy player that you are
	 * attacking.
	 * @return the damage that will be  dealt to the enemy
	 * pokemon
	 */
	public int calculateDamage(Player enemyPlayer);

	/**
	 * @return the description of the move by getting the name
	 * of the move and concatenating the description of the type
	 * onto it
	 */
	public String getDescription();

	/**
	 * @return the base damage of the move
	 */
	public int getBaseDamage();
}
