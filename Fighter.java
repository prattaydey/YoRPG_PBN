public class Fighter extends Protagonist{
  protected final double FIGHTER_ATKRATING = 1.25;
  protected final int FIGHTER_DEFENSE = 10;

  public Fighter(String input){
    super(input);
    atkRating = FIGHTER_ATKRATING;
    defense = FIGHTER_DEFENSE;
  }

  public static String about(){
    return "A natural-born killer who loves to get into a battle.\n" +
           "Specialize: Increased damage but halved defense next turn.\n";
  }

  // Your next attack, if it hits, will have increased damage.
  // However, your defense will be halved for that turn.
  public void specialize(){
    defense = FIGHTER_DEFENSE / 2;
    atkRating = FIGHTER_ATKRATING * 1.5;
  }

  public void normalize(){
    defense = FIGHTER_DEFENSE;
    atkRating = FIGHTER_ATKRATING;
  }
}
