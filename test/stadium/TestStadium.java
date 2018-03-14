package stadium;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import attacks.*;
import gameplay.*;
import pokemon.*;
import ui.GameDisplay;

public class TestStadium
{
	@Test
	public void testInizialization()
	{
		Stadium stadium = Stadium.getStadium();
		assertTrue(stadium != null);
		assertTrue(stadium.getObserverList() != null);
	}

	@Test
	public void testSetAndGetPlayer()
	{
		Player player1 = new Player();
		Player player2 = new Player();
		Stadium stadium = Stadium.getStadium();
		assertTrue(stadium.setPlayer1(player1));
		assertTrue(stadium.setPlayer2(player2));
		assertEquals(player1, stadium.getPlayer1());
		assertEquals(player2, stadium.getPlayer2());
	}

	@Test
	public void testAddAndRemoveObserver()
	{
		Stadium stadium = Stadium.getStadium();
		MockStadiumObserver observer1 = new MockStadiumObserver();
		assertTrue(stadium.addObserver(observer1));
		stadium.removeObserver(observer1);
		assertFalse(stadium.getObserverList().contains(observer1));
	}

	@Test
	public void testNotifyObserver()
	{
		Stadium.clearStadium();
		Stadium stadium = Stadium.getStadium();
		MockStadiumObserver observer1 = new MockStadiumObserver();
		stadium.addObserver(observer1);
		Player player1 = new Player();
		Player player2 = new Player();
		stadium.setPlayer1(player1);
		stadium.setPlayer2(player2);
		Pokemon charizard = new FirePokemon("Charizard", 200);
		Pokemon blastoise = new WaterPokemon("Blastoise", 200);
		AttackMove fireBlast = new Move("Fire Blast", 100);
		fireBlast = new FireType(fireBlast);
		charizard.setAttack(fireBlast, 0);
		player1.addPokemon(charizard);
		player1.setActivePokemon(charizard);
		player2.addPokemon(blastoise);
		player2.setActivePokemon(blastoise);
		player1.attack(player2, 0);
		stadium.notifyObservers();
		assertEquals(charizard, observer1.getPlayer1().getActivePokemon());
		assertEquals(blastoise, observer1.getPlayer2().getActivePokemon());

	}
}
