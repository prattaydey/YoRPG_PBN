public class Character{
  protected final double LUCK_THRESHOLD = 0.3; // sets the game-wide threshold for all luck-based moves.

  protected int health;
  protected int strength;
  protected int defense;
  protected double atkRating;
  protected int damage;

  public Character(){
    health = 100; // everyone starts with 100 health by default

    // these variables are expected to be overwritten.
    strength = 20;
    defense = 10;
    atkRating = 1;
  }

  public boolean isAlive(){
    return health > 0;
  }

  public int getDefense(){
    return defense;
  }

  public void lowerHP(int dmg){
    health -= dmg;
    if (health < 0){
      health = 0;
    }
  }

  public int attack(Character name){
    if (Math.random() > LUCK_THRESHOLD && this.isAlive()){ // hit!
      damage = (int)((strength * atkRating) - name.getDefense());
      if (damage < 0){ // accounts for negative damage
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

  // additional method to improve UX when playing
  public int getHP(){
    return health;
  }
}
