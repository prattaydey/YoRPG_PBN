public class Character{
  protected final double LUCK_THRESHOLD = 0.3;

  protected int health;
  protected int strength;
  protected int defense;
  protected double atkRating;
  protected int damage;

  public Character(){
    health = 100; // everyone starts with 100 health.
  }

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
    if (Math.random() > LUCK_THRESHOLD){ // hit!
      damage = (int)((strength * atkRating) - name.defense);
      if (damage < 0){
        damage = 0;
      }
      name.lowerHP(damage);
    }
    else {
      // miss!
      damage = 0;
    }
    return damage;
  }
}
