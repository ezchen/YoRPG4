//Eric Chen
//pd 9
//HW25
//2013-11-14
 
public abstract class Character {
	
	protected String name;
	protected int life;
	protected int strength;
	protected int defense;
	protected double attackRating;

	public String getName() {
		return this.name;
	}

	public int getDefense() {
		return this.defense;
	}
	
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

	public abstract void specialize();

	public abstract void normalize();

	public abstract boolean dodge();

	public static String about() {
		return "a brave hero, unsure of what his profession is yet";	
	}

}
