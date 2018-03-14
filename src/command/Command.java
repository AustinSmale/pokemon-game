package command;

/** 
 * @author Austin Smale
 * The interface for command to execute a command based on the state
 */
public interface Command {
	/**
	 * Executes the command
	 */
	public void execute(String string);
}
