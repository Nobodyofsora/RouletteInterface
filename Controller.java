package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Controller {
    ArrayList<Players> players = new ArrayList<Players>();

    @FXML
    private GridPane gridId;

    Players player = new Players("Pippo", 300);
    Roulette roulette = new Roulette(players);

    public void spin(){
        roulette.spinTheWheel();
        try {
            roulette.checkWin();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void chooseBet(MouseEvent event) {
        Label source = (Label) event.getSource();
        player.setBet(Integer.parseInt(source.getText()));
        Label source2 = (Label) event.getSource();
        player.setMoneyBet(Integer.parseInt(source2.getText()));
    }
}
