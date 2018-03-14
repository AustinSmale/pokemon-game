package state;

import command.Command;
import command.Invoker;
import exception.EmptyMenuState;

/**
 * Handles input when gui displays player
 * pokmeon selection menu
 * @author Elisabeth Ostrow
 *
 */
public class PokemonMenuState extends MenuState{

	private static volatile MenuState instance;
	
	/**
	 * 
	 * @param context a reference to MenuContext
	 * @param turn a reference to PlayerContext
	 */
	private PokemonMenuState(MenuContext context, PlayerContext turn, Invoker invoker){
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
			synchronized(PokemonMenuState.class){
				if(instance == null){
					instance = new PokemonMenuState(context, turn, invoker);
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
			synchronized(PokemonMenuState.class){
				if(instance == null){
					throw new EmptyMenuState("Pokemon Menu State has not been created yet.");
				}
			}
		}
		return instance;
	}
	
	
	/**
	 * Depending on the most recently performed action,
	 * activates the proper command in invoker
	 * 
	 * @see MenuState#handle()
	 */
	public void handle()
	{
		String event = context.getEvent();
		Command command = null;
		String pokemon = "";
		
		if(event.equals("Go Back")){
			
		}
		
		else{
			command = invoker.getCommand(4);
			
			if(event.equals("Pokemon0")){
				//select pokemon in slot 0
				pokemon = "0";
			}
			
			if(event.equals("Pokemon1")){
				//select pokemon in slot 1
				pokemon = "1";
			}
			
			if(event.equals("Pokemon2")){
				//select pokemon in slot 2
				pokemon = "2";
			}
		}
		
		//if command was set
		if(command != null){
			invoker.activateCommand(command, pokemon);
		}
	}
}
