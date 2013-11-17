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
		return "Warriors are known to stalk the land, their trusty sword is held in hand.  No monster can stand in their path, not often do they take a bath. With every strike of bow or pike, they kill the monsters we don't like.";
	}

}
