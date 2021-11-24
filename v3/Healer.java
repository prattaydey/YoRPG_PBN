public class Healer extends Protagonist{
  protected final double HEALER_ATKRATING = 1;
  protected final int HEALER_DEFENSE = 10;

  public Healer(String input){
    super(input);
    atkRating = HEALER_ATKRATING;
    defense = HEALER_DEFENSE;
  }

  public static String about(){
    return "A pacifist by nature, but not afraid to get into battle.\n" +
           "Specialize: Chance to heal for 20 HP. You will not attack this turn.\n";
  }

  // Chance to heal yourself for 20 HP.
  // You will not attack this turn.
  public void specialize(){
    if (LUCK_THRESHOLD < Math.random()){
      health += 20;
      System.out.println("A successful heal! Your Health is now " + health + ".");
    }
    else{
      System.out.println("You were not able to heal this time.");
    }
    atkRating = 0;
  }

  public void normalize(){
    atkRating = HEALER_ATKRATING;
  }
}
