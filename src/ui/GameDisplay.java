package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import command.Invoker;
import command.InvokerBuilder;
import gameplay.StadiumObserver;
import gameplay.TurnObserver;
import stadium.Player;
import stadium.Stadium;
import state.MenuContext;
import state.Player1TurnState;
import state.Player2TurnState;
import state.PlayerContext;
import state.PlayerState;

/**
 * The main battle GUI, start menu GUI, move menu GUI, and change pokemon menu
 *
 * @author Austin Smale
 * @author Nick Rummel
 * @author Nathaniel Manning
 */
public class GameDisplay extends JFrame implements StadiumObserver, TurnObserver, ActionListener {
	private Stadium world;
	private Player player1;
	private Player player2;
	private MenuContext mc;
	private PlayerContext pc;

	JLabel playerTurn, player1Pokemon, player2Pokemon, player1Stats, player2Stats;
	JCheckBox[] player1CheckBoxes, player2CheckBoxes;
	JButton[] attackButton, chooseButton;
	JButton done, pokemonAttack, pokemonChoose;
	JFrame pokemonMenu, moveMenu, startMenu;
	ImageIcon pokemon1, pokemon2;

	private String[] names = { "Bulbasaur", "Ivysaur", "Venusaur", "Caterpie", "Charmander", "Charmeleon", "Charizard",
			"Vulpix", "Squirtle", "Wartortle", "Blastoise", "Poliwag" };

	boolean gameCreated = false;
	boolean pokemonMenuCreated = false;
	boolean attackMenuCreated = false;

	Invoker inv;

	private static volatile GameDisplay instance;

	public static void main(String[] args) {
		getInstance();
	}

	/**
	 * Getter for game display
	 * @return
	 */
	public static GameDisplay getInstance() {
		if (instance == null) {
			synchronized (Invoker.class) {
				if (instance == null) {
					instance = new GameDisplay();
				}
			}
		}
		return instance;
	}

