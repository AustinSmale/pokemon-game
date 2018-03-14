package factory;

import exception.InvalidPokemonException;
import pokemon.Pokemon;

/**
 * @author Nick Rummel
 * SWE200
 * Abstract factory for Fire type Pokemon
 */
public abstract class FirePokemonProduct
{
	/**
	 * Abstract method signature to create
	 * Fire Pokemon
	 * @param name TODO
	 * @return Fire Pokemon
	 * @throws InvalidPokemonException
	 */
	public abstract Pokemon createFirePokemon(String name) throws InvalidPokemonException;

}
