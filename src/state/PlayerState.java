package state;

import stadium.Player;

/**
 * Parent class for states that handle action
 * based on current player turn
 * @author Elisabeth Ostrow
 *
 */
public abstract class PlayerState {


	protected PlayerContext context;
	protected Player player;
	
	/**
	 * Sets a reference to the given context and player objects
	 * @param context the context that this state operates within
	 * @param player the reference to the player accessed by this state
	 */
	public PlayerState(PlayerContext context, Player player){
		this.context = context;
		this.player = player;
	}
	
	/**
	 * Takes the appropriate action depending on 
	 * user input and current state
	 */
	public abstract void handle();

	/**
	 * 
	 * @return the context that this state operates within
	 */
	public PlayerContext getContext()
	{
		return context;
	}

	/**
	 * 
	 * @return the player accessed by this state
	 */
	public Player getPlayer()
	{
		return player;
	}
	
	
}

