public class Necromancer extends Character{

    public Necromancer(String name){
	this.name=name;
	this.life=125;
	this.defense=20;
	this.strength=40;
	this.attackRating=2;
    }

    public void normalize() {
	    this.defense = 20;
	    this.attackRating = 2;
    }
    public void specialize() {
	    this.defense = 15;
	    this.attackRating = 2.1;
    }

    public int equip( Armor a ) {return -1;}

    public static String about() {
	return "Necromancers are quite skilled in animating people that were killed. Dark across the land they spread, raising armies of undead. If you cross the path of one, my sole advice to you is run!";
    }
}
