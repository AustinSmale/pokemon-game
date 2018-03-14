package pokemon;


import attacks.AttackMove;


/**
 * Abstract class for creating pokemon with their type
 * @author Austin Smale
 */
public abstract class Pokemon {

	protected int health;
	protected AttackMove[] attacks;
	protected String name;

	/**
	 * Create a pokemon with a name and its hp
	 * @param name pokemon name
	 * @param hp amount of health pokemon has
	 */
	public Pokemon(String name, int hp) {
		this.name = name;
		health = hp;
		attacks = new AttackMove[4];
	}

	/**
	 * Set the current health of the pokemon
	 * @param hp new amount of health
	 */
	public void setHp(int hp) {
		health = hp;
	}

	/**
	 * Get the current pokemon's health
	 * @return the amount of health this pokemon has
	 */
	public int getHP() {
		return health;
	}

	/**
	 * Get the current pokemon's name
	 * @return the name of the pokemon
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set an attack for the pokemon
	 * @param attack the attack to set
	 * @param attackNum the index in the array
	 * @return if attack was successfully added
	 */
	public void setAttack(AttackMove attack, int attackNum) {
		attacks[attackNum] = attack;
	}

	/**
	 * Get the attack at a certain index of the array
	 * @param attackNum the index in the attacks array
	 * @return the AttackMoves at the index
	 */
	public AttackMove getAttack(int attackNum) {
		return attacks[attackNum];
	}

	/**
	 * Pokemon takes damage
	 * @param dmg amount of damage taken
	 */
	public void takeDamage(int dmg)	{
		health -= dmg;
		if(health < 0)
			health =0;
	}
}
