package gameplay;
/**
 * @author Nathaniel Manning
 */
public interface Subject
{
	/**
	 * adds an observer to the observer array list
	 * @param observer is the observer that you are trying to
	 * add to the arraylist.
	 * @return true if the observer was added, and false if it
	 * was not.
	 */
	public boolean addObserver(Observer observer);

	/**
	 * Removes an observer from the arraylist
	 * @param observer is the observer that you are removing from
	 * the arraylist of observers.
	 */
	public void removeObserver(Observer observer);

	/**
	 * Notifies all of the observers when a change is made to
	 * something that is important for other observers to know.
	 */
	public void notifyObservers();

}
