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
		return "Thieves will rob you, blind and bare.  They'll rob your skin, they'll rob your hair.  Your belt they'll steal right off your pants, they're quick, you slowpokes stand no chance.";
	}
}


