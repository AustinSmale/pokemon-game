package factory;

import exception.InvalidPokemonException;
import pokemon.Pokemon;

/**
 * @author Nick Rummel
 * SWE200
 * Abstract factory for Grass type Pokemon
 */
public abstract class GrassPokemonProduct
{
	/**
	 * Abstract method signature to create
	 * Grass Pokemon
	 * @param name TODO
	 * @return Grass Pokemon
	 * @throws InvalidPokemonException
	 */
	public abstract Pokemon createGrassPokemon(String name) throws InvalidPokemonException;

}
