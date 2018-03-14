package gameplay;
/**
 * @author Nathaniel Manning
 */
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import attacks.AttackMove;
import attacks.FireType;
import attacks.Move;
import pokemon.FirePokemon;
import pokemon.Pokemon;
import pokemon.WaterPokemon;
import stadium.Player;
import stadium.Stadium;

public class TestStadiumObserver
{
	/**
	 * Tests that notifyObservers updates the observers
	 * and that the updatePlayer methods update information
	 * about the individual players.
	 */
	@Test
	public void testSubject()
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
