public class Barbarian extends Character{

    public Barbarian(String name){
	this.name=name;
	this.life=125;
	this.defense=10;
	this.strength=50;
	this.attackRating=.7;
    }

    public void normalize() {}
    public void specialize() {}

    public int equip( Armor a ) {return -1;}

    public static String about() {
	return "I am is Barbarian. You don wanta fite me sone.  I carry big club around, and bash your skull onto the ground." ;
    }
}
