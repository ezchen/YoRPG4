public class Weapon {

	protected double damage;
	protected int level;

	public Weapon() {
		this.damage = 0;
	}

	public Weapon( int newDamage ) {
		this.damage = newDamage;
	}

	public double getDamage() {
		return this.damage;
	}

	public int getLevel() {
		return this.level;
	}

}
