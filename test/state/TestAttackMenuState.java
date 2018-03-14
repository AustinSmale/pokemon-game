package state;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import org.junit.Before;
import org.junit.Test;

import attacks.FireType;
import attacks.Move;
import command.Invoker;
import exception.EmptyMenuState;
import pokemon.FirePokemon;
import pokemon.Pokemon;
import pokemon.WaterPokemon;
import stadium.Player;

/**
 * Tests that attack menu handles user input properly
 * @author Lis
 *
 */
public class TestAttackMenuState
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
	 * Test that the a pokemon's attack in slot 0 is executed
	 */
	@Test
	public void testAttack0()
	{
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = Invoker.getInstance();
		MenuState s = AttackMenuState.getInstance(m, p, i);
		//create players and some pokemon to use
		Player p1 = p.getPlayer1Turn().getPlayer();
		Player p2 = p.getPlayer2Turn().getPlayer();
		Pokemon vulpix = new FirePokemon("Vulpix", 100);
		Pokemon charmander = new FirePokemon("Charmander", 100);
		//give the players a pokemon
		p1.setActivePokemon(vulpix);
		p2.setActivePokemon(charmander);

		//set attack position 0 for attacking pokemon
		vulpix.setAttack(new FireType(new Move("Blaze", 20)), 0);

		//set menuContext's current event
		ActionEvent e = new ActionEvent(this, 0, "Attack0");
		m.actionPerformed(e);

		//since it's player1's turn (by default) this will make player1's pokemon
		//attack player2's pokemon and end the turn
		s.handle();

		//see that p2's pokemon took damage
		assertEquals(100 - 20, charmander.getHP());
		//see that it is now player2's turn and that we are in no menu state
		assertEquals(p.player2Turn, p.getState());
		assertEquals(m.noMenu, m.getState());


	}
	
	/**
	 * Test that the a pokemon's attack in slot 1 is executed
	 */
	@Test
	public void testAttack1(){
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = Invoker.getInstance();
		MenuState s = AttackMenuState.getInstance(m, p, i);
		//create players and some pokemon to use
		Player p1 = p.getPlayer1Turn().getPlayer();
		Player p2 = p.getPlayer2Turn().getPlayer();
		Pokemon vulpix = new FirePokemon("Vulpix", 100);
		Pokemon charmander = new FirePokemon("Charmander", 100);
		//give the players a pokemon
		p1.setActivePokemon(vulpix);
		p2.setActivePokemon(charmander);

		//set attack position 0 for attacking pokemon
		vulpix.setAttack(new FireType(new Move("Blaze", 30)), 1);

		//set menuContext's current event
		ActionEvent e = new ActionEvent(this, 0, "Attack1");
		m.actionPerformed(e);

		//since it's player1's turn (by default) this will make player1's pokemon
		//attack player2's pokemon and end the turn
		s.handle();

		//see that p2's pokemon took damage
		assertEquals(100 - 30, charmander.getHP());
		//see that it is now player2's turn and that we are in no menu state
		assertEquals(p.player2Turn, p.getState());
		assertEquals(m.noMenu, m.getState());

	}
	
	/**
	 * Test that the a pokemon's attack in slot 2 is executed
	 */
	@Test
	public void testAttack2(){
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = Invoker.getInstance();
		MenuState s = AttackMenuState.getInstance(m, p, i);
		//create players and some pokemon to use
		Player p1 = p.getPlayer1Turn().getPlayer();
		Player p2 = p.getPlayer2Turn().getPlayer();
		Pokemon vulpix = new FirePokemon("Vulpix", 100);
		Pokemon charmander = new FirePokemon("Charmander", 100);
		//give the players a pokemon
		p1.setActivePokemon(vulpix);
		p2.setActivePokemon(charmander);

		//set attack position 0 for attacking pokemon
		vulpix.setAttack(new FireType(new Move("Blaze", 40)), 2);

		//set menuContext's current event
		ActionEvent e = new ActionEvent(this, 0, "Attack2");
		m.actionPerformed(e);

		//since it's player1's turn (by default) this will make player1's pokemon
		//attack player2's pokemon and end the turn
		s.handle();

		//see that p2's pokemon took damage
		assertEquals(100 - 40, charmander.getHP());
		//see that it is now player2's turn and that we are in no menu state
		assertEquals(p.player2Turn, p.getState());
		assertEquals(m.noMenu, m.getState());

	}
	
	/**
	 * Test that the a pokemon's attack in slot 3 is executed
	 */
	@Test
	public void testAttack3(){
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = Invoker.getInstance();
		MenuState s = AttackMenuState.getInstance(m, p, i);
		//create players and some pokemon to use
		Player p1 = p.getPlayer1Turn().getPlayer();
		Player p2 = p.getPlayer2Turn().getPlayer();
		Pokemon vulpix = new FirePokemon("Vulpix", 100);
		Pokemon charmander = new FirePokemon("Charmander", 100);
		//give the players a pokemon
		p1.setActivePokemon(vulpix);
		p2.setActivePokemon(charmander);

		//set attack position 0 for attacking pokemon
		vulpix.setAttack(new FireType(new Move("Blaze", 50)), 3);

		//set menuContext's current event
		ActionEvent e = new ActionEvent(this, 0, "Attack3");
		m.actionPerformed(e);

		//since it's player1's turn (by default) this will make player1's pokemon
		//attack player2's pokemon and end the turn
		s.handle();

		//see that p2's pokemon took damage
		assertEquals(100 - 50, charmander.getHP());
		//see that it is now player2's turn and that we are in no menu state
		assertEquals(p.player2Turn, p.getState());
		assertEquals(m.noMenu, m.getState());

	}
	
	/**
	 * Test that a player can return to the noMenu window
	 * without ending the turn.
	 */
	@Test
	public void testGoBack(){
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = Invoker.getInstance();
		MenuState s = AttackMenuState.getInstance(m, p, i);
	
		//set menuContext's current event
		ActionEvent e = new ActionEvent(this, 0, "Go Back");
		m.actionPerformed(e);

		//since it's player1's turn (by default) this will make player1's pokemon
		//attack player2's pokemon and end the turn
		s.handle();

		//state should now be noMenuState
		assertEquals(m.noMenu, m.getState());
		//but turn should not change
		assertEquals(p.player1Turn, p.getState());
	}
	
	
	/****************************************
	 *            Singleton Pattern
	 *                  Tests
	 */

	/**
	 * Tests that only one instance of the AttackMenuState
	 * can be obtained
	 * @throws EmptyMenuState 
	 */
	@Test
	public void testSingleton() throws EmptyMenuState{
		PlayerContext p = PlayerContext.getInstance();
		MenuContext m = MenuContext.getInstance();
		Invoker i = Invoker.getInstance();
		MenuState s = AttackMenuState.getInstance(m, p, i);
		
		//this should return the same instance
		assertEquals(s, AttackMenuState.getInstance());
	}

}
