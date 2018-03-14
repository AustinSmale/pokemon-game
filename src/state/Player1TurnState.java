package state;

import exception.EmptyPlayerState;
import stadium.Player;

/**
 * Handles actions taken on player1's turn that 
 * require acces to the player1 object
 * @author Elisabeth Ostrow
 *
 */
public class Player1TurnState extends PlayerState{

	private static volatile PlayerState instance;
	
	/**
	 * @see PlayerState#PlayerState(PlayerContext, Player)
	 * @param context a reference to a player context
	 * @param player a reference to a player object
	 */
	private Player1TurnState(PlayerContext context, Player player)
	{
		super(context, player);
	}

	/**
	 * Will create a new instance with given parameters if one does not exist
	 * @param context a reference to player context, passed to constructor
	 * @param player a reference to player object, passed to constructor
	 * @return a singleton instance of this class
	 */
	public static PlayerState getInstance(PlayerContext context, Player player) {
		if(instance == null){
			synchronized(Player1TurnState.class){
				if(instance == null){
					instance = new Player1TurnState(context, player);
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
			synchronized(Player1TurnState.class){
				if(instance == null){
					throw new EmptyPlayerState("Player 1 Turn has not been created yet. Need to specify player.");
				}
			}
		}
		return instance;
	}

	/**
	 * Does not need to do anything for now
	 */
	public void handle()
	{
		
	}


}
