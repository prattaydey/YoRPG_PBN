public class Character{
  public final double INIT_ATKRATING = 1;
  public final int INIT_DEFENSE = 30;
  public final double LUCK_THRESHOLD = 0.5;

  private int health = 100;
  private int strength = 50;
  private int defense = INIT_DEFENSE;
  private double atkRating = INIT_ATKRATING;
  private int damage;

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
  public int getDamage(){
    return damage;
  }

  public int getStrength(){
    return strength;
  }

  public double getAtkRating(){
    return atkRating;
  }

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
