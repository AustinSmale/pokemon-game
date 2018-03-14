package factory;

import exception.InvalidPokemonException;
import pokemon.Pokemon;

/**
 * @author Nick Rummel
 * SWE200
 * Abstract factory for Water type Pokemon
 */
public abstract class WaterPokemonProduct
{
	/**
	 * Abstract method signature to create
	 * Water Pokemon
	 * @param name TODO
	 * @return Water Pokemon
	 * @throws InvalidPokemonException
	 */
	public abstract Pokemon createWaterPokemon(String name) throws InvalidPokemonException;

}
