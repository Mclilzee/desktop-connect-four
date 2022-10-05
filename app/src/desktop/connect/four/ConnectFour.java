package desktop.connect.four;

import javax.swing.*;
import java.awt.*;

public class ConnectFour extends JFrame {

    public ConnectFour(String title, int rows, int columns) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        GameBoard gameBoard = new GameBoard(rows, columns);

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> gameBoard.reset());
        JPanel windowPanel = new JPanel(new BorderLayout());

        windowPanel.add(gameBoard.getPanel(), BorderLayout.CENTER);
        windowPanel.add(resetButton, BorderLayout.SOUTH);

        add(windowPanel);

        setVisible(true);
    }
}
