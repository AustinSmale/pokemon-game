package exception;

/**
 * @author Nick Rummel
 * SWE200
 * Exception thrown when a Pokemon cannot be created
 * due to having the wrong name
 */
public class InvalidPokemonException extends Exception
{
	/**
	 * Constructor for exception
	 * @param message for super class
	 */
	public InvalidPokemonException(String message)
	{
		super(message);
	}
}
