package desktop.connect.four;

import javax.swing.*;
import java.awt.*;

public class ConnectFour extends JFrame {

    public ConnectFour(String title, int rows, int columns) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        JPanel gameBoardPanel = new JPanel(new GridLayout(rows, columns));
        GameBoard gameBoard = new GameBoard(rows, columns);
        gameBoard.addButtonsToPanel(gameBoardPanel);

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> gameBoard.reset());
        JPanel windowPanel = new JPanel(new BorderLayout());

        windowPanel.add(gameBoardPanel, BorderLayout.CENTER);
        windowPanel.add(resetButton, BorderLayout.SOUTH);

        add(windowPanel);

        setVisible(true);
    }
}
