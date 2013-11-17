public class Armor {
	
	protected int defense;
	protected int level;

	public Armor() {
		this.defense = 0;
	}

	public Armor( int newLevel ) {
		this.defense = 10 * newLevel;
		this.level = newLevel;
	}

	public int getDefense() {
		return this.defense;
	}

	public int getLevel() {
		return this.level;
	}

	public int setDefense( int newDefense ) {
		this.defense = newDefense;
		return this.defense;
	}

	public int setLevel( int newLevel ) {
		this.level = newLevel;
		return this.level;
	}

}
