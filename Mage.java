// DANIEL ZABARI
// pd 9
// HW24
// 2013-11-14
public class Mage extends Character{

    public Mage(String name){
	this.name=name;
	this.life=150;
	this.defense=45;
	this.strength=60;
	this.attackRating=.7;
    }

    public void normalize() {
	    this.attackRating = .7;
	    this.defense = 20;
    }

    public void specialize() {
	    this.attackRating = .8;
	    this.defense = 15;
    }

    public int equip( Armor a ) {return -1;}

    public static String about() {
	return "Abra-kadabra, Alakazam, the Mage, the bearded wizard man.  Witches, warlocks, healers too, all part of the good Mage crew.  Casting spells and using powers, they demolish armies within hours.";
    }

}
