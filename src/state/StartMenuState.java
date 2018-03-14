package state;

import command.Command;
import command.Invoker;
import exception.EmptyMenuState;

/**
 * Handles input when gui displays the initial
 * pokemon selection screen
 * @author Elisabeth Ostrow
 *
 */
public class StartMenuState extends MenuState{

	private static volatile MenuState instance;
	
	/**
	 * 
	 * @param context a reference to MenuContext
	 * @param turn a reference to PlayerContext
	 * @param invoker a reference to the invoker
	 */
	private StartMenuState(MenuContext context, PlayerContext turn, Invoker invoker){
		super(context, turn, invoker);
	}
	
	/**
	 * Ensures that only one instance of this class is created.
	 * @param context a reference to the Menu Context, passed to constructor
	 * @param turn a reference to the Player Context, passed to constructor
	 * @param invoker a reference to the invoker
	 * @return the singleton instance of this class
	 */
	public static MenuState getInstance(MenuContext context, PlayerContext turn, Invoker invoker){
		if(instance == null){
			synchronized(StartMenuState.class){
				if(instance == null){
					instance = new StartMenuState(context, turn, invoker);
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
			synchronized(StartMenuState.class){
				if(instance == null){
					throw new EmptyMenuState("Start Menu State has not been created yet.");
				}
			}
		}
		return instance;
	}
	
	

	/**
	 * Depending on the last performed event,
	 * activates the proper command in the invoker
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
			command = invoker.getCommand(1);
			//create the pokemon specified
			pokemon = event;
			
		}
	
		//if command was set
		if(command != null){
			invoker.activateCommand(command, pokemon);
		}
	}
	
}
