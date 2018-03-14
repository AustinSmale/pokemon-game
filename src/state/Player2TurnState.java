package state;

import exception.EmptyPlayerState;
import stadium.Player;

/**
 * Manages the actions taken during player 2's turn
 * @author Elisabeth Ostrow
 *
 */
public class Player2TurnState extends PlayerState{

	private static volatile PlayerState instance;

	
	/**
	 * @see PlayerState#PlayerState(PlayerContext, Player)
	 * @param context a reference to player context
	 * @param player a reference to the correct player object
	 */
	private Player2TurnState(PlayerContext context, Player player)
	{
		super(context, player);
	}

	/**
	 * Retrieves this classes reference to it's instance. Ensure that only
	 * one instance of this class will be able to exist
	 * @param context a reference to context, passed to constructor
	 * @param player a reference to a player, passed to constructor
	 * @return the singleton instance of this class
	 */
	public static PlayerState getInstance(PlayerContext context, Player player) {
		if(instance == null){
			synchronized(Player2TurnState.class){
				if(instance == null){
					instance = new Player2TurnState(context, player);
				}
			}
		}
		return instance;
	}
	
	/**
	 * @return the current singleton instance of this class
	 * @throws EmptyPlayerState 
	 */
	public static PlayerState getInstance() throws EmptyPlayerState{
		if(instance == null){
			synchronized(Player2TurnState.class){
				if(instance == null){
					throw new EmptyPlayerState("Player 2 Turn has not been created yet.");
				}
			}
		}
		return instance;
	}



	/**
	 * Don't have a need for this to do anything yet
	 */
	public void handle()
	{
	}

}
