package exception;

/**
 * An exception that is thrown when getInstance() is called
 * without parameters for a class that has not been instantiated
 * yet
 * @author Elisabeth Ostrow
 *
 */
public class EmptyPlayerState extends Exception
{

	/**
	 * sends message to console
	 * @param string
	 */
	public EmptyPlayerState(String string)
	{
		super(string);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
