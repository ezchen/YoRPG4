// DANIEL ZABARI
// pd 9
// HW24
// 2013-11-14
public class Mage extends Character{

    public Mage(String name){
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
	return "Abra-kadabra, Alakazam, the Mage, the bearded wizard man.  Witches, warlocks, healers too, all part of the good Mage crew.  Casting spells and using powers, they demolish armies within hours.";
    }

}
