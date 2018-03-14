package factory;

import exception.InvalidPokemonException;
import pokemon.Pokemon;

/**
 * @author Nick Rummel
 * SWE200
 * Concrete Water Pokemon for Player 1
 */
public class WaterPokemon1 extends WaterPokemonProduct
{

	@Override
	public Pokemon createWaterPokemon(String name) throws InvalidPokemonException
	{
		WaterFactory waterFactory = new WaterFactory();
		Pokemon waterPokemon;
		if(name.equalsIgnoreCase("Squirtle"))
		{
			waterPokemon = waterFactory.createSquirtle();
			return waterPokemon;

		}
		if(name.equalsIgnoreCase("Wartortle"))
		{
			waterPokemon = waterFactory.createWartortle();
			return waterPokemon;

		}
		if(name.equalsIgnoreCase("Blastoise"))
		{
			waterPokemon = waterFactory.createBlastoise();
			return waterPokemon;

		}
		if(name.equalsIgnoreCase("Poliwag"))
		{
			waterPokemon = waterFactory.createPoliwag();
			return waterPokemon;

		}
		else
		{
			throw new InvalidPokemonException(name + " could not be created.\n");
		}
	}

}
