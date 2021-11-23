public class Monster extends Character {
  // overwritten attack
  public int attack(Character name){
    if (Math.random() > LUCK_THRESHOLD){
      name.lowerHP((int)((getStrength() * getAtkRating()) - name.getDefense()));

      // upon attacking the Protagonist, their defense and strength are reset,
      // losing any buffs or boosts.
      name.resetDefense();
      name.resetAtk();

      return (int)((getStrength() * getAtkRating()) - name.getDefense());
    }
    else{
      // miss!
      return 0;
    }
  }
}
