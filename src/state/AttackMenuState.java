package state;

import command.Command;
import command.Invoker;
import exception.EmptyMenuState;
import exception.EmptyPlayerState;

/**
 * Handles input when gui displays player's 
 * pokmeon attack menu
 * @author Elisabeth Ostrow
 *
 */
public class AttackMenuState extends MenuState{
	
	private static volatile MenuState instance;
	
	/**
	 * 
	 * @param context a reference to MenuContext
	 * @param turn a reference to PlayerContext
	 */
	private AttackMenuState(MenuContext context, PlayerContext turn, Invoker invoker){
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
			synchronized(AttackMenuState.class){
				if(instance == null){
					instance = new AttackMenuState(context, turn, invoker);
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
			synchronized(AttackMenuState.class){
				if(instance == null){
					throw new EmptyMenuState("Attack Menu State has not been created yet.");
				}
			}
		}
		return instance;
	}
	

	/**
	 * depending on the most recently performed action, 
	 * will activate the proper command in invoker
	 * @see MenuState#handle()
	 */
	public void handle()
	{
		
		String event = context.getEvent();
		Command command = null;
		String  attack = "";
		
		if(event.equals("Go Back")){
			
		}
		
		//handle an attack request
		else{
			command = invoker.getCommand(0);
			
			if(event.equals("Attack0")){
				//use attack in slot 0
				attack = "0";
			}
			
			if(event.equals("Attack1")){
				//use attack in slot 1
				attack = "1";
			}
			
			if(event.equals("Attack2")){
				//use attack in slot 2
				attack = "2";
			}
			
			if(event.equals("Attack3")){
				//use attack in slot 3
				attack = "3";
			}
		}
		
		//if command is set
		if(command != null){
			invoker.activateCommand(command, attack);
		}
	}

}
