package GUI;

import Game.GameBoard;
import Game.GameStatus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BoardPanel extends JPanel {

    private final JButton[] buttons = new JButton[9];
    private JButton button00, button01, button02;
    private JButton button10, button11, button12;
    private JButton button20, button21, button22;
    private boolean isPlayer1 = true;


    BoardPanel(){
        this.setBackground(Color.BLUE);
        this.setLayout(new GridLayout(3,3,10,10));
        this.boardButtons();
    }


    private void boardButtons(){
        button00 = new JButton();
        button01 = new JButton();
        button02 = new JButton();
        button10 = new JButton();
        button11 = new JButton();
        button12 = new JButton();
        button20 = new JButton();
        button21 = new JButton();
        button22 = new JButton();

        buttons[0] = button00;
        buttons[1] = button01;
        buttons[2] = button02;
        buttons[3] = button10;
        buttons[4] = button11;
        buttons[5] = button12;
        buttons[6] = button20;
        buttons[7] = button21;
        buttons[8] = button22;

        for (JButton button : buttons) {
            button.addActionListener(this::buttonAction);
            button.setFocusable(false);
            this.add(button);
        }
    }

    private void buttonAction(ActionEvent event){
        if (event.getSource() == button00){
            this.editButton(button00,0,0, isPlayer1);
        }else if (event.getSource() == button01){
            this.editButton(button01,0,1, isPlayer1);
        }else if (event.getSource() == button02){
            this.editButton(button02,0,2, isPlayer1);
        }else if (event.getSource() == button10){
            this.editButton(button10,1,0, isPlayer1);
        }else if (event.getSource() == button11){
            this.editButton(button11,1,1, isPlayer1);
        }else if (event.getSource() == button12){
            this.editButton(button12,1,2, isPlayer1);
        }else if (event.getSource() == button20){
            this.editButton(button20,2,0, isPlayer1);
        }else if (event.getSource() == button21){
            this.editButton(button21,2,1, isPlayer1);
        }else if (event.getSource() == button22){
            this.editButton(button22,2,2, isPlayer1);
        }

    }

    private void editButton(JButton button, int row, int column, boolean isPlayer1){
        if (isPlayer1){
            button.setEnabled(false);
            button.setText("x");
            GameBoard.getInstance().setGameBoard(row, column, "x");
            this.isPlayer1 = false;
        }else {
            button.setEnabled(false);
            button.setText("o");
            GameBoard.getInstance().setGameBoard(row, column, "o");
            this.isPlayer1 = true;
        }

        String finalMessage;

        if(GameBoard.getInstance().resultsOfGame().equals(GameStatus.PLAYER1WIN)){
            finalMessage = "winner is player1";
            this.endGameButtonAction(finalMessage);
        }else if(GameBoard.getInstance().resultsOfGame().equals(GameStatus.PLAYER2WIN)){
            finalMessage = "winner is player2";
            this.endGameButtonAction(finalMessage);
        }else if(GameBoard.getInstance().resultsOfGame().equals(GameStatus.TIE)){
            finalMessage = "tie";
            this.endGameButtonAction(finalMessage);
        }

    }

    private void endGameButtonAction(String finalMessage){
        TitlePanel.setGameName(finalMessage);
        this.setButtonsEnabledFalse();
        GameBoard.getInstance().setGameBoardInstanceToNull();
    }

    private void setButtonsEnabledFalse(){
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
    }

}
