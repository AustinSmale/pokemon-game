package state;

import java.util.ArrayList;

import gameplay.Observer;
import gameplay.Subject;
import stadium.Player;
import stadium.Stadium;

/**
 * Handles requests dependent on whose turn it is,
 * such as accessing player-specific pokemon info
 * (everything is assumed to be made by Lis unless noted)
 * @author Elisabeth Ostrow
 *
 * Observer methods needed for GUI to observe
 * the player's turn
 * @author Nick Rummel
 */
public class PlayerContext implements Subject {

	protected PlayerState player1Turn;
	protected PlayerState player2Turn;

	private PlayerState currentState;

	// ArrayList of observers added by Nick Rummel
	private ArrayList<Observer> observers;

	private static volatile PlayerContext instance;

	/**
	 * Sets a reference to a singleton instance a each player turn
	 * and sets current state to player1state
	 */
	private PlayerContext(){
		Stadium s = Stadium.getStadium();

		player1Turn = Player1TurnState.getInstance(this, s.getPlayer1());
		player2Turn = Player2TurnState.getInstance(this, s.getPlayer2());

		currentState = player1Turn;

		observers = new ArrayList<>(0);
	}

	/**
	 * Ensures that only one of instance of this class is ever created
	 * @return the singleton instance of this class
	 */
	public static PlayerContext getInstance(){
		if(instance == null){
			synchronized(PlayerContext.class){
				if(instance == null){
					instance = new PlayerContext();
				}
			}
		}
		return instance;
	}

	/**
	 *
	 * @return the current state that handles requests
	 */
	public PlayerState getState(){
		return currentState;
	}

	/**
	 * Sets the current state to a new player state
	 * @param p new the new current player state
	 * @author Elisabeth Ostrow
	 *
	 * Every time state changes,
	 * observers automatically notified
	 * @author Nick Rummel
	 */
	public void setState(PlayerState p){
		currentState = p;
		// next line added by Nick Rummel
		notifyObservers();
	}

	/**
	 * 
	 * @return a reference to player1 turn state
	 */
	public PlayerState getPlayer1Turn()
	{
		return player1Turn;
	}

	/**
	 * 
	 * @return a reference to player3 turn state
	 */
	public PlayerState getPlayer2Turn()
	{
		return player2Turn;
	}

	/**
	 * handles a request made by the user through
	 * the menu context, defers action to current state
	 */
	public void request(){
		currentState.handle();
	}

	/**
	 * Makes current state the default state, player1turn
	 * @author Elisabeth Ostrow
	 *
	 * Refactored to call setState in order to update
	 * observers
	 * @author Nick Rummel
	 */
	public void reset()
	{
		// before refactor, set currentState = player1Turn
		setState(player1Turn);
	}

	/**
	 * Add objects to observer list
	 * @author Nick Rummel
	 */
	public boolean addObserver(Observer observer)
	{
		return observers.add(observer);

	}

	/**
	 * Remove objects from observer list
	 * @author Nick Rummel
	 */
	public void removeObserver(Observer observer)
	{
		observers.remove(observer);

	}

	/**
	 * Let observers know the player's turn has changed
	 * @author Nick Rummel
	 */
	public void notifyObservers()
	{
		for(int i = 0; i < observers.size(); i++)
		{
			observers.get(i).update();
		}

	}

}
