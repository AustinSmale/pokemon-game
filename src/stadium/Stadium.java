package stadium;

/**
 * @author Nathaniel Manning
 */
import java.util.ArrayList;

import gameplay.Observer;
import gameplay.Subject;

public class Stadium implements Subject
{
	private static Stadium battleStadium; // is the stadium where the pokemon fight.
	private Player player1;		   // is the player1 in the stadium.
	private Player player2;		   // is the player2 int he stadium.
	private ArrayList<Observer> observers; // is the arraylist that holds all of
										   // the observers.

	/**
	 * Constructor for the stadium.
	 * Initializes the obsevers arraylist.
	 */
	private Stadium()
	{
		observers = new ArrayList<Observer>();
		player1 = new Player(); //Austin Smale
		player2 = new Player();	//Austin Smale
		notifyObservers();
	}

	/**
	 * If the battleStadium does not exist, a new one is created.
	 * Otherwise it returns the battleStadium that already exists.
	 * @return the stadium for battle
	 */
	public static Stadium getStadium()
	{
		if(battleStadium == null)
		{
			battleStadium = new Stadium();
		}
		return battleStadium;
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

	/**
	 * If player1 does not exist, player1 is set to p.
	 * Returns false if there is already a player1.
	 * @param p is the player you are trying to use for player1
	 * @return true if the player was set to player1 properly, and
	 * false if it was not.
	 */
	public boolean setPlayer1(Player p)
	{
		player1 = p;
		return true;

	}

	/**
	 * If player2 does not exist, player2 is set to p.
	 * Returns false if there is already a player2.
	 * @param p is the player you are trying to use for player2
	 * @return true if the player was set to player2 properly, and
	 * false if it was not.
	 */
	public boolean setPlayer2(Player p)
	{
		player2 = p;
		return true;

	}

	/**
	 * adds an observer to the observer array list
	 * @param observer is the observer that you are trying to
	 * add to the array list.
	 * @return true if the observer was added, and false if it
	 * was not.
	 */
	public boolean addObserver(Observer observer)
	{
		return observers.add(observer);
	}

	/**
	 * Removes an observer from the arraylist
	 * @param observer is the observer that you are removing from
	 * the array list of observers.
	 */
	public void removeObserver(Observer observer)
	{
		observers.remove(observer);
	}

	/**
	 * Notifies all of the observers when a change is made to
	 * something that is important for other observers to know.
	 */
	public void notifyObservers()
	{
		for(Observer stadiumObserver: observers)
		{
			stadiumObserver.update();
		}
	}

	/**
	 * Used for testing the array list of observers.
	 * @return the array list of observers
	 */
	public ArrayList<Observer> getObserverList()
	{
		return observers;
	}

	/**
	 * Sets the stadium to null so a new one can be created.
	 */
	public static void clearStadium()
	{
		battleStadium = null;
	}
}
