package state;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import org.junit.Before;
import org.junit.Test;

import command.Invoker;
import exception.EmptyMenuState;
import pokemon.Pokemon;
import pokemon.WaterPokemon;
import stadium.Player;

/**
 * Tests the players can select certain pokemon to be 
 * constructed and added to their backpack
 * @author Elisabeth Ostrow
 *
 */
public class TestStartMenuState
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
		
		//remove all pokemon from the player1 backpack
		Player p1 = c.player1Turn.getPlayer();
		p1.reset();
	}
	
	
	/****************************************
	 *              State Pattern
	 *                  Tests
	 */

	/**
	 * Alright here we go....all the pokemon
	 * Let's start with all the water pokemon
	 */
	
	/**
	 * Test that selecting squirtle creates that pokemon
	 * in player 1's backpack
	 */
	@Test
	public void testCreateSquirtle()
	{
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = Invoker.getInstance();
		MenuState s = StartMenuState.getInstance(m, p, i);
		//create a player with an empty backpack
		Player p1 = p.getPlayer1Turn().getPlayer();
		
		//set menuContext's current event
		ActionEvent e = new ActionEvent(this, 0, "Squirtle");
		m.actionPerformed(e);
		
		s.handle();
		
		//since all the stats getting into the created pokemon has already been thoroughly tested in factory tests
		//I'm assuming that if the name is correct, then the proper pokemon was created
		assertEquals("Squirtle", p1.getPokemon(0).getName());
	}
	

	/**
	 * Test that selecting wartortle creates that pokemon
	 * in player 1's backpack
	 */
	@Test
	public void testCreateWartortle()
	{
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = Invoker.getInstance();
		MenuState s = StartMenuState.getInstance(m, p, i);
		//create a player with an empty backpack
		Player p1 = p.getPlayer1Turn().getPlayer();
		
		//set menuContext's current event
		ActionEvent e = new ActionEvent(this, 0, "Wartortle");
		m.actionPerformed(e);
		
		s.handle();
		
		//since all the stats getting into the created pokemon has already been thoroughly tested in factory tests
		//I'm assuming that if the name is correct, then the proper pokemon was created
		assertEquals("Wartortle", p1.getPokemon(0).getName());
	}
	

	/**
	 * Test that selecting blastoise creates that pokemon
	 * in player 1's backpack
	 */
	@Test
	public void testCreateBlastoise()
	{
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = Invoker.getInstance();
		MenuState s = StartMenuState.getInstance(m, p, i);
		//create a player with an empty backpack
		Player p1 = p.getPlayer1Turn().getPlayer();
		
		//set menuContext's current event
		ActionEvent e = new ActionEvent(this, 0, "Blastoise");
		m.actionPerformed(e);
		
		s.handle();
		
		//since all the stats getting into the created pokemon has already been thoroughly tested in factory tests
		//I'm assuming that if the name is correct, then the proper pokemon was created
		assertEquals("Blastoise", p1.getPokemon(0).getName());
	}
	

	/**
	 * Test that selecting poliwag creates that pokemon
	 * in player 1's backpack
	 */
	@Test
	public void testCreatePoliwag()
	{
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = Invoker.getInstance();
		MenuState s = StartMenuState.getInstance(m, p, i);
		//create a player with an empty backpack
		Player p1 = p.getPlayer1Turn().getPlayer();
		
		//set menuContext's current event
		ActionEvent e = new ActionEvent(this, 0, "Poliwag");
		m.actionPerformed(e);
		
		s.handle();
		
		//since all the stats getting into the created pokemon has already been thoroughly tested in factory tests
		//I'm assuming that if the name is correct, then the proper pokemon was created
		assertEquals("Poliwag", p1.getPokemon(0).getName());
	}
	
	/**
	 * Now for the fire pokemon
	 */
	
	/**
	 * Test that selecting charmander creates that pokemon
	 * in player 1's backpack
	 */
	@Test
	public void testCreateCharmander()
	{
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = Invoker.getInstance();
		MenuState s = StartMenuState.getInstance(m, p, i);
		//create a player with an empty backpack
		Player p1 = p.getPlayer1Turn().getPlayer();
		
		//set menuContext's current event
		ActionEvent e = new ActionEvent(this, 0, "Charmander");
		m.actionPerformed(e);
		
		s.handle();
		
		//since all the stats getting into the created pokemon has already been thoroughly tested in factory tests
		//I'm assuming that if the name is correct, then the proper pokemon was created
		assertEquals("Charmander", p1.getPokemon(0).getName());
	}
	
	/**
	 * Test that selecting charmeleon creates that pokemon
	 * in player 1's backpack
	 */
	@Test
	public void testCreateCharmeleon()
	{
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = Invoker.getInstance();
		MenuState s = StartMenuState.getInstance(m, p, i);
		//create a player with an empty backpack
		Player p1 = p.getPlayer1Turn().getPlayer();
		
		//set menuContext's current event
		ActionEvent e = new ActionEvent(this, 0, "Charmeleon");
		m.actionPerformed(e);
		
		s.handle();
		
		//since all the stats getting into the created pokemon has already been thoroughly tested in factory tests
		//I'm assuming that if the name is correct, then the proper pokemon was created
		assertEquals("Charmeleon", p1.getPokemon(0).getName());
	}
	
	/**
	 * Test that selecting charizard creates that pokemon
	 * in player 1's backpack
	 */
	@Test
	public void testCreateCharizard()
	{
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = Invoker.getInstance();
		MenuState s = StartMenuState.getInstance(m, p, i);
		//create a player with an empty backpack
		Player p1 = p.getPlayer1Turn().getPlayer();
		
		//set menuContext's current event
		ActionEvent e = new ActionEvent(this, 0, "Charizard");
		m.actionPerformed(e);
		
		s.handle();
		
		//since all the stats getting into the created pokemon has already been thoroughly tested in factory tests
		//I'm assuming that if the name is correct, then the proper pokemon was created
		assertEquals("Charizard", p1.getPokemon(0).getName());
	}
	
	/**
	 * Test that selecting vulpix creates that pokemon
	 * in player 1's backpack
	 */
	@Test
	public void testCreateVulpix()
	{
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = Invoker.getInstance();
		MenuState s = StartMenuState.getInstance(m, p, i);
		//create a player with an empty backpack
		Player p1 = p.getPlayer1Turn().getPlayer();
		
		//set menuContext's current event
		ActionEvent e = new ActionEvent(this, 0, "Vulpix");
		m.actionPerformed(e);
		
		s.handle();
		
		//since all the stats getting into the created pokemon has already been thoroughly tested in factory tests
		//I'm assuming that if the name is correct, then the proper pokemon was created
		assertEquals("Vulpix", p1.getPokemon(0).getName());
	}
	
	/**
	 * Test that selecting bulbasaur creates that pokemon
	 * in player 1's backpack
	 */
	@Test
	public void testCreateBulbasaur()
	{
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = Invoker.getInstance();
		MenuState s = StartMenuState.getInstance(m, p, i);
		//create a player with an empty backpack
		Player p1 = p.getPlayer1Turn().getPlayer();
		
		//set menuContext's current event
		ActionEvent e = new ActionEvent(this, 0, "Bulbasaur");
		m.actionPerformed(e);
		
		s.handle();
		
		//since all the stats getting into the created pokemon has already been thoroughly tested in factory tests
		//I'm assuming that if the name is correct, then the proper pokemon was created
		assertEquals("Bulbasaur", p1.getPokemon(0).getName());
	}
	
	/**
	 * Test that selecting ivyasaur creates that pokemon
	 * in player 1's backpack
	 */
	@Test
	public void testCreateIvyasaur()
	{
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = Invoker.getInstance();
		MenuState s = StartMenuState.getInstance(m, p, i);
		//create a player with an empty backpack
		Player p1 = p.getPlayer1Turn().getPlayer();
		
		//set menuContext's current event
		ActionEvent e = new ActionEvent(this, 0, "Ivyasaur");
		m.actionPerformed(e);
		
		s.handle();
		
		//since all the stats getting into the created pokemon has already been thoroughly tested in factory tests
		//I'm assuming that if the name is correct, then the proper pokemon was created
		assertEquals("Ivyasaur", p1.getPokemon(0).getName());
	}
	
	/**
	 * Test that selecting bulbasaur creates that pokemon
	 * in player 1's backpack
	 */
	@Test
	public void testCreateVenusaur()
	{
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = Invoker.getInstance();
		MenuState s = StartMenuState.getInstance(m, p, i);
		//create a player with an empty backpack
		Player p1 = p.getPlayer1Turn().getPlayer();
		
		//set menuContext's current event
		ActionEvent e = new ActionEvent(this, 0, "Venusaur");
		m.actionPerformed(e);
		
		s.handle();
		
		//since all the stats getting into the created pokemon has already been thoroughly tested in factory tests
		//I'm assuming that if the name is correct, then the proper pokemon was created
		assertEquals("Venusaur", p1.getPokemon(0).getName());
	}
	
	/**
	 * Test that selecting caterpie creates that pokemon
	 * in player 1's backpack
	 */
	@Test
	public void testCreateCaterpie()
	{
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = Invoker.getInstance();
		MenuState s = StartMenuState.getInstance(m, p, i);
		//create a player with an empty backpack
		Player p1 = p.getPlayer1Turn().getPlayer();
		
		//set menuContext's current event
		ActionEvent e = new ActionEvent(this, 0, "Caterpie");
		m.actionPerformed(e);
		
		s.handle();
		
		//since all the stats getting into the created pokemon has already been thoroughly tested in factory tests
		//I'm assuming that if the name is correct, then the proper pokemon was created
		assertEquals("Caterpie", p1.getPokemon(0).getName());
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
