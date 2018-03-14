package factory;

import exception.InvalidPokemonException;
import pokemon.Pokemon;

/**
 * @author Nick Rummel
 * SWE200
 * Concrete Grass Pokemon for Player 2
 */
public class GrassPokemon2 extends GrassPokemonProduct
{

	@Override
	public Pokemon createGrassPokemon(String name) throws InvalidPokemonException
	{
		GrassFactory grassFactory = new GrassFactory();
		Pokemon grassPokemon;
		if(name.equalsIgnoreCase("Bulbasaur"))
		{
			grassPokemon = grassFactory.createBulbasaur();
			return grassPokemon;
		}
		if(name.equalsIgnoreCase("Ivysaur"))
		{
			grassPokemon = grassFactory.createIvysaur();
			return grassPokemon;
		}
		if(name.equalsIgnoreCase("Venusaur"))
		{
			grassPokemon = grassFactory.createVenusaur();
			return grassPokemon;
		}
		if(name.equalsIgnoreCase("Caterpie"))
		{
			grassPokemon = grassFactory.createCaterpie();
			return grassPokemon;
		}
		else
		{
			throw new InvalidPokemonException(name + " could not be created.\n");
		}
	}

}
