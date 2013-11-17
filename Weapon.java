public class Weapon {

	protected double damage;
	protected int level;

	public Weapon() {
		this.damage = 0;
	}

	public Weapon( int newLevel ) {
		this.level = newLevel;
		this.damage = ((float) newLevel)/10.0;
	}

	public double getDamage() {
		return this.damage;
	}

	public int getLevel() {
		return this.level;
	}

	public int setLevel( int level ) {
		this.level = level;
		return this.level;
	}

}
