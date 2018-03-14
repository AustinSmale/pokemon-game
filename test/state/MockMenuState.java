package state;

import command.Invoker;

/**
 * A mock object to test menu state and context
 * in when an action is performed
 * @author Elisabeth Ostrow
 *
 */
public class MockMenuState extends MenuState
{


	
	/**
	 *
	 * @param context a reference to menu context
	 * @param turn a reference to player context
	 * @param invoker a reference to the invoker
	 */
	public MockMenuState(MenuContext context, PlayerContext turn, Invoker invoker){
		super(context, turn, invoker);
	}

	/**
	 * changes the current state in context
	 * based on what button was pressed
	 */
	public void handle()
	{
		//if button 1
		String event = context.getEvent();
		if(event.equals("Button1")){
			context.setState(context.attackMenu);
		}
		
		//if button 2
		if(event.equals("Button2")){
			context.setState(context.pokemonMenu);
		}
		
	}

}
