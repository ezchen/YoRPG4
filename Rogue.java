//Eric Chen
//pd 9
//HW25
//2013-11-14

public class Rogue extends Character {

	private double dodge;

	public Rogue() {
		this.name = "no name specified";
		this.life = 100;
		this.strength = 65;
		this.defense = 15;
		this.attackRating = .5;
		this.dodge = .5;
	}

	public Rogue( String name ) {
		this();
		this.name = name;
	}

	public void specialize() {
		this.dodge = .3;
		this.attackRating = .6;
	}

	public void normalize() {
		this.dodge = .5;
		this.attackRating = .5;
	}

	public boolean dodge() {
		boolean out = true;
		if ( Math.random() < .5 ) {
			out = false;
		}
		return out;
	}
			
	public static String about() {
		return "A sly rogue. Pitifully weak, but is capable of dodging attacks. Specializing decreases dodge chance and increases attack power";
	}

}

