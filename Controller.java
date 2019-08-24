package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;

public class Controller {
    ArrayList<Players> players = new ArrayList<Players>();
    int size = 2;
    Players currentPlayer;
    Roulette roulette;

    @FXML
    private TextField displayedbet;

    @FXML
    private TextField displayedamount;

    @FXML
    private Label displayednumber;

    @FXML
    private Button start;

    @FXML
    private Text player1;

    @FXML
    private Text player2;

    @FXML
    private TextField credit1;

    @FXML
    private TextField credit2;

    @FXML
    private GridPane gridId;

    @FXML
    private void initialize() {
        this.gridId.visibleProperty().setValue(false);
    }

    public String login() {
        TextInputDialog dialog = new TextInputDialog("name");
        dialog.setTitle("Login Player");
        dialog.setHeaderText(" Login information");
        dialog.setContentText("Please enter your name:");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            return result.get();
        }
        return null;
    }

    public void end(Players player) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Roulette END GAME!");
        alert.setHeaderText(null);
        alert.setContentText("OH SORRY..." + player.getName() + "LOST!");

        alert.showAndWait();
    }

    @FXML
    private void startingGame() {
        for (int i=0; i<this.size; i++) {
            String name = login();
            int credit = 100;
            Players p = new Players(name, credit);
            this.players.add(p);
            if (i == 0) {
                player1.setText(name);
                credit1.setText(Integer.toString(credit));
            }
            else {
                player2.setText(name);
                credit2.setText(Integer.toString(credit));
            }
        }
        currentPlayer = players.get(0);
        this.roulette = new Roulette(players);
        this.gridId.visibleProperty().setValue(true);
        return;
    }

    private void switchPlayer() {
        if (currentPlayer.equals(players.get(0))) {
            currentPlayer = players.get(1);
            player2.setStyle("-fx-fill: #ff0000");
            player1.setStyle("-fx-fill: #000000");
        }
        else {
            currentPlayer=players.get(0);
            player1.setStyle("-fx-fill: #ff0000");
            player2.setStyle("-fx-fill: #000000");
        }
    }

    public void chooseBet(MouseEvent event) {
        Label source = (Label) event.getSource();
        currentPlayer.setBet(Integer.parseInt(source.getText()));
        displayedbet.setText(String.valueOf(currentPlayer.getBet()));
    }

    public void chooseMoney(MouseEvent event) {
        Label source2 = (Label) event.getSource();
        currentPlayer.setMoneyBet(Integer.parseInt(source2.getText()));
        displayedamount.setText(String.valueOf(currentPlayer.getMoneyBet()));
    }

    public void chooseOdd(MouseEvent event) {
        Label source3 = new Label("ODD");
        String s = source3.getText();
        if (s.equals("ODD"))
            currentPlayer.setBet(37);
        displayedbet.setText("ODD");
    }

    public void chooseEven(MouseEvent event) {
        Label source3 = new Label("EVEN");
        String s = source3.getText();
        if (s.equals("EVEN"))
            currentPlayer.setBet(38);
        displayedbet.setText("EVEN");
    }

    public void chooseRed(MouseEvent event) {
        Label source3 = new Label("RED");
        String s = source3.getText();
        if (s.equals("RED"))
            currentPlayer.setBet(39);
        displayedbet.setText("RED");
    }

    public void chooseBlack(MouseEvent event) {
        Label source3 = new Label("BLACK");
        String s = source3.getText();
        if (s.equals("BLACK"))
            currentPlayer.setBet(40);
        displayedbet.setText("BLACK");
    }

    @FXML
    private void spin(ActionEvent event){
        this.roulette.spinTheWheel();
        displayednumber.setText(String.valueOf(this.roulette.ballIsOn));
        try {
            this.roulette.checkWin();
            credit1.setText(Integer.toString(this.roulette.players.get(0).credit));
            credit2.setText(Integer.toString(this.roulette.players.get(1).credit));
            if (!this.roulette.losingPlayers.isEmpty()){
                end(this.roulette.losingPlayers.get(0));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        this.switchPlayer();
    }
}