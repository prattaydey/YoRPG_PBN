public class Character{
  public final double LUCK_THRESHOLD = 0.5;

  protected int health;
  protected int strength;
  protected int defense;
  protected double atkRating;
  protected int damage;

  public boolean isAlive(){
    return health > 0;
  }

  public int getDefense(){
    return defense;
  }

  public void lowerHP(int dmg){
    health -= dmg;
  }

  public int attack(Character name){
    if (Math.random() > LUCK_THRESHOLD){
      damage = (int)((getStrength() * getAtkRating()) - name.getDefense());
      name.lowerHP(damage);
    }
    else {
      // miss!
      damage = 0;
    }
    return damage;
  }

  // additional methods

  public void halfDefense(){
    defense /= 2;
  }

  public void resetDefense(){
    defense = INIT_DEFENSE;
  }

  public void boostAtk(){
    atkRating *= 1.5;
  }

  public void resetAtk(){
    atkRating = INIT_ATKRATING;
  }

  // for testing:
  public int getHealth(){
    return health;
  }
}
