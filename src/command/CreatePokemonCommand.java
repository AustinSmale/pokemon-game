package command;

import exception.InvalidPokemonException;
import factory.Player1Factory;
import factory.Player2Factory;
import stadium.Stadium;
import state.PlayerContext;

/**
 * Create the selected pokemon
 * @author Austin Smale
 *
 */
public class CreatePokemonCommand implements Command {

	/**
	 * Decides what type of pokemon needs to be created
	 */
	@Override
	public void execute(String string) {
		//call other execute method
		if(string.equals("Charmander") || string.equals("Vulpix") || string.equals("Charmeleon") || string.equals("Charizard"))
			execute("fire", string);
		else if(string.equals("Blastoise") || string.equals("Poliwag") || string.equals("Squirtle") || string.equals("Wartortle"))
			execute("water", string);
		else if(string.equals("Bulbasaur") || string.equals("Caterpie") || string.equals("Venusaur") || string.equals("Ivysaur"))
			execute("grass", string);
	}
	
	/**
	 * Create the pokemon for the players
	 * @param type pokemon type
	 * @param name pokemon name
	 */
	public void execute(String type, String name) {
		//if player 1 creates pokemon
		if (PlayerContext.getInstance().getState() == PlayerContext.getInstance().getPlayer1Turn()) {
			Player1Factory p1f = new Player1Factory();
			// create fire type
			if (type.equalsIgnoreCase("Fire"))
				try {
					Stadium.getStadium().getPlayer1().addPokemon(p1f.createFirePokemon(name));
				} catch (InvalidPokemonException e) {
					e.printStackTrace();
				}
			// create grass type
			if (type.equalsIgnoreCase("Grass"))
				try {
					Stadium.getStadium().getPlayer1().addPokemon(p1f.createGrassPokemon(name));
				} catch (InvalidPokemonException e) {
					e.printStackTrace();
				}
			// create water type
			if (type.equalsIgnoreCase("Water"))
				try {
					Stadium.getStadium().getPlayer1().addPokemon(p1f.createWaterPokemon(name));
				} catch (InvalidPokemonException e) {
					e.printStackTrace();
				}
			Stadium.getStadium().getPlayer1().setActivePokemon(Stadium.getStadium().getPlayer1().getPokemon(0));
		}
		//if player 2 creates pokemon
		if (PlayerContext.getInstance().getState() == PlayerContext.getInstance().getPlayer2Turn()) {
			Player2Factory p2f = new Player2Factory();
			// create fire type
			if (type.equalsIgnoreCase("Fire"))
				try {
					Stadium.getStadium().getPlayer2().addPokemon(p2f.createFirePokemon(name));
				} catch (InvalidPokemonException e) {
					e.printStackTrace();
				}
			// create grass type
			if (type.equalsIgnoreCase("Grass"))
				try {
					Stadium.getStadium().getPlayer2().addPokemon(p2f.createGrassPokemon(name));
				} catch (InvalidPokemonException e) {
					e.printStackTrace();
				}
			// create water type
			if (type.equalsIgnoreCase("Water"))
				try {
					Stadium.getStadium().getPlayer2().addPokemon(p2f.createWaterPokemon(name));
				} catch (InvalidPokemonException e) {
					e.printStackTrace();
				}
			Stadium.getStadium().getPlayer2().setActivePokemon(Stadium.getStadium().getPlayer2().getPokemon(0));
		}
	}

}
