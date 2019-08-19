package sample;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.util.converter.NumberStringConverter;

import javax.swing.*;
import java.util.ArrayList;

public class Controller {
    @FXML
    private TextField displayedbet;

    @FXML
    private TextField displayedamount;

    @FXML
    private GridPane gridId;

        ArrayList<Players> players = new ArrayList<Players>();
        Players player = new Players("Pippo", 300);

        public Roulette startingGame (){
            players.add(player);
            Roulette r = new Roulette(players);
            return r;
        }
    public void chooseBet(MouseEvent event) {
        Label source = (Label) event.getSource();
        player.setBet(Integer.parseInt(source.getText()));
        displayedbet.setText(String.valueOf(player.getBet()));
    }

    public void chooseMoney(MouseEvent event) {
        Label source2 = (Label) event.getSource();
        player.setMoneyBet(Integer.parseInt(source2.getText()));
        displayedamount.setText(String.valueOf(player.getMoneyBet()));
    }

    public void chooseOdd(MouseEvent event) {
        Label source3 = new Label("ODD");
        String s = source3.getText();
        if (s.equals("ODD"))
            player.setBet(37);
        displayedbet.setText("ODD");
    }

    public void chooseEven(MouseEvent event) {
        Label source3 = new Label("EVEN");
        String s = source3.getText();
        if (s.equals("EVEN"))
            player.setBet(38);
        displayedbet.setText("EVEN");
    }

    public void chooseRed(MouseEvent event) {
        Label source3 = new Label("RED");
        String s = source3.getText();
        if (s.equals("RED"))
            player.setBet(39);
        displayedbet.setText("RED");
    }

    public void chooseBlack(MouseEvent event) {
        Label source3 = new Label("BLACK");
        String s = source3.getText();
        if (s.equals("BLACK"))
            player.setBet(40);
        displayedbet.setText("BLACK");
    }

    @FXML
    private void spin(ActionEvent event){
        Roulette roulette = this.startingGame();
        roulette.spinTheWheel();
        try {
            ArrayList<Players> players = roulette.checkWin();
            System.out.println(players.get(0).getName() + " ha vinto!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
