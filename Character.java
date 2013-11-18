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
	protected double dodge = -1;
	protected double attackRating;
	protected Weapon weapon = new Weapon(0);
	protected Armor armor = new Armor(0);

	//getters
	public String getName() {
		return this.name;
	}

	public int getStrength() {
		return this.strength;
	}

	public int getDefense() {
		return this.defense;
	}

	public int getLife() {
		return this.life;
	}

	public double getAttackRating() {
		return this.attackRating;
	}

	public Weapon getWeapon() {
		return this.weapon;
	}

	public Armor getArmor() {
		return this.armor;
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
			int damage = (int) ((this.strength * (this.attackRating + this.weapon.getDamage()))
					       	- (character.getDefense() + character.getArmor().getDefense()));
			if ( damage < 0 )
				damage = 0;
			character.lowerHP( damage );
			return damage;
		}
	}

	public boolean dodge() {
		if (this.dodge > Math.random()) {
			return true;
		} else {
			return false;
		}
	}

	public double equip( Weapon newWeapon ) {
		this.weapon = newWeapon;
		return this.strength;
	}

	//we should replace the current weapon with an existing
	//object already with the default value of 0 instead of
	//creating a new object each time to save memory. But
	//keep this until we implement inventory
	public double unEquipWeapon() {
		this.weapon = new Weapon( 0 );
		return this.attackRating;
	}


	public int unEquipArmor() {
		this.armor = new Armor( 0 );
		return this.defense;
	}

	public int use( Potion pot ) {
		this.life = this.life + pot.getLife();
		return this.life;
	}

	public abstract int equip( Armor newArmor );

	public abstract void specialize();

	public abstract void normalize();


	public static String about() {
		return "a brave hero, unsure of what his profession is yet";	
	}

}
