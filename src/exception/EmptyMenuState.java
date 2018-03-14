package exception;

/**
 * Thrown when a menu state's getInstance() is called
 * before it is created
 * @author Elisabeth Ostrow
 *
 */
public class EmptyMenuState extends Exception
{

	public EmptyMenuState(String string)
	{
		super(string);
	}
	
}
