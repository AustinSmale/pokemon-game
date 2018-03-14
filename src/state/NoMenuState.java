package state;

import command.Invoker;
import command.InvokerBuilder;
import exception.EmptyMenuState;

/**
 * Handles input when gui displays no menu (default battle screen)
 * @author Elisabeth Ostrow
 *
 */
public class NoMenuState extends MenuState{
	
	private static volatile MenuState instance;
	

	private NoMenuState(MenuContext context, PlayerContext turn, Invoker invoker){
		super(context, turn, invoker);
	}

	/**
	 * Ensures that only one instance of this class is created.
	 * @param context a reference to the Menu Context, passed to constructor
	 * @param turn a reference to the Player Context, passed to constructor
	 * @return the singleton instance of this class
	 */
	public static MenuState getInstance(MenuContext context, PlayerContext turn, Invoker invoker){
		if(instance == null){
			synchronized(NoMenuState.class){
				if(instance == null){
					instance = new NoMenuState(context, turn, invoker);
				}
			}
		}
		return instance;
	}
	
	/**
	 * @return the current singleton instance of this class
	 * @throws EmptyMenuState 
	 */
	public static MenuState getInstance() throws EmptyMenuState{
		if(instance == null){
			synchronized(NoMenuState.class){
				if(instance == null){
					throw new EmptyMenuState("No Menu State has not been created yet.");
				}
			}
		}
		return instance;
	}
	

	
	public void handle()
	{
		String event = context.getEvent();
		
		//switch turn state
		if(event.equals("End Turn"))
			endTurn();
		
		//open attack menu
		else if(event.equals("Attack Menu"))
			openAttackMenu();
		
		//open pokemon menu
		else if(event.equals("Pokemon Menu"))
			openPokemonMenu();
	}
	
	/**
	 * Change the PlayerContext state to whichever one it's not
	 */
	public void endTurn(){
		
		PlayerState turn = turnContext.getState();
		
		if(turn == turnContext.player1Turn)
			turnContext.setState(turnContext.player2Turn);
		
		else
			turnContext.setState(turnContext.player1Turn);
	}
	
	/**
	 * Change MenuContext state to attackMenu
	 */
	public void openAttackMenu(){
		context.setState(context.attackMenu);
	}
	
	/**
	 * Change MenuContext state to pokemonMenu
	 */
	public void openPokemonMenu(){
		context.setState(context.pokemonMenu);
	}
}
