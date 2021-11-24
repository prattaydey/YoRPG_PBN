public class Tank extends Protagonist{
  protected final double TANK_ATKRATING = 0.9;
  protected final int TANK_DEFENSE = 12;

  public Tank(String input){
    super(input);
    atkRating = TANK_ATKRATING;
    defense = TANK_DEFENSE;
  }

  public static String about(){
    return "A big meaty man who loves to slap meat.\n" +
           "Specialize: Has a chance to double defense for a turn. Your attack for that turn is greatly weakened.\n";
  }

  // Chance to double defense for a turn.
  // Your attack for this turn will be greatly weakened.
  public void specialize(){
    if (Math.random() > LUCK_THRESHOLD){
      System.out.println("A successful defense!");
      defense = TANK_DEFENSE * 2;
    }
    else{
      System.out.println("Your defense failed!");
    }
    atkRating = TANK_ATKRATING / 1.5;
    }

  public void normalize(){
    defense = TANK_DEFENSE;
    atkRating = TANK_ATKRATING;
  }
}
