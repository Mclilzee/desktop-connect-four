package desktop.connect.four;

import javax.swing.*;
import java.awt.*;

public class Connect4 extends JFrame {

    public Connect4(String title, int rows, int columns) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        addButtons(rows, columns);

        setLayout(new GridLayout(6, 7));

        setVisible(true);
    }

    private void addButtons(int rows, int columns) {
        for (int i = rows; i > 0; i--) {
            for (char j = 'A'; j < columns + 'A'; j++) {
                String buttonName = String.valueOf(j) + i;
                JButton button = new JButton(buttonName);
                add(button);
            }
        }
    }
}
