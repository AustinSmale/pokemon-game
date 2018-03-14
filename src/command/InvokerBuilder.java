package command;

/**
 * Create the Invoker class 
 * @author Austin Smale
 *
 */
public class InvokerBuilder {

	/**
	 * Create all the commands
	 * @return the singleton invoker
	 */
	public static Invoker createCommands() {
		Invoker inv = Invoker.getInstance();
		
		inv.setAttack(new AttackCommand());
		inv.setCreatePokemon(new CreatePokemonCommand());
		inv.setOpenAttackMenu(new OpenAttackMenuCommand());
		inv.setOpenPokemonMenu(new OpenPokemonMenuCommand());
		inv.setPokemonSelection(new PokemonSelectionCommand());
		inv.setEndTurn(new EndTurnCommand());
	
		return inv;
	}
}
