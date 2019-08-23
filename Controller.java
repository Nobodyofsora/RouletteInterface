package sample;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.util.converter.NumberStringConverter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Hashtable;

public class Controller {
    ArrayList<Players> players = new ArrayList<Players>();
    int size=1;
    Players currentPlayer;

    @FXML
    private TextField displayedbet;

    @FXML
    private TextField displayedamount;

    @FXML
    private TextArea displayednumber;

    @FXML
    private GridPane gridId;

    public Hashtable<String, String> login(JFrame frame) {
        Hashtable<String, String> logininformation = new Hashtable<String, String>();
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
        label.add(new JLabel("Name", SwingConstants.RIGHT));
        label.add(new JLabel("Credit", SwingConstants.RIGHT));
        panel.add(label, BorderLayout.WEST);

        JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
        JTextField name = new JTextField();
        controls.add(name);
        JTextField credit = new JTextField();
        controls.add(credit);
        panel.add(controls, BorderLayout.CENTER);

        JOptionPane.showMessageDialog(frame, panel, "login", JOptionPane.QUESTION_MESSAGE);

        logininformation.put("user", name.getText());
        logininformation.put("cred", credit.getText());
        return logininformation;
    }
    private Roulette startingGame (){
        for (int i=0; i<this.size; i++) {
            JFrame frame = new JFrame();
            String name = login(frame).get("user");
            int credit = Integer.parseInt(login(frame).get("cred"));
            Players p = new Players(name, credit);
            this.players.add(p);
        }
        currentPlayer=currentPlayer=players.get(0);
        Roulette r = new Roulette(players);
        return r;
    }
    private void switchPlayer(){
        if (currentPlayer.equals(players.get(0)))
            currentPlayer=players.get(1);
        else currentPlayer=players.get(0);
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
        Roulette roulette= this.startingGame();
        roulette.spinTheWheel();
        displayednumber.setText(String.valueOf(roulette.ballIsOn));
        try {
            ArrayList<Players> players = roulette.checkWin();
            System.out.println(players.get(0).getName() + " ha vinto!");
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
