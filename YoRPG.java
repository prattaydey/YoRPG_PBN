/**********************************************
 * class YoRPG -- Driver file for Ye Olde Role Playing Game.
 * Simulates monster encounters of a wandering adventurer.
 * Required classes: Protagonist, Monster
 *
 * USAGE:
 * Compile. Note messages generated.
 * Devise a plan of attack with your trio.
 * Code incrementally, testing each bit of new functionality as you go.
 * The only modification you should make to this driver file is moving comment bar down in main method, and filling in DISCO/QCC
 * (If you feel other changes are merited, note what and why, so that we may discuss on the 'morrow.)
 *
 * DISCO:
 * - With inheritance, you can still refer to subclasses with the class type of their superclass.
 * - If you plan on using the class type of a superclass to refer to a subclass's method that IS NOT present in the superclass, you will get an error.
 *
 * QCC:
 * - You can use protected to have a subclass refer to an inherited instance variable. Is there a similar way for a superclass to refer to a subclass's instance variable?
 **********************************************/

/***********************************************
 * OUR DRIVER MODS
 * We allowed the user to make a choice on which class they want to play as.
 *  - To do this, we redefined String s and declared int chosenClass to hold the value of the int input corresponding to a certain calss.
 * We implemented Math.random() to determine what kind of Monster you will encounter.
 *  - We defined int temp as a helper variable to store the value of a randomly generated int in the range [0,2].
 * We added print statements of the descriptions of different subclasses of Protagonists and Monsters.
 * We added print statements letting the user know their current HP and the enemy's current HP.
 ***********************************************/

import java.io.*;
import java.util.*;

public class YoRPG {

  // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

  //change this constant to set number of encounters in a game
  public final static int MAX_ENCOUNTERS = 5;

  //each round, a Protagonist and a Monster will be instantiated...
  private Protagonist pat;
  private Monster smaug;
  private int temp; // used to generate Monster type

  private int moveCount;
  private boolean gameOver;
  private int difficulty;
  private int chosenClass;

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
    void newGame() -- gathers info to begin a new game
    pre:
    post: according to user input, modifies instance var for difficulty
    and instantiates a Protagonist
    =============================================*/
  public void newGame() {
    String s;
    String name = "";
    s = "~~~ Welcome to Ye Olde RPG! ~~~\n";

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

    s = "\nChoose your class: \n";
    s += "\t1: Fighter\n";
    System.out.println();
    System.out.println("Fighter: " + Fighter.about());
    s += "\t2: Tank\n";
    System.out.println("Tank: " + Tank.about());
    s += "\t3: Healer\n";
    System.out.println("Healer: " + Healer.about());
    s += "Selection: ";
    System.out.print( s );

    try {
        chosenClass = Integer.parseInt( in.readLine() );
    }
    catch ( IOException e ) { }

    s = "Intrepid protagonist, what doth thy call thyself? (State your name): ";
    System.out.print( s );

    try {
	    name = in.readLine();
    }
    catch ( IOException e ) { }

    // instantiate the player's character
    if (chosenClass == 1){
      pat = new Fighter(name);
    } else if (chosenClass == 2){
      pat = new Tank(name);
    } else {
      pat = new Healer(name);
    }

  }//end newGame()


  /*=============================================
    boolean playTurn -- simulates a round of combat
    pre:  Protagonist pat has been initialized
    post: Returns true if player wins (monster dies).
    Returns false if monster wins (player dies).
    =============================================*/
  public boolean playTurn() {
    int i = 1;
    int d1, d2;

    if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println( "\nNothing to see here. Move along!" );
    else {
	    System.out.println( "\nLo, yonder monster approacheth!" );

      temp = (int)(Math.random() * 3);
      if (temp == 0){
        smaug = new Peasant();
        System.out.println("\nHere approacheth a Peasant!");
        System.out.println(Peasant.about());
      }
      else if (temp == 1){
        smaug = new Soldier();
        System.out.println("\nHere approacheth a Soldier!");
        System.out.println(Soldier.about());
      }
      else{
        smaug = new Vanguard();
        System.out.println("\nHere approacheth a Vanguard!");
        System.out.println(Vanguard.about());
      }

	    while( smaug.isAlive() && pat.isAlive() ) {

        // Give user the option of using a special attack:
        // If you land a hit, you incur greater damage,
        // ...but if you get hit, you take more damage.
        try {
          System.out.println( "\nDo you feel lucky?" );
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

        System.out.println( "\n" + pat.getName() + " dealt " + d1 +
                            " points of damage." +
                            "\n" + "The enemy's current health is " + smaug.getHP() + ".");

        System.out.println( "\n" + "Ye Olde Monster smacked " + pat.getName() +
                            " for " + d2 + " points of damage." +
                            "\n" + "Your current health is " + pat.getHP() + ".");
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


  public static void main( String[] args ) {
    //As usual, move the begin-comment bar down as you progressively
    //test each new bit of functionality...

    //loading...
    YoRPG game = new YoRPG();

    int encounters = 0;

    while( encounters < MAX_ENCOUNTERS ) {
    if ( !game.playTurn() )
    break;
    encounters++;
    System.out.println();
    }

    System.out.println( "Thy game doth be over." );
	  /*================================================
	  ================================================*/
  }//end main

}//end class YoRPG
