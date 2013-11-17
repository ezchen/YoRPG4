public class Armor {
	
	protected int defense;
	protected int level;

	public Armor() {
		this.defense = 0;
	}

	public Armor( int newDefense ) {
		this.defense = newDefense;
	}

	public int getDefense() {
		return this.defense;
	}

	public int getLevel() {
		return this.level;
	}

}
