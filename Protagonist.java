public class Protagonist extends Character{
  protected String name;

  public Protagonist(String input){
    super();
    name = input;
    strength = 40;
  }

  public String getName(){
    return name;
  }

  public void specialize(){
    // will be overwritten by subclass
  }

  public void normalize(){
    // will be overwritten by subclass
  }
}
