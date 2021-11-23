public class Protagonist extends Character{
  public final double INIT_ATKRATING = 1;
  public final int INIT_DEFENSE = 30;

  public Protagonist(){
    health = 100;
    strength = 50;
    defense = INIT_DEFENSE;
    atkRating = INIT_ATKRATING;
  }

  private String name;

  public Protagonist(String input){
    name = input;
  }

  public String getName(){
    return name;
  }

  // test your luck. using consecutive special attacks will exponentially
  // increase your attack rating, but also exponentially decrease your defense.
  public void specialize(){
    halfDefense();
    boostAtk();
  }

  public void normalize(){
    resetDefense();
    resetAtk();
  }

}