	/**
	 * Singleton game display
	 */
	private GameDisplay() {
		Stadium.clearStadium();
		world = Stadium.getStadium();
		player1 = world.getPlayer1();
		player2 = world.getPlayer2();
		mc = MenuContext.getInstance();
		pc = PlayerContext.getInstance();
		world.addObserver(instance);
		player1CheckBoxes = new JCheckBox[12];
		player2CheckBoxes = new JCheckBox[12];
		playerTurn = new JLabel("Player 1's Turn", JLabel.CENTER);
		attackButton = new JButton[4];
		chooseButton = new JButton[3];
		done = new JButton("Done");
		pokemonAttack = new JButton("Attack");
		pokemonAttack.addActionListener(this);
		pokemonChoose = new JButton("Choose");
		pokemonChoose.addActionListener(this);
		for (int i = 0; i < 3; i++) {
			chooseButton[i] = new JButton("");
			chooseButton[i].addActionListener(this);
		}
		for(int i =0; i<4; i++) {
			attackButton[i] = new JButton("");
			attackButton[i].addActionListener(this);
		}
		inv = Invoker.getInstance();
		//set pokemon menu
		pokemonMenu = new JFrame("Choose A Pokemon");
		pokemonMenu.setLayout(new GridLayout(4, 1));
		//set move menu
		moveMenu = new JFrame("Move Selection");
		moveMenu.setLayout(new GridLayout(3, 2));

		// set layout
		setLayout(new GridLayout(4, 2));
		setVisible(false);
		buildStartMenu();

		setTitle("Battle");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Build main game display
	 */
	public void buildGame() {
		//mc.setState(mc.getNoMenu());
		// remove every component
		if (gameCreated) {
			getContentPane().removeAll();
		}
		world = world.getStadium();

		if(!gameCreated) {
			// get pokemon 1
			pokemon1 = new ImageIcon("images/" + world.getPlayer1().getActivePokemon().getName() + ".png");
			player1Pokemon = new JLabel("", pokemon1, JLabel.CENTER);
			player1Stats = new JLabel("<html>" + world.getPlayer1().getActivePokemon().getName() + "<br>"
					+ world.getPlayer1().getActivePokemon().getHP() + " HP Remaining</html>", JLabel.CENTER);

			// get pokemon 2
			pokemon2 = new ImageIcon("images/" + world.getPlayer2().getActivePokemon().getName() + ".png");
			player2Pokemon = new JLabel("", pokemon2, JLabel.CENTER);
			player2Stats = new JLabel("<html>" + world.getPlayer2().getActivePokemon().getName() + "<br>"
					+ world.getPlayer2().getActivePokemon().getHP() + " HP Remaining</html>", JLabel.CENTER);
		}
		// add all component
		add(pokemonAttack);
		add(pokemonChoose);
		add(player1Stats);
		add(player1Pokemon);
		add(player2Stats);
		add(player2Pokemon);
		add(playerTurn);
		resize(365, 575);
		getContentPane().revalidate();
		startMenu.setVisible(false);
		gameCreated = true;
	}

	/**
	 * Build the Change Pokemon Menu
	 */
	public void buildPokemonMenu(Player p) {
		//if menu was created already remove everything
		if (pokemonMenuCreated) {
			for (int i = 0; i < 3; i++) {
				chooseButton[i].setEnabled(true);
				pokemonMenu.remove(chooseButton[i]);
			}
		}
		//create all the buttons for the pokemon
		for (int i = 0; i < 3; i++) {
			chooseButton[i].setText("" + p.getPokemon(i).getName() + " " + p.getPokemon(i).getHP() + " HP Remaining");
			if (p.getPokemon(i).getHP() <= 0) {
				chooseButton[i].setEnabled(false);
			}
			if(p.getActivePokemon() == p.getPokemon(i))
				chooseButton[i].setEnabled(false);
			pokemonMenu.add(chooseButton[i]);
		}
		pokemonMenuCreated = true;
		pokemonMenu.pack();
	}

	/**
	 * Build the Attack Moves Menu
	 */
	public void buildMoveMenu(Player p) {
		//if the move menu was already created, remove everything
		if (attackMenuCreated) {
			for (int i = 0; i < 4; i++) {
				moveMenu.remove(attackButton[i]);
			}
		}
		for (int i = 0; i < 4; i++) {
			attackButton[i].setText("" + p.getActivePokemon().getAttack(i).getDescription());
			moveMenu.add(attackButton[i]);
		}
		//if pokemon is dead disable buttons
		if (p.getActivePokemon().getHP() <= 0) {
			for (int i = 0; i < 4; i++)
				attackButton[i].setEnabled(false);
		}
		else
			for (int i = 0; i < 4; i++)
				attackButton[i].setEnabled(true);
		attackMenuCreated = true;
		moveMenu.pack();
	}

	/**
	 * Build the Pokemon Slections Menu GUI
	 */
	public void buildStartMenu() {
		startMenu = new JFrame("Pokemon Selection");
		JLabel[] temp = new JLabel[3];
		startMenu.setLayout(new GridLayout(15, 2));
		// Make gui look nice
		temp[0] = new JLabel("Pokemon Selection (Pick 3)");
		temp[1] = new JLabel("Player 1");
		temp[2] = new JLabel("Player 2");
		for (int i = 0; i < 3; i++) {
			startMenu.add(new JLabel(""));
			temp[i].setHorizontalAlignment(JLabel.CENTER);
			startMenu.add(temp[i]);
		}

		// Create all pokemon names
		JLabel[] pokemonNames = new JLabel[12];
		pokemonNames[0] = new JLabel("Bulbasar");
		pokemonNames[1] = new JLabel("Ivysaur");
		pokemonNames[2] = new JLabel("Venusaur");
		pokemonNames[3] = new JLabel("Caterpie");
		pokemonNames[4] = new JLabel("Charmander");
		pokemonNames[5] = new JLabel("Charmeleon");
		pokemonNames[6] = new JLabel("Charizard");
		pokemonNames[7] = new JLabel("Vulpix");
		pokemonNames[8] = new JLabel("Squirtle");
		pokemonNames[9] = new JLabel("Wartotrle");
		pokemonNames[10] = new JLabel("Blastoise");
		pokemonNames[11] = new JLabel("Poliwag");

		for (int i = 0; i < 12; i++) {
			// inti all check boxes and add them to action listener
			player1CheckBoxes[i] = new JCheckBox();
			player2CheckBoxes[i] = new JCheckBox();
			player1CheckBoxes[i].addActionListener(this);
			player2CheckBoxes[i].addActionListener(this);
			// center everything
			player1CheckBoxes[i].setHorizontalAlignment(JCheckBox.CENTER);
			pokemonNames[i].setHorizontalAlignment(JLabel.CENTER);
			player2CheckBoxes[i].setHorizontalAlignment(JCheckBox.CENTER);
			// add all component
			startMenu.add(player1CheckBoxes[i]);
			startMenu.add(pokemonNames[i]);
			startMenu.add(player2CheckBoxes[i]);
		}
		//add done button
		startMenu.add(new JLabel(""));
		startMenu.add(done);
		done.addActionListener(this);

		startMenu.pack();
		startMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);
		startMenu.setResizable(false);
		startMenu.setVisible(true);
	}

	/**
	 * @author Nathaniel Manning
	 * Updates information on player 1 and uses this to
	 * draw the active pokemon that the trainer is using
	 * and it's stats.
	 */
	@Override
	public void updatePlayer1() {
		pokemon1 = new ImageIcon("images/" + world.getPlayer1().getActivePokemon().getName() + ".png");
		player1Pokemon = new JLabel("", pokemon1, JLabel.CENTER);
		player1Stats = new JLabel("<html>" + world.getPlayer1().getActivePokemon().getName() + "<br>"
				+ world.getPlayer1().getActivePokemon().getHP() + " HP Remaining</html>", JLabel.CENTER);
	}

	/**
	 * @author Nathaniel Manning
	 * Updates information on player 2 and uses this to
	 * draw the active pokemon that the trainer is using
	 * and it's stats.
	 */
	@Override
	public void updatePlayer2() {
		pokemon2 = new ImageIcon("images/" + world.getPlayer2().getActivePokemon().getName() + ".png");
		player2Pokemon = new JLabel("", pokemon2, JLabel.CENTER);
		player2Stats = new JLabel("<html>" + world.getPlayer2().getActivePokemon().getName() + "<br>"
				+ world.getPlayer2().getActivePokemon().getHP() + " HP Remaining</html>", JLabel.CENTER);
	}

