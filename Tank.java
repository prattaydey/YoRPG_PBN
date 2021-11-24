public class Tank extends Protagonist{
  protected final double TANK_ATKRATING = 0.8;
  protected final int TANK_DEFENSE = 15;

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
      defense = TANK_DEFENSE * 2;
    }
    atkRating = TANK_ATKRATING / 2;
    }

  public void normalize(){
    defense = TANK_DEFENSE;
    atkRating = TANK_ATKRATING;
  }
}
