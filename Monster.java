 //Eric Chen
//pd 9
//HW25
//2013-11-14
 public class Monster extends Character {

	protected int gold;

	public Monster() {
		this.name = "The monster ";
		this.life = 150;
		this.strength = (int) (20 + (46 * Math.random()));
		this.defense = 20;
		this.attackRating = .9;
		this.gold = (int) (this.strength);
	}

	public void specialize() {
		System.out.println( "monsters don't have special attacks");
	}

	public void normalize() {
		System.out.println( "monsters don't have special attacks");
	}

	public int getGold() {
		return this.gold;
	}

        public int equip( Armor a ) {return -1;}

	public static String about() {
		return "Monsters run and monsters fly, monsters yonder monsters nigh, Mage and Rogue they gobble up, on Warrior they like to sup.  If you see one then beware, make sure you don't stop and stare. Cause if you meet one eye to eye, why then, you will surely die.";
	}

}
