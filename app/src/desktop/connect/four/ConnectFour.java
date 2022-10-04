package desktop.connect.four;

import javax.swing.*;
import java.awt.*;

public class ConnectFour extends JFrame {

    private String player;

    public ConnectFour(String title, int rows, int columns) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        addButtons(rows, columns);
        setLayout(new GridLayout(6, 7));

        setVisible(true);
        this.player = "X";
    }

    private void addButtons(int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                JButton button = new JButton(" ");

                button.addActionListener(e -> {
                    button.setText(player);
                    player = player.equals("X") ? "O" : "X";
                });
                button.setFocusPainted(false);
                add(button);
            }
        }
    }
}
