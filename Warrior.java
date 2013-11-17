//Eric Chen
//pd 9
//HW25
//2013-11-14
 public class Warrior extends Character {

	public Warrior() {
		this.name = "no name specified";
		this.life = 150;
		this.strength = 70;
		this.defense = 30;
		this.attackRating = .5;
	}

	public Warrior( String name ) {
		this();
		this.name = name;
	}

	public void specialize() {
		this.attackRating = .7;
		this.defense = 15;
	}

	public void normalize() {
		this.attackRating = .5;
		this.defense = 30;
	}

	public boolean dodge() {
		return false;
	}

	public static String about() {
		return "A mighty warrior capable of strong melee attacks and boasts quite a decent defense";
	}

}
