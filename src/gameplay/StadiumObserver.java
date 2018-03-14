package gameplay;

/**
 * @author Nathaniel Manning
 */
public interface StadiumObserver extends Observer
{

	/**
	 * Updates information about player1 for the gui.
	 */
	public void updatePlayer1();

	/**
	 * Updates information about player2 for the gui.
	 */
	public void updatePlayer2();

	/**
	 * Updates the observers with changes to important
	 * variables.
	 */
	public void update();
}
