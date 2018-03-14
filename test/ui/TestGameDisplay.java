package ui;

import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Before;
import org.junit.Test;

import exception.InvalidPokemonException;
import factory.Player1Factory;
import factory.Player2Factory;
import gameplay.MockStadiumObserver;
import pokemon.*;
import stadium.Player;
import stadium.Stadium;
import state.MenuContext;
import state.PlayerContext;


/**
 * Tests for the GUI
 * @author Austin Smale
 * @author Nick Rummel
 * @Nathaniel Manning
 *
 */
public class TestGameDisplay
{
	private GameDisplay GUI;
	private Stadium s;
	@Before
	public void setUp()
	{
		GUI = GameDisplay.getInstance();
		s = Stadium.getStadium();
		s.clearStadium();
	}

	/**
	 * Tests to make sure the Player's turn changes
	 * correctly in the GUI based on the state changing
	 * @author Nick Rummel
	 */
	@Test
	public void testUpdatePlayerTurn()
	{
		GameDisplay GUI = GameDisplay.getInstance();
		MenuContext mc = MenuContext.getInstance();
		mc.setState(mc.getNoMenu());
		Stadium s = Stadium.getStadium();
		Player1Factory p1f = new Player1Factory();
		Player2Factory p2f = new Player2Factory();
		try {
			s.getPlayer1().addPokemon(p1f.createFirePokemon("Charizard"));
		} catch (InvalidPokemonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s.getPlayer2().addPokemon(p2f.createWaterPokemon("Squirtle"));
		} catch (InvalidPokemonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s.getPlayer1().setActivePokemon(s.getPlayer1().getPokemon(0));
		s.getPlayer2().setActivePokemon(s.getPlayer2().getPokemon(0));
		PlayerContext pc = PlayerContext.getInstance();
		GUI.buildGame();
		pc.addObserver(GUI);
		pc.setState(pc.getPlayer1Turn());
		// no need to call update manually, automatically called when state changes
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Does the game show that it is Player 1's turn?"));
		pc.setState(pc.getPlayer2Turn());
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Does the game show that it is Player 2's turn?"));
	}

	/**
	 * @author Nathaniel Manning
	 * Tests that notifyObservers updates the observers and
	 * that the GUI changes according to the new information
	 */
	@Test
	public void testUpdatePlayers()
	{
		MockStadiumObserver observer1 = new MockStadiumObserver();
		Stadium.clearStadium();
		Stadium stadium = Stadium.getStadium();
		GameDisplay GUI = GameDisplay.getInstance();
		stadium.addObserver(observer1);
		stadium.addObserver(GUI);
		Player player1 = stadium.getPlayer1();
		Player player2 = stadium.getPlayer2();
		assertEquals(player1, stadium.getPlayer1());
		Pokemon vulpix = new FirePokemon("Vulpix", 200);
		Pokemon blastoise = new WaterPokemon("Blastoise", 200);
		player1.addPokemon(vulpix);
		player2.addPokemon(blastoise);
		player1.setActivePokemon(vulpix);
		player2.setActivePokemon(blastoise);
		stadium.notifyObservers();
		assertEquals(vulpix, player1.getActivePokemon());
		assertEquals(vulpix, stadium.getPlayer1().getActivePokemon());
		stadium.notifyObservers();
		assertEquals(blastoise, stadium.getPlayer2().getActivePokemon());
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Does the game show that the player 1 pokemon was updated?"));
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Does the game show that the player 2 pokemon was updated?"));
	}




}
