package factory;

import exception.InvalidPokemonException;
import pokemon.Pokemon;

/**
 * @author Nick Rummel
 * SWE200
 * Pokemon factory is abstract so that
 * player factories can be used to create
 * the various kinds of Pokemon.
 */
public abstract class PokemonFactory
{
	/**
	 * Abstract method signature for creating
	 * a Fire Pokemon
	 * @param name TODO
	 * @return Fire Pokemon
	 * @throws InvalidPokemonException
	 */
	public abstract Pokemon createFirePokemon(String name) throws InvalidPokemonException;

	/**
	 * Abstract method signature for creating
	 * a Water Pokemon
	 * @param name TODO
	 * @return Water Pokemon
	 * @throws InvalidPokemonException
	 */
	public abstract Pokemon createWaterPokemon(String name) throws InvalidPokemonException;

	/**
	 * Abstract method signature for creating
	 * a Grass Pokemon
	 * @param name TODO
	 * @return Grass Pokemon
	 * @throws InvalidPokemonException
	 */
	public abstract Pokemon createGrassPokemon(String name) throws InvalidPokemonException;
}
