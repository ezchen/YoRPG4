public class Necromancer extends Character{

    public Necromancer(String name){
	this.name=name;
	this.life=125;
	this.defense=100;
	this.strength=20;
	this.attackRating=0.2;
    }

    public void normalize() {}
    public void specialize() {}

    public int equip( Armor a ) {return -1;}

    public static String about() {
	return "Necromancers are quite skilled in animating people that were killed. Dark they spread, across the land, raising armies of undead. If you crss the path of one, my sole advice to you is run!";
    }
}
