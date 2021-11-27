public class Peasant extends Monster{
  protected final double PEASANT_ATKRATING = 1;
  protected final int PEASANT_DEFENSE = 10;

  public Peasant(){
    super();
    atkRating = PEASANT_ATKRATING;
    defense = PEASANT_DEFENSE;
  }

  public static String about(){
    return "A poor man with little to live for.";
  }
}
