package factory;

import exception.InvalidPokemonException;
import pokemon.Pokemon;

/**
 * @author Nick Rummel
 * SWE200
 * Factory to create Player 2 and
 * give them the Pokemon they choose
 */
public class Player2Factory extends PokemonFactory
{

	@Override
	public Pokemon createFirePokemon(String name) throws InvalidPokemonException
	{
		FirePokemon2 fireType = new FirePokemon2();
		return fireType.createFirePokemon(name);
	}

	@Override
	public Pokemon createWaterPokemon(String name) throws InvalidPokemonException
	{
		WaterPokemon2 waterType = new WaterPokemon2();
		return waterType.createWaterPokemon(name);
	}

	@Override
	public Pokemon createGrassPokemon(String name) throws InvalidPokemonException
	{
		GrassPokemon2 grassType = new GrassPokemon2();
		return grassType.createGrassPokemon(name);
	}

}
