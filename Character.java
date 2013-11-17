//Eric Chen
//pd 9
//HW25
//2013-11-14
 
public abstract class Character {

	//instance variables	
	protected String name;
	protected int life;
	protected int strength;
	protected int defense;
	protected double attackRating;
	protected Weapon weapon = new Weapon(0);
	protected Armor armor = new Armor(0);

	//getters
	public String getName() {
		return this.name;
	}

	public int getDefense() {
		return this.defense;
	}

	public int getLife() {
		return this.life;
	}

	//setters
	public void setLife( int newLife ) {
		this.life = newLife;
	}

	public void setStrength( int newStrength ) {
		this.strength = newStrength;
	}

	public void setDefense( int newDefense ) {
		this.defense = newDefense;
	}

	public void setAttackRating( int newAttackRating ) {
		this.attackRating = newAttackRating;
	}

	//methods	
	public boolean isAlive() {
		return this.life > 0;
	}

	public int lowerHP( int dmg ) {
		int old = this.life;
		this.life = this.life - dmg;
		return old;
	}

	public int attack( Character character ) {
		if ( character.dodge() ) {
			System.out.println( "You avoided the attack!" );
			return 0;
		} else {
			int damage = (int) ((this.strength * this.attackRating) - character.getDefense());
			if ( damage < 0 )
				damage = 0;
			character.lowerHP( damage );
			return damage;
		}
	}

	public double equip( Weapon newWeapon ) {
		this.weapon = newWeapon;
		return this.strength;
	}

	public double unEquipWeapon() {
		this.weapon = new Weapon( 0 );
		return this.attackRating;
	}

	public int equip( Armor newArmor ) {
		this.armor = newArmor;
		return this.defense;
	}

	public int unEquipArmor() {
		this.armor = new Armor(0);
		return this.defense;
	}

	public int use( Potion pot ) {
		this.life = this.life + pot.getLife();
		return this.life;
	}

	public abstract void specialize();

	public abstract void normalize();

	public abstract boolean dodge();

	public static String about() {
		return "a brave hero, unsure of what his profession is yet";	
	}

}
