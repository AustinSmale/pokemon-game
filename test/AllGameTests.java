import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import attacks.TestBasicMove;
import attacks.TestFireMove;
import attacks.TestGrassMove;
import attacks.TestWaterMove;
import command.TestAttackCommand;
import command.TestCreationPokemonCommand;
import command.TestEndTurnCommand;
import command.TestOpenAttackMenuCommand;
import command.TestOpenPokemonMenuCommand;
import factory.TestFireFactory;
import factory.TestFirePokemon1;
import factory.TestFirePokemon2;
import factory.TestFirePokemonProduct;
import factory.TestGrassFactory;
import factory.TestGrassPokemon1;
import factory.TestGrassPokemon2;
import factory.TestGrassPokemonProduct;
import factory.TestPlayer1Factory;
import factory.TestPlayer2Factory;
import factory.TestPokemonFactory;
import factory.TestWaterFactory;
import factory.TestWaterPokemon1;
import factory.TestWaterPokemon2;
import factory.TestWaterPokemonProduct;
import gameplay.TestStadiumObserver;
import pokemon.TestFirePokemon;
import pokemon.TestGrassPokemon;
import pokemon.TestNullPokemon;
import pokemon.TestPokemon;
import pokemon.TestWaterPokemon;
import stadium.TestPlayer;
import stadium.TestStadium;
import state.TestMenuContext;
import state.TestMenuState;
import state.TestNoMenuState;
import state.TestPlayerContext;
import state.TestPlayerState;
import ui.TestGameDisplay;

/**
 * Runs all of the tests in this project
 * @author Austin Smale
 * @author Nathaniel Manning
 * @author Lis Ostrow
 * @author Nick Rummel
 */

@RunWith(Suite.class)
@Suite.SuiteClasses(
{
	TestPokemon.class,

	TestNullPokemon.class,
	TestGrassPokemon.class,
	TestFirePokemon.class,
	TestWaterPokemon.class,
	TestPlayerContext.class,
	TestMenuContext.class,
	TestMenuState.class,
	TestNoMenuState.class,
	TestPlayerState.class,
	TestFirePokemon1.class,
	TestFirePokemon2.class,
	TestFirePokemonProduct.class,
	TestGrassPokemon1.class,
	TestGrassPokemon2.class,
	TestGrassPokemonProduct.class,
	TestWaterPokemon1.class,
	TestWaterPokemon2.class,
	TestWaterPokemonProduct.class,
	TestPlayer1Factory.class,
	TestPlayer2Factory.class,
	TestPokemonFactory.class,
	TestFireFactory.class,
	TestGrassFactory.class,
	TestWaterFactory.class,
	TestGameDisplay.class,
	TestBasicMove.class,
	TestFireMove.class,
	TestGrassMove.class,
	TestWaterMove.class,
	TestPlayer.class,
	TestStadium.class,
	TestStadiumObserver.class

}
)
public class AllGameTests
{

}
