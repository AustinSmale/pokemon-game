package command;

import java.util.ArrayList;

/**
 * Invoker class sets and activate commands based on state
 * @author Austin Smale
 */
public class Invoker {
	
	private ArrayList<Command> cmd;
	
	public static volatile Invoker instance;
	
	/**
	 * Singleton
	 */
	private Invoker(){
		cmd = new ArrayList<Command>(6);
	}
	
	/**
	 * Singleton getter
	 * @return singleton instance of invoker
	 */
	public static Invoker getInstance(){
		if(instance == null){
			synchronized(Invoker.class){
				if(instance == null){
					instance = new Invoker();
				}
			}
		}
		return instance;
	}
	
	/**
	 * Set attack command
	 * @param attackCommand
	 */
	public void setAttack(Command cmdd) {
		cmd.add(cmdd);
	}

	/**
	 * Set create pokemon command
	 * @param createPokemonCommand
	 */
	public void setCreatePokemon(Command cmd) {
		this.cmd.add(cmd);
	}

	/**
	 * Set open attack menu command
	 * @param openAttackMenuCommand
	 */
	public void setOpenAttackMenu(Command cmd) {
		this.cmd.add(cmd);
	}

	/**
	 * Set open pokemon menu command
	 * @param openPokemonMenuCommand
	 */
	public void setOpenPokemonMenu(Command cmd) {
		this.cmd.add(cmd);
	}

	/**
	 * Set pokemon selection command
	 * @param pokemonSelectionCommand
	 */
	public void setPokemonSelection(Command cmd) {
		this.cmd.add(cmd);
	}

	/**
	 * Set end turn command
	 * @param endTurnCommand
	 */
	public void setEndTurn(Command cmd) {
		this.cmd.add(cmd);
	}
	
	/**
	 * Get a command for test purposes
	 * 0 - Attack Command
	 * 1 - Create Pokemon Command
	 * 2 - Open Attack Menu Command
	 * 3 - Open Pokemon Menu Command
	 * 4 - Pokemon Selection Command
	 * 5 - End Turn Command
	 * @param index
	 * @return a command
	 */
	public Command getCommand(int index) {
		return cmd.get(index);
	}
	
	/**
	 * Active a command
	 * @param index of command
	 */
	public void activateCommand(Command command, String string) {
		for(int i=0; i<cmd.size(); i++) {
			if(command.getClass()==cmd.get(i).getClass()) {
				cmd.get(i).execute(string);
			}
		}
	}
	
}
