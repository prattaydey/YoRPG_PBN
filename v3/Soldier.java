public class Soldier extends Monster{
  protected final double SOLDIER_ATKRATING = 1;
  protected final int SOLDIER_DEFENSE = 15;

  public Soldier(){
    super();
    atkRating = SOLDIER_ATKRATING;
    defense = SOLDIER_DEFENSE;
  }

  public static String about(){
    return "A soldier sent to his doom by whatever army he came from.";
  }
}
