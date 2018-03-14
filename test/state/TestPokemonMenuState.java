package state;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import org.junit.Before;
import org.junit.Test;

import command.Invoker;
import exception.EmptyMenuState;
import pokemon.FirePokemon;
import pokemon.Pokemon;
import stadium.Player;

/**
 * Tests that this state will handle the selection of 
 * the active player's 3 pokemon and allow the player
 * to go back to noMenu state without ending the turn
 * @author Elisabeth Ostrow
 *
 */
public class TestPokemonMenuState
{
	/**
	 * Makes sure that menu and player context are reset
	 * before every test runs
	 */
	@Before
	public void init(){
		PlayerContext c = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		c.reset();
		m.reset();
	}
	
	
	/****************************************
	 *              State Pattern
	 *                  Tests
	 */
	
	/**
	 * Tests that selecting pokemon in slot 0 will set
	 * that as the active pokemon and end the turn
	 */
	@Test
	public void testSelectPokemon0()
	{
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = Invoker.getInstance();
		MenuState s = PokemonMenuState.getInstance(m, p, i);
		
		//create a player and give it a pokemon in slot 0
		Player p1 = p.getPlayer1Turn().getPlayer();
		Pokemon vulpix = new FirePokemon("Vulpix", 100);
		p1.addPokemon(vulpix); //slot 0
		
		//set p1's active pokemon to something different so we can be
		//sure that it changed
		Pokemon charmander = new FirePokemon("Charmander", 100);
		p1.setActivePokemon(charmander);
		
		//set menuContext's current event
		ActionEvent e = new ActionEvent(this, 0, "Pokemon0");
		m.actionPerformed(e);
		
		s.handle();
		
		//see that active pokemon was changed to vulpix
		assertEquals(vulpix, p1.getActivePokemon());
		//see that turn was ended and we are back to noMenuState
		assertEquals(p.player2Turn, p.getState());
		assertEquals(m.noMenu, m.getState());
	}
	
	/**
	 * Tests that selecting pokemon in slot 1 will set
	 * that as the active pokemon and end the turn
	 */
	@Test
	public void testSelectPokemon1()
	{
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = Invoker.getInstance();
		MenuState s = PokemonMenuState.getInstance(m, p, i);
		//create a player and give it a vulpix in slot 1
		//fill other slots with charmander
		Player p1 = p.getPlayer1Turn().getPlayer();
		Pokemon vulpix = new FirePokemon("Vulpix", 100);
		Pokemon charmander = new FirePokemon("Charmander", 100);
		p1.addPokemon(charmander); //slot 0
		p1.addPokemon(vulpix);     //slot 1
		
		//set p1's active pokemon to something different so we can be
		//sure that it changed
		p1.setActivePokemon(charmander);
		
		//set menuContext's current event
		ActionEvent e = new ActionEvent(this, 0, "Pokemon1");
		m.actionPerformed(e);
		
		s.handle();
		
		//see that active pokemon was changed to vulpix
		assertEquals(vulpix, p1.getActivePokemon());
		//see that turn was ended and we are back to noMenuState
		assertEquals(p.player2Turn, p.getState());
		assertEquals(m.noMenu, m.getState());
	}
	
	/**
	 * Tests that selecting pokemon in slot 2 will set
	 * that as the active pokemon and end the turn
	 */
	@Test
	public void testSelectPokemon2()
	{
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = Invoker.getInstance();
		MenuState s = PokemonMenuState.getInstance(m, p, i);
		//create a player and give it a vulpix in slot 1
		//fill other slots with charmander
		Player p1 = p.getPlayer1Turn().getPlayer();
		Pokemon vulpix = new FirePokemon("Vulpix", 100);
		Pokemon charmander = new FirePokemon("Charmander", 100);
		p1.addPokemon(charmander); //slot 0
		p1.addPokemon(charmander); //slot 1
		p1.addPokemon(vulpix);     //slot 2
		
		//set p1's active pokemon to something different so we can be
		//sure that it changed
		p1.setActivePokemon(charmander);
		
		//set menuContext's current event
		ActionEvent e = new ActionEvent(this, 0, "Pokemon2");
		m.actionPerformed(e);
		
		s.handle();
		
		//see that active pokemon was changed to vulpix
		assertEquals(vulpix, p1.getActivePokemon());
		//see that turn was ended and we are back to noMenuState
		assertEquals(p.player2Turn, p.getState());
		assertEquals(m.noMenu, m.getState());
	}
	
	/**
	 * Tests that selecting the go back option will return
	 * player to noMenuState without ending the turn
	 */
	@Test
	public void testGoBack(){

		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = Invoker.getInstance();
		MenuState s = PokemonMenuState.getInstance(m, p, i);
		
		
		//set menuContext's current event
		ActionEvent e = new ActionEvent(this, 0, "Go Back");
		m.actionPerformed(e);
		
		s.handle();
		
		//see that we are now in noMenuState but player turn has not changed
		assertEquals(m.noMenu, m.getState());
		assertEquals(p.player1Turn, p.getState());
	}

	
	/****************************************
	 *            Singleton Pattern
	 *                  Tests
	 */

	/**
	 * Tests that only one instance of the PokemonMenuState
	 * can be obtained
	 * @throws EmptyMenuState 
	 */
	@Test
	public void testSingleton() throws EmptyMenuState{
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = Invoker.getInstance();
		MenuState s = PokemonMenuState.getInstance(m, p, i);
		
		//this should return the same instance
		assertEquals(s, PokemonMenuState.getInstance());
	}
}
