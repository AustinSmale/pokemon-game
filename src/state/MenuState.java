package state;

import command.Invoker;
import command.InvokerBuilder;

/**
 * Parent of states that handle user input
 * based on the currently displayed menu
 * @author Elisabeth Ostrow
 *
 */
public abstract class MenuState {

	protected MenuContext context;
	protected PlayerContext turnContext;
	protected Invoker invoker;

	/**
	 * Sets references to the MenuContext, PlayerContext, and Invoker
	 * @param context a reference to the MenuContext
	 * @param turn a reference to the PlayerContext
	 * @param invoker a reference to the Invoker
	 */
	public MenuState(MenuContext context, PlayerContext turn, Invoker invoker){
		this.context = context;
		this.turnContext = turn;
		this.invoker = invoker;
	}
	
	/**
	 * Performs appropriate action based on
	 * current state
	 */
	public abstract void handle();
	
	/**
	 * @return the menu context that this state references
	 */
	public MenuContext getContext(){
		return context;
	}
	
	/**
	 * @return the player context that this state references
	 */
	public PlayerContext getTurnContext(){
		return turnContext;
	}
	
	/**
	 * @return the current state of the player context
	 */
	public PlayerState getTurn(){
		return turnContext.getState();
		
	}
	
	/**
	 *
	 * @return the reference to the invoker
	 */
	public Invoker getInvoker(){
		return invoker;
	}
}
