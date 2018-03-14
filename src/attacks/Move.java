package attacks;
import stadium.Player;

/**
 * @author Nathaniel Manning
 */
public class Move implements AttackMove
{
	protected int baseDamage;
	protected String moveName;

	public Move(String moveName, int baseDamage)
	{
		this.moveName = moveName;
		this.baseDamage = baseDamage;
	}

	/**
	 * Calculates how much damage will be dealt to an enemy
	 * pokemon only if the number from Math.random is greater
	 * than or equal to accuracy.
	 * @param enemyPlayer is the enemy player that you are
	 * attacking.
	 * @return the damage that will be  dealt to the enemy
	 * pokemon
	 */
	public int calculateDamage(Player enemyPlayer)
	{
		return baseDamage;
	}

	/**
	 * @return the description of the move by getting the name
	 * of the move and concatenating the description of the type
	 * onto it
	 */
	public String getDescription()
	{
		return moveName;
	}

	/**
	 * @return the base damage of the move
	 */
	public int getBaseDamage()
	{
		return baseDamage;
	}
}
