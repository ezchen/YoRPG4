public class Thief extends Monster {

	public Thief() {
		this.name = "The thief ";
		this.life = 50;
		this.strength = (int) (10 + (46 * Math.random()));
		this.defense = 10;
		this.attackRating = .8;
		this.dodge = .2;
	}

	public static String about() {
		return "Sneaky monster, with a low chance of dodging";
	}
}


