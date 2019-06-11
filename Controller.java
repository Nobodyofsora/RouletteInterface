package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Controller {
    ArrayList<Players> players = new ArrayList<Players>();

    @FXML
    private GridPane gridId;

    Players player = new Players("Pippo", 300);
    Roulette roulette = new Roulette(players);

    public void chooseBet(MouseEvent event) {
        Label source = (Label) event.getSource();
        player.setBet(Integer.parseInt(source.getText()));
        System.out.println(player.getBet());
    }

    public void chooseMoney(MouseEvent event) {
        Label source2 = (Label) event.getSource();
        player.setMoneyBet(Integer.parseInt(source2.getText()));
        System.out.println(player.getMoneyBet());
    }

    public void chooseOdd(MouseEvent event) {
        Label source3 = new Label("ODD");
        String s = source3.getText();
        if (s.equals("ODD"))
            player.setBet(37);
        System.out.println(player.getBet());
    }

    public void chooseEven(MouseEvent event) {
        Label source3 = new Label("EVEN");
        String s = source3.getText();
        if (s.equals("EVEN"))
            player.setBet(38);
        System.out.println(player.getBet());
    }

    public void chooseRed(MouseEvent event) {
        Label source3 = new Label("RED");
        String s = source3.getText();
        if (s.equals("RED"))
            player.setBet(39);
        System.out.println(player.getBet());
    }

    public void chooseBlack(MouseEvent event) {
        Label source3 = new Label("BLACK");
        String s = source3.getText();
        if (s.equals("BLACK"))
            player.setBet(40);
        System.out.println(player.getBet());
    }

    @FXML
    private void spin(javafx.event.ActionEvent event){
        roulette.spinTheWheel();
        //System.out.println("Funzione di spinTheWhell effettuato");
        try {
            ArrayList<Players> players;
            players = roulette.checkWin();
            //System.out.println("Funzione checkWin effettuata");
            for (Players player : players)
                //System.out.println("Sono dentro al ciclo for");
                System.out.println(player.getName() + " ha vinto!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
