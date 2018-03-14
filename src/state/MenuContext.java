package state;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import command.Invoker;
import command.InvokerBuilder;

/**
 * Handles request from user input based on current menu
 * @author Elisabeth Ostrow
 *
 */
public class MenuContext implements ActionListener{

	protected MenuState startMenu;
	protected MenuState pokemonMenu;
	protected MenuState attackMenu;
	protected MenuState noMenu;
	
	private MenuState currentState;
	
	private String currentEvent;
	
	private Invoker invoker;
	
	private static volatile MenuContext instance;
	
	/**
	 * Sets references to all menu states and sets current state
	 * to startMenu
	 * @param turn a reference to PlayerContext that is passed
	 * to each menu's constructor
	 */
	private MenuContext(){
		PlayerContext turn = PlayerContext.getInstance();
		invoker = Invoker.getInstance();
		InvokerBuilder.createCommands();
		
		startMenu = StartMenuState.getInstance(this, turn, invoker);
		pokemonMenu = PokemonMenuState.getInstance(this, turn, invoker);
		attackMenu = AttackMenuState.getInstance(this, turn, invoker);
		noMenu = NoMenuState.getInstance(this, turn, invoker);
		
		currentState = startMenu;
	}
	
	/**
	 * Ensures that only one instance of this class is created
	 * @return the singleton instance of this class
	 */
	public static MenuContext getInstance(){
		if(instance == null){
			synchronized(MenuContext.class){
				if(instance == null){
					instance = new MenuContext();
				}
			}
		}
		return instance;
	}
	
	/**
	 * 
	 * @return the current handling state
	 */
	public MenuState getState()
	{
		return currentState;
	}
	
	/**
	 * Sets the current state
	 * @param state the new current state
	 */
	public void setState(MenuState state){
		currentState = state;
	}
	
	/**
	 * @return the name of the most recently performed action
	 */
	public String getEvent(){
		return currentEvent;
	}
	

	/**
	 *
	 * @return the reference to the invoker
	 */
	public Invoker getInvoker(){
		return invoker;
	}

	
	/**
	 * 
	 * @return reference to startMenuState
	 */
	public MenuState getStartMenu()
	{
		return startMenu;
	}

	/**
	 * 
	 * @return reference to pokemonMenuState
	 */
	public MenuState getPokemonMenu()
	{
		return pokemonMenu;
	}

	/**
	 * 
	 * @return reference to attackMenuState
	 */
	public MenuState getAttackMenu()
	{
		return attackMenu;
	}

	/**
	 * 
	 * @return reference to noMenuState
	 */
	public MenuState getNoMenu()
	{
		return noMenu;
	}

	/**
	 * Returns current State to its default, startMenu
	 * Empties reference to current event
	 */
	public void reset(){
		currentState = startMenu;
		currentEvent = null;
	}
	
	/**
	 * Gets the String event description from the
	 * performed event and sets a reference to it
	 */
	public void actionPerformed(ActionEvent event)
	{
		currentEvent = event.getActionCommand();
		currentState.handle();
		
	}
	
}
