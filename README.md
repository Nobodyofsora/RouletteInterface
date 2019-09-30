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
This simple dialog window that waits until you put your name in it.
## Starting game ##
This function is linked (with a @FXML annotation)to the first thing you see when you open the game, the start button.
I'ts programmed so that the login function is called as many times as the programmers says, so that there are as many players as he wants.
```  
private void startingGame() {
        for (int i=0; i<this.size; i++) {
            String name = login();
            int credit = 100;
            Players p = new Players(name, credit);
            this.players.add(i, p);
            ...
```  
## Switch Player ##
Thanks to this function we can go through the array of the players and set the CurrentPlayer variable to the right player.
## Spin ##
Once we got the right player and the bet is decided all they need to do is push the SPIN button. Its linked function calls the spinTheWheel() function, displays what it returns and calls checkWin(). Whether the player wins or not, the corrisponding amount of money is displayed below their name.
``` 
@FXML
    private void spin(ActionEvent event){
        this.roulette.spinTheWheel();
        displayednumber.setText(String.valueOf(this.roulette.getBallIsOn()));
        try {
            this.roulette.checkWin(currentPlayer);
            if (currentPlayer.getName().equals(this.roulette.players.get(0).getName()))
                credit1.setText(Integer.toString(this.roulette.players.get(0).credit));
            else credit2.setText(Integer.toString(this.roulette.players.get(1).credit));
        } catch (Exception e) {
            System.out.println(e);
        }
``` 
## End. ##
It gets called whenever Spin ends, it checks if the CurrentPlayer has 0 (or below) money, if so an alert appears ending the game, otherwise it says that the player's turn ended and another player begins to play.
