//Eric Chen
//pd 9
//HW25
//2013-11-14
 /*=============================================
  class YoRPG -- Driver file for Ye Olde Role Playing Game.
  Simulates monster encounters of a wandering adventurer.
  Required classes: Warrior, Monster
  =============================================*/

import java.io.*;
import java.util.*;

public class YoRPG {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

    //change this constant to set number of encounters in a game
    public final static int MAX_ENCOUNTERS = 5;
    public final static String[] SWORDS = {"Beginner's blade",
    									"Apprentice sword", 
    									"Warrior's companion",
    									"Battle-worn blade",
    									"Zweih\u00e4nder",
    									"Monster's bane",
    									"Elvish Blade",
    									"Hero's companion", 
    									"Sword of ten thousand legends",
    									"Sword of ten thousand legends (on fire)"
    								};
    public final static String[] ARMOR = {"Beginner's garb",
    									"Apprentice clothes",
    									"Iron armor", 
    									"Steel armor",
    									"Elvish armor",
    									"Hero's armor",
    									"Dwarven armor",
    									"Enchanted armor",
    									"Legendary armor",
    									"Mythril armor"
    								};
    public final static String[] STAVES = {"Beginner's staff",
    									"Experimental staff",
    									"Oak staff",
    									"Flame staff", 
    									"Frost staff", 
    									"Thunder staff", 
    									"Whirlwind staff", 
    									"Warlock's staff",
    									"Mighty staff", 
    									"Staff to end all staves"
    								};
    public final static String[] AXES = {"Caveman's club",
    									"Savage axe",
    									"Hatchet", 
    									"Woodsman's axe",
    									"Tomahawk", 
    									"Battleaxe",
    									"Halberd",
    									"Wrathful axe",
    									"Madman's axe",
    									"Mythril Axe",
    								};
    public final static String[] DAGGERS = {"Urchin's Knife",
    									"Iron dagger",
    									"Steel dagger",
    									"Thief's dagger",
    									"Assassin's blade",
										"Dagger of the unseen"
									};
	public final static String[] SPELLBOOKS = {"Novice spellbook",
										"Treatise on the dark arts",
										"Spellbook of misery",
										"Spellbook of corruption",
										"Spellbook of terror",
										"Blasphemer's spellbook",
										"Sorcerer's companion",
										"Book of the undead",
										"Prophet's spellbook", 
										""};

    //each round, a Warrior and a Monster will be instantiated
    private Character pat;   //Is it man or woman?
    private Monster smaug; //Friendly generic monster name, eh?

    private boolean isWarrior = false;
    private int type = 0;
    private int numPotions = 0;
    private int moveCount;
    private boolean gameOver;
    private int difficulty;

