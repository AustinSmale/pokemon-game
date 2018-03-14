package gameplay;
/**
 * @author Nathaniel Manning
 */
import stadium.Player;
import stadium.Stadium;

public class MockStadiumObserver implements StadiumObserver
{
	Stadium battleStadium;
	Player player1;
	Player player2;

	/**
	 * Updates information on player1.
	 */
	@Override
	public void updatePlayer1()
	{
		player1 = battleStadium.getPlayer1();

	}

	/**
	 * Updates information on player2.
	 */
	@Override
	public void updatePlayer2()
	{
		player2 = battleStadium.getPlayer2();
	}

	/**
	 * Updates the stadium and what is inside of it.
	 */
	@Override
	public void update()
	{
		battleStadium = Stadium.getStadium();
		updatePlayer1();
		updatePlayer2();
	}

	/**
	 * @return player1
	 */
	public Player getPlayer1()
	{
		return player1;
	}

	/**
	 * @return player2
	 */
	public Player getPlayer2()
	{
		return player2;
	}

}
