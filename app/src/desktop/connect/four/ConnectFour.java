package desktop.connect.four;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ConnectFour extends JFrame {

    public ConnectFour(String title, int rows, int columns) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        setLayout(new GridLayout(6, 7));

        setVisible(true);
    }
}
