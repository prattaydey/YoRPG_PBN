public class Monster extends Character {
  public Monster(){
    health = 100;
    strength = 20;
    defense = 30;
    atkRating = 1;
  }

  // overwritten attack
  public int attack(Character name){
    if (Math.random() > LUCK_THRESHOLD){
      name.lowerHP((int)((strength * atkRating) - name.defense));

      // upon attacking the Protagonist, their defense and strength are reset,
      // losing any buffs or boosts.
      name.resetDefense();
      name.resetAtk();

      return (int)(strength * atkRating) - name.defense);
    }
    else{
      // miss!
      return 0;
    }
  }
}
