package gameplay;

/**
 * @author Nick Rummel
 * Observer to update the GUI when
 * the player's state has changed
 */
public interface TurnObserver extends Observer
{
	/**
	 * Update method for the observer
	 */
	@Override
	public void update();
}
