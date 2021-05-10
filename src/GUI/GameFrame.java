package GUI;

import javax.swing.*;
import java.awt.*;

import static Main.TicTacToeMain.gameFrame;

public class GameFrame extends JFrame {

    private static BoardPanel boardPanel = new BoardPanel();

    public GameFrame(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(600,600);
        this.setLocationRelativeTo(null);

        this.add(new TitlePanel(), BorderLayout.NORTH);
        this.add(boardPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public static void newGameFrame(){
        gameFrame.remove(boardPanel);
        boardPanel = new BoardPanel();
        gameFrame.add(boardPanel);
        SwingUtilities.updateComponentTreeUI(gameFrame);
    }

}