    private InputStreamReader isr;
    private BufferedReader in;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
    public YoRPG() {
		moveCount = 0;
		gameOver = false;
		isr = new InputStreamReader( System.in );
		in = new BufferedReader( isr );
		newGame();
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

    /*=============================================
      void newGame() -- facilitates info gathering to begin a new game
      pre:  
      post: according to user input, modifies instance var for difficulty 
      and instantiates a Warrior
      =============================================*/
    public void newGame() {

		String s;
		boolean selected = false;
		String name = "";
		s = "Welcome to Ye Olde RPG!\n";

		s += "\nChoose your difficulty: \n";
		s += "\t1: Easy\n";
		s += "\t2: Not so easy\n";
		s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
		s += "Selection: ";
		System.out.print( s );

		try {
		    difficulty = Integer.parseInt( in.readLine() );
		}
		catch ( IOException e ) { }
	
		
		s = "Intrepid warrior, what doth thy call thyself? (State your name): ";
		System.out.print( s );

		try {
		    name = in.readLine();
		}
		catch ( IOException e ) { }

		//System.out.println( );
		//System.out.println( Character.about() );

		while ( !selected ) {

			System.out.println("Choose thine character type:");
			System.out.println("\t1: Warrior");
			System.out.println("\t2: Mage");
			System.out.println("\t3: Barbarian");
			System.out.println("\t4: Rogue");
			System.out.println("\t5: Necromancer");

			try {
				type = Integer.parseInt(in.readLine());
			}
			catch ( IOException e ) { }

			//instantiate the player's character
			if (type == 1){
				pat = new Warrior(name);
				isWarrior = true;
			}
			else if (type == 2)
				pat = new Mage(name);
			else if (type == 3)
				pat = new Barbarian(name);
			else if (type == 4)
				pat = new Rogue(name);
			else if (type == 5)
				pat = new Necromancer(name);
			else
				System.out.println( "invalid input" );
			
			selected = (type > 0);
		}
    }//end newGame()


    /*=============================================
      boolean playTurn -- simulates a round of combat
      pre:  Warrior pat has been initialized
      post: Returns true if player wins (monster dies).
            Returns false if monster wins (player dies).
      =============================================*/
    public boolean playTurn() {

		int i = 1;
		int d1, d2;

		if ( Math.random() >= ( difficulty / 3.0 ) )
		    System.out.println( "Nothing to see here. Move along!" );

		else {
		    System.out.println( "Lo, yonder monster approacheth!" );

		    smaug = new Monster();

		    while( smaug.isAlive() && pat.isAlive() ) {

				// Give user the option of using a special attack:
				// If you land a hit, you incur greater damage,
				// ...but if you get hit, you take more damage.
				try {
				    System.out.println( "Do you feel lucky?" );
				    System.out.println( "\t1: Nay.\n\t2: Aye!" );
				    i = Integer.parseInt( in.readLine() );
				}
				catch ( IOException e ) { }

				if ( i == 2 )
				    pat.specialize();
				else
				    pat.normalize();

				d1 = pat.attack( smaug );
				d2 = smaug.attack( pat );

				System.out.println( pat.getName() + " dealt " + d1 + " points of damage.");

				System.out.println( "Ye Olde Monster hit back for " + d2 + " points of damage.");

		    }//end while

		    //option 1: you & the monster perish
		    if ( !smaug.isAlive() && !pat.isAlive() ) {
				System.out.println( "'Twas an epic battle, to be sure... " + 
						"You cut ye olde monster down, but " +
					    "with its dying breath ye olde monster. " +
				    	"laid a fatal blow upon thy skull." );
				return false;
		    }
		    //option 2: you slay the beast	
		    else if ( !smaug.isAlive() ) {
				System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
				return true;
		    }
		    //option 3: the beast slays you
		    else if ( !pat.isAlive() ) {
				System.out.println( "Ye olde self hath expired. You got dead." );
				return false;
		    }
		}//end else

		return true;
	}//end playTurn()
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // going to shop between battles
    public void goToShop(){
    	int weaponLevel = pat.getWeapon().getLevel();
    	int armorLevel = (isWarrior ? pat.getArmor().getLevel() : 0);
    	String[] listWeapons;
    	if(type == 1)
    		listWeapons = SWORDS;
    	if(type == 2)
    		listWeapons = STAVES;
    	if(type == 3)
    		listWeapons = AXES;
    	if(type == 4)
    		listWeapons = DAGGERS;
    	if(type == 4)
    		listWeapons = SPELLBOOKS;
    	System.out.println("Current Weapon: " + listWeapons[weaponLevel]);
    	if(isWarrior)
    		System.out.println("Current armor: " + listWeapons[armorLevel]);
    	System.out.println("Potions: " + numPotions);
    	System.out.println("SHOP");
    	System.out.println("====================");
    	System.out.println();
    }


    public static void main( String[] args ) {

		//loading...
		YoRPG game = new YoRPG();

		int encounters = 0;

		while( encounters < MAX_ENCOUNTERS ) {
		    if ( !game.playTurn() )
				break;
			else
				game.goToShop();
			encounters++;
			System.out.println();
			
		}

		System.out.println( "Thy game doth be over." );

    }//end main

}//end class YoRPG




/*==============================================
  =============================================*/
