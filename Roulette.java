package sample;


import java.util.ArrayList;
import java.util.Random;

public class Roulette {
    private int ballIsOn;
    //private double dealerCredit;
    private ArrayList<Players> players;

    Roulette(ArrayList<Players> players) {
        //this.dealerCredit=0;
        this.players=players;
    }

    ArrayList<Players> checkWin() throws Exception{
        ArrayList<Players> winningPlayers = new ArrayList<Players>();
        for (Players player : this.players) {
            int numberPlayed = player.getBet();
            int number = this.ballIsOn;
            if (numberPlayed>= 0 && numberPlayed <= 36) number = 0;
            if (numberPlayed == 37) number = 37;
            if (numberPlayed == 38) number = 38;
            switch (number) {
                case 0:
                    if (numberPlayed == this.ballIsOn) {
                        player.win = numberPlayed;
                        youWin(player, number);
                    } else youLose(player);
                    break;
                case 37: //odd
                    if (this.ballIsOn % 2 != 0) {
                        player.win = numberPlayed;
                        youWin(player, number);
                    } else youLose(player);
                    break;
                case 38: //even
                    if (this.ballIsOn % 2 == 0) {
                        player.win = numberPlayed;
                        youWin(player, number);
                    } else youLose(player);
                    break;
                case 39: //red
                    if (this.ballIsOn<=9)
                        if (this.ballIsOn % 2 != 0) {
                            player.win = numberPlayed;
                            youWin(player, number);
                        } else youLose(player);
                    else if (this.ballIsOn>10 && this.ballIsOn<=18)
                        if (this.ballIsOn % 2 == 0) {
                            player.win = numberPlayed;
                            youWin(player, number);
                        }else youLose(player);
                    else if (this.ballIsOn<=27)
                        if (this.ballIsOn % 2 != 0) {
                            player.win = numberPlayed;
                            youWin(player, number);
                        }else youLose(player);
                    else if (this.ballIsOn>28)
                        if (this.ballIsOn % 2 == 0) {
                            player.win = numberPlayed;
                            youWin(player, number);
                        }else youLose(player);
                    break;
                case 40: //black
                    if (this.ballIsOn<=10)
                        if (this.ballIsOn % 2 == 0) {
                            player.win = numberPlayed;
                            youWin(player, number);
                        } else youLose(player);
                    else if (this.ballIsOn>10 && this.ballIsOn<=17)
                        if (this.ballIsOn % 2 != 0) {
                            player.win = numberPlayed;
                            youWin(player, number);
                        }else youLose(player);
                    else if (this.ballIsOn<=28)
                        if (this.ballIsOn % 2 == 0) {
                            player.win = numberPlayed;
                            youWin(player, number);
                        }else youLose(player);
                    else if (this.ballIsOn>28)
                        if (this.ballIsOn % 2 != 0) {
                            player.win = numberPlayed;
                            youWin(player, number);
                        }else youLose(player);
                    break;
                default:
                    break;
            }
            if (player.win == numberPlayed) winningPlayers.add(player);
        }
        return winningPlayers;
    }

    void spinTheWheel (){
        Random random=new Random();
        this.ballIsOn=random.nextInt(36);
    }

    private void youWin(Players player, int switchCase){
        switch(switchCase){
            case 0:
                player.credit += player.getMoneyBet()*36;
                break;
            case 37:
            case 38:
            case 39:
            case 40:
                player.credit+= player.getMoneyBet()*2;
                break;
            default:
                break;
        }

    }
    private void youLose(Players player) {
        player.credit-= player.getMoneyBet();
        this.dealerCredit+=player.getMoneyBet();
    }
}
