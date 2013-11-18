public class Barbarian extends Character{

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
	return "I am is Barbarian. You don wanta fite me sone.  I carry big club around, and bash your skull onto the ground." ;
    }
}
