public class Vanguard extends Monster{
  protected final double VANGUARD_ATKRATING = 0.75;
  protected final int VANGUARD_DEFENSE = 20;

  public Vanguard(){
    super();
    atkRating = VANGUARD_ATKRATING;
    defense = VANGUARD_DEFENSE;
  }

  public static String about(){
    return "An enemy skilled in the art of defense.";
  }
}
