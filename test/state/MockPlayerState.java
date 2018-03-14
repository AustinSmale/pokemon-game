package state;

import stadium.Player;

/**
 * 
 * @author Elisabeth Ostrow
 *
 */
public class MockPlayerState extends PlayerState{

	/**
	 * @see PlayerState#PlayerState(PlayerContext, Player)
	 * @param context a reference to a player context object
	 * @param player a reference to a player object
	 */
	public MockPlayerState(PlayerContext context, Player player)
	{
		super(context, player);
	}

	/**
	 * sets context to the non-default turn state so we can see
	 * that something happened
	 * @see PlayerState#handle
	 */
	public void handle()
	{
		context.setState(context.player2Turn);
	}
	
}