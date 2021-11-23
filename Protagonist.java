public class Protagonist extends Character{
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
