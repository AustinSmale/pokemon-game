package stadium;

import java.util.ArrayList;

import pokemon.NullPokemon;
import pokemon.Pokemon;

/**
 * @author Nathaniel Manning
 * @author Elisabeth Ostrow -- added reset method
 */
public class Player
{
	/**
	 * @param pokemon is the array list of pokemon that the player has.
	 * @param active pokemon is the pokemon that is currently being used
	 * in battle.
	 */
	protected ArrayList<Pokemon> pokemon;
	private Pokemon activePokemon;

	/**
	 * Constructor for the player.
	 * Initializes the pokemon array list for holding pokemon
	 */
	public Player()
	{
		pokemon = new ArrayList<Pokemon>(3);
	}

	/**
	 *
	 * @param pokeNum is the index where you are looking for a pokemon
	 * @return the pokemon at the specified index
	 */
	public Pokemon getPokemon(int pokeNum)
	{
		return pokemon.get(pokeNum);
	}

	/**
	 * @param poke is the pokemon that you are adding to the arraylist
	 * @return true if the pokemon was added to the array list
	 * and false if they were not added tot he arraylist.
	 */
	public boolean addPokemon(Pokemon poke)
	{
		return pokemon.add(poke);

	}

	/**
	 * Calculates the damage of a move on a pokemon and then inflicts that damage.
	 * If the move will result in the enemy pokemon's health going past 0, it sets
	 * their health to 0.  Otherwise it will subtract the damage from their current
	 * health.
	 * @param enemyPlayer is the enemy player that you are fighting
	 * @param moveNum is the index of the move that the pokemon will use.
	 */
	public void attack(Player enemyPlayer, int moveNum)
	{
		Pokemon enemyPokemon = enemyPlayer.getActivePokemon();
		int damage = activePokemon.getAttack(moveNum).calculateDamage(enemyPlayer);
		if(enemyPokemon.getHP() - damage <= 0)
		{
			enemyPokemon.setHp(0);
			enemyPokemon = new NullPokemon(enemyPokemon.getName(), enemyPokemon.getHP());
			replacePokemon(enemyPlayer, enemyPokemon);

			boolean newPokemon = false;
			ArrayList<Pokemon> enemyPokemonList = enemyPlayer.getList();
			for(int i = 0; i < enemyPokemonList.size(); i++)
			{
				if(newPokemon != true)
				{
					if(enemyPokemonList.get(i).getClass() != NullPokemon.class)
					{
						enemyPlayer.setActivePokemon(enemyPokemonList.get(i));
						newPokemon = true;
						Stadium.getStadium().notifyObservers();
					}
				}
			}
		}
		else
		{
			enemyPokemon.takeDamage(damage);
		}
	}

	/**
	 * returns the active pokemon
	 * @return the active pokemon
	 */
	public Pokemon getActivePokemon()
	{
		return activePokemon;
	}

	/**
	 * Sets the active pokemon
	 * @param pokemon is the pokemon that you are setting the active pokemon
	 */
	public void setActivePokemon(Pokemon pokemon)
	{
		activePokemon = pokemon;
	}

	/**
	 * @return the pokemon array list
	 */
	public ArrayList<Pokemon> getList()
	{
		return pokemon;
	}

	/**
	 * Replaces the active pokemon of the enemy player with a new pokemon.
	 * @param enemyPlayer is the player who's pokemon you are changing.
	 * @param newPokemon is the new pokemon you are replacing the player's
	 * active pokemon with.
	 */
	public void replacePokemon(Player player, Pokemon newPokemon)
	{
		int indexOfOldPokemon = player.getList().indexOf(player.getActivePokemon());
		player.getList().set(indexOfOldPokemon, newPokemon);
	}

	/**
	 * Initializes pokemon array list to a new empty array list
	 * to avoid testing complications
	 * @author Elisabeth Ostrow
	 */
	public void reset(){
		pokemon.clear();
	}
}