	/**
	 * Make updates to the GUI from stadium about the player and their Pokemon.
	 * Also receive updates for the GUI about who's turn it is
	 *
	 * PlayerContext related updates are from Nick
	 *
	 * @author Nick Rummel
	 *
	 *         Stadium/Player related updated are from Nathaniel
	 * @author Nathaniel Manning
	 */
	@Override
	public void update() {
		pc = PlayerContext.getInstance();
		if (gameCreated) {
			if (pc.getState().getClass() == Player1TurnState.class) {
				playerTurn.setText("Player 1's Turn");
			}
			if (pc.getState().getClass() == Player2TurnState.class) {
				playerTurn.setText("Player 2's Turn");
			}
			world = Stadium.getStadium();
			updatePlayer1();
			updatePlayer2();
			buildGame();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == done) {
			//get player 1 pokemon
			for(int i=0; i<12; i++) {
				int num=0;
					pc.setState(pc.getPlayer1Turn());
					if (player1CheckBoxes[i].isSelected() && num < 3) {
						inv.activateCommand(inv.getCommand(1), names[i]);
						num++;
				}
			}
			//get player 2 pokemon
			for(int i=0; i<12; i++) {
				int num=0;
					pc.setState(pc.getPlayer2Turn());
					if (player2CheckBoxes[i].isSelected() && num < 3) {
						inv.activateCommand(inv.getCommand(1), names[i]);
						num++;
					}
			}
			mc.setState(mc.getNoMenu());
			//pc.setState(pc.getPlayer1Turn());
			setVisible(true);
			buildGame();
			pc.addObserver(instance);
		}
		//if attack button is pressed
		if(e.getSource() == pokemonAttack) {
			inv.activateCommand(inv.getCommand(2), "");
			mc.setState(mc.getAttackMenu());
		}
		//if attack 1 is pressed
		if(e.getSource() == attackButton[0])
			mc.actionPerformed(new ActionEvent(e, 0, "Attack0"));
		//if attack 2 is pressed
		if(e.getSource() == attackButton[1])
			mc.actionPerformed(new ActionEvent(e, 0, "Attack1"));
		//if attack 3 is pressed
		if(e.getSource() == attackButton[2])
			mc.actionPerformed(new ActionEvent(e, 0, "Attack2"));
		//if attack 4 is pressed
		if(e.getSource() == attackButton[3])
			mc.actionPerformed(new ActionEvent(e, 0, "Attack3"));

		//if choose pokemon button is pressed
		if(e.getSource() == pokemonChoose) {
			inv.activateCommand(inv.getCommand(3), "");
			mc.setState(mc.getPokemonMenu());
		}
		//if pokemon 1 is pressed
		if(e.getSource() == chooseButton[0]){
		//	mc.setState(mc.getPokemonMenu());
			mc.actionPerformed(new ActionEvent(e, 0, "Pokemon0"));
		}
		//if pokemon 2 is pressed
		if(e.getSource() == chooseButton[1]) {
			//mc.setState(mc.getPokemonMenu());
			mc.actionPerformed(new ActionEvent(e, 0, "Pokemon1"));
		}
		//if pokemon 3 is pressed
		if(e.getSource() == chooseButton[2]){
			//mc.setState(mc.getPokemonMenu());
			mc.actionPerformed(new ActionEvent(e, 0, "Pokemon2"));
		}
	}

	/**
	 * @author Nathaniel Manning
	 * Used for testing players inside of the GUI
	 * @return player1
	 */
	public Player getPlayer1()
	{
		return player1;
	}

	/**
	 * @author Nathaniel Manning
	 * Used for testing players inside of the GUI
	 * @return player2
	 */
	public Player getPlayer2()
	{
		return player1;
	}
	/**
	 * toggle display menus
	 *
	 * @param menu
	 * @param visable
	 */
	public void setVisable(String menu, boolean visable) {
		// if the pokemon menu needs to be displayed
		if (menu.equals("pokemon")) {
			// if it is player 1 turn
			if (pc.getState() == pc.getPlayer1Turn()) {
				if(visable)
					buildPokemonMenu(player1);
				pokemonMenu.setVisible(visable);
			}
			// if it is player 2 turn
			else if (pc.getState() == pc.getPlayer2Turn()) {
				if(visable)
					buildPokemonMenu(player2);
				pokemonMenu.setVisible(visable);
			}
		}
		if (menu.equals("move"))
			// if it is player 1 turn
			if (pc.getState() == pc.getPlayer1Turn()) {
				if(visable)
					buildMoveMenu(player1);
				moveMenu.setVisible(visable);
			}
			// if it is player 2 turn
			else if (pc.getState() == pc.getPlayer2Turn()) {
				if(visable)
					buildMoveMenu(player2);
				moveMenu.setVisible(visable);
			}
	}

}
