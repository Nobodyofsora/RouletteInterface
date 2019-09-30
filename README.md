# 🎰 Roulette 🎲
 Roulette Game with an interface. Things you can do:
 - Bet your desired amount of money.
 - Select a number to bet on or select Red/Black/Odd/Even
 - 100% Guaranteed win :D
 # Fundamental functions #
## Spin The Wheel ##
Gets a random number with the Random Class and it goes to this.ballIsOn

## Check Win ##
Takes a player and checks if its bet is successful or not.
To do so, the function takes the player's bet and changes it into a number that highlights whether the bet is a number or a collection of numbers
```  public void checkWin(Players player){
            int numberPlayed = player.getBet();
            int number = this.ballIsOn;
            if (numberPlayed>= 0 && numberPlayed <= 36) number = 0;
            if (numberPlayed == 37) number = 37;
            if (numberPlayed == 38) number = 38;
            ...
```
# Javafx functions #
## Login ##
..
