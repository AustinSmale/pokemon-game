package command;

/**
 * Test the attack command
 * @author Austin Smale
 */
import static org.junit.Assert.*;

import org.junit.Test;

import attacks.FireType;
import attacks.Move;
import pokemon.FirePokemon;
import pokemon.Pokemon;
import stadium.Stadium;
import state.PlayerContext;

public class TestAttackCommand {

	/**
	 * Test player 1 attacking player 2
	 */
	@Test
	public void testPlayer1AttackCommand() {
		AttackCommand ac = new AttackCommand();
		Stadium s = Stadium.getStadium();
		//Create pokemon
		Pokemon p1 = new FirePokemon("charmander", 100);
		Pokemon p2 = new FirePokemon("charmander", 100);
		//set pokemon 1 moves
		p1.setAttack(new FireType(new Move("Fire Spin", 5)), 0);
		p1.setAttack(new FireType(new Move("Fire Spin", 10)), 1);
		p1.setAttack(new FireType(new Move("Fire Spin", 15)), 2);
		p1.setAttack(new FireType(new Move("Fire Spin", 20)), 3);
		//set pokemon 2 moves
		p2.setAttack(new FireType(new Move("Fire Spin", 5)), 0);
		p2.setAttack(new FireType(new Move("Fire Spin", 10)), 1);
		p2.setAttack(new FireType(new Move("Fire Spin", 15)), 2);
		p2.setAttack(new FireType(new Move("Fire Spin", 20)), 3);
		//set active pokemon
		s.getPlayer1().addPokemon(p1);
		s.getPlayer1().setActivePokemon(p1);
		s.getPlayer2().addPokemon(p2);
		s.getPlayer2().setActivePokemon(p2);
		//set player 1 turn
		PlayerContext.getInstance().setState(PlayerContext.getInstance().getPlayer1Turn());
		
		//attack player 2 pokemon with first move
		ac.execute("0");
		assertEquals(95, s.getPlayer2().getActivePokemon().getHP());
		//attack player 1 pokemon with fourth move
		ac.execute("3");
		assertEquals(80, s.getPlayer1().getActivePokemon().getHP());
		
		// attack player 2 pokemon with second move
		ac.execute("1");
		assertEquals(85, s.getPlayer2().getActivePokemon().getHP());
		// attack player 1 pokemon with third move
		ac.execute("2");
		assertEquals(65, s.getPlayer1().getActivePokemon().getHP());
		
		// attack player 2 pokemon with third move
		ac.execute("2");
		assertEquals(70, s.getPlayer2().getActivePokemon().getHP());
		// attack player 1 pokemon with second move
		ac.execute("1");
		assertEquals(55, s.getPlayer1().getActivePokemon().getHP());
		
		// attack player 2 pokemon with fourth move
		ac.execute("3");
		assertEquals(50, s.getPlayer2().getActivePokemon().getHP());
		// attack player 1 pokemon with first move
		ac.execute("0");
		assertEquals(50, s.getPlayer1().getActivePokemon().getHP());
	}

	@Test
	public void testWrongString() {
		AttackCommand ac = new AttackCommand();
		Stadium s = Stadium.getStadium();
		//Create pokemon
		Pokemon p1 = new FirePokemon("charmander", 100);
		Pokemon p2 = new FirePokemon("charmander", 100);
		//set pokemon 1 moves
		p1.setAttack(new FireType(new Move("Fire Spin", 5)), 0);
		p1.setAttack(new FireType(new Move("Fire Spin", 10)), 1);
		p1.setAttack(new FireType(new Move("Fire Spin", 15)), 2);
		p1.setAttack(new FireType(new Move("Fire Spin", 20)), 3);
		// set active pokemon
		s.getPlayer1().addPokemon(p1);
		s.getPlayer1().setActivePokemon(p1);
		s.getPlayer2().addPokemon(p2);
		s.getPlayer2().setActivePokemon(p2);
		// set player 1 turn
		PlayerContext.getInstance().setState(PlayerContext.getInstance().getPlayer1Turn());
		//player 2 pokemon should not attacked but turn should still switch
		ac.execute("4");
		assertEquals(100, s.getPlayer2().getActivePokemon().getHP());
		assertEquals(PlayerContext.getInstance().getState(), PlayerContext.getInstance().getPlayer2Turn());
	}
}
