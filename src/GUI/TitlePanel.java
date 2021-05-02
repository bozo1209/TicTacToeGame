package GUI;

import Game.GameBoard;
import Main.TicTacToeMain;

import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel {

    private static final String gameName = "Tic-Tac-Toe";
    private static final JLabel title = new JLabel(gameName);
    private final JButton newGameButton = new JButton("New Game");

    TitlePanel(){
        title.setFont(new Font(null, Font.BOLD, 35));
        this.setLayout(new BorderLayout());
        this.add(title, BorderLayout.CENTER);
        this.setNewGameButton();
    }


    public static void setGameName(String newName){
        title.setText(newName);
    }

    private void setNewGameButton(){
        newGameButton.setFocusable(false);
        newGameButton.addActionListener(e -> newGameButtonAction());
        this.add(newGameButton, BorderLayout.EAST);
    }

    private static void newGameButtonAction(){
        GameBoard.getInstance().setGameBoardInstanceToNull();
        TicTacToeMain.gameFrame.dispose();
        TicTacToeMain.gameFrame = new GameFrame();
        setGameName(gameName);
    }
}
