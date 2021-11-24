# YoRPG_PBN
## Team Peanut Butter and Nutella
## Roster: Prattay Dey + Winnie, Brian Li + Robert, Nafiz Labib + Martha

### Protagonist Subclasses:

#### Fighter:
- Attack Rating: 1.25
- Defense: 10
- Specialize: Increased damage but halved defense next turn.

#### Tank:
- Attack Rating: 0.8
- Defense: 12
- Specialize: Has a chance to double defense for a turn. Your attack for that turn is greatly weakened.

#### Healer:
- Attack Rating: 1
- Defense: 10
- Specialize: Heal yourself for 10 HP. You will not attack this turn.


### Monster Subclasses:

#### Peasant:
- Attack Rating: 1
- Defense: 15
#### Soldier:
- Attack Rating: 1
- Defense: 10
#### Vanguard:
- Attack Rating: 0.75
- Defense: 20

### Changelog:

#### v0 -> v1:
- actually got specialize() working
- generalized parameters and arguments
- created accessor methods, modifier methods
- added "extends" to Monster and Protagonist class

#### v1 -> v2:
- fixed method and variable names to make them in line with expectations
- created additional subclasses of Monster and Character
- added additional print statements to the Driver, prompted for user input in protagonist kit, added descriptions of classes
- changed visibility of instance variables to "protected", allowing for the removal of accessor and modifier methods.
- utilized super() in constructors
- generally neater

### Future Improvements:
- Expansion of kits
- Make it more aesthetically pleasing when running in command line input.
- Allow for greater (or less) randomness within the game.
- Balance fixes and optimization.
