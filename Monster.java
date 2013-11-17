 //Eric Chen
//pd 9
//HW25
//2013-11-14
 public class Monster extends Character {

	public Monster() {
		this.life = 150;
		this.strength = (int) (20 + (46 * Math.random()));
		this.defense = 20;
		this.attackRating = .9;
	}

	public void specialize() {
		System.out.println( "monsters don't have special attacks");
	}

	public void normalize() {
		System.out.println( "monsters don't have special attacks");
	}

	public boolean dodge() {
		return false;
	}

	public static String about() {
		return "smaug monster!";
	}

}
