package GUI;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {


    public GameFrame(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(600,600);
        this.setLocationRelativeTo(null);

        this.add(new TitlePanel(), BorderLayout.NORTH);
        this.add(new BoardPanel(), BorderLayout.CENTER);

        this.setVisible(true);
    }

}
