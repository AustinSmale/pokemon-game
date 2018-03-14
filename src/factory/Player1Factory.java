package factory;

import exception.InvalidPokemonException;
import pokemon.Pokemon;

/**
 * @author Nick Rummel
 * SWE200
 * Factory to create Player 1 and
 * give them the Pokemon they choose
 */
public class Player1Factory extends PokemonFactory
{

	@Override
	public Pokemon createFirePokemon(String name) throws InvalidPokemonException
	{
		FirePokemon1 fireType = new FirePokemon1();
		return fireType.createFirePokemon(name);
	}

	@Override
	public Pokemon createWaterPokemon(String name) throws InvalidPokemonException
	{
		WaterPokemon1 waterType = new WaterPokemon1();
		return waterType.createWaterPokemon(name);
	}

	@Override
	public Pokemon createGrassPokemon(String name) throws InvalidPokemonException
	{
		GrassPokemon1 grassType = new GrassPokemon1();
		return grassType.createGrassPokemon(name);
	}

}
