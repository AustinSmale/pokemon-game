package factory;

import exception.InvalidPokemonException;
import pokemon.Pokemon;

/**
 * @author Nick Rummel
 * SWE200
 * Concrete Fire Pokemon for Player 2
 */
public class FirePokemon2 extends FirePokemonProduct
{

	@Override
	public Pokemon createFirePokemon(String name) throws InvalidPokemonException
	{
		FireFactory fireFactory = new FireFactory();
		Pokemon firePokemon;
		if(name.equalsIgnoreCase("Charmander"))
		{
			firePokemon = fireFactory.createCharmander();
			return firePokemon;
		}

		if(name.equalsIgnoreCase("Charmeleon"))
		{
			firePokemon = fireFactory.createCharmeleon();
			return firePokemon;
		}

		if(name.equalsIgnoreCase("Charizard"))
		{
			firePokemon = fireFactory.createCharizard();
			return firePokemon;
		}

		if(name.equalsIgnoreCase("Vulpix"))
		{
			firePokemon = fireFactory.createVulpix();
			return firePokemon;
		}
		else
		{
			throw new InvalidPokemonException(name + " could not be created.\n");
		}
	}

}
