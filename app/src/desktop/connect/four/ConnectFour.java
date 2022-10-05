package desktop.connect.four;

import javax.swing.*;
import java.awt.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;

public class ConnectFour extends JFrame {

    private String player;
    private HashMap<Character, ArrayList<JButton>> buttonsMap;

    public ConnectFour(String title, int rows, int columns) {
        super(title);
        buttonsMap = new HashMap<>();
        fillHashMap(columns);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        addButtons(rows, columns);
        setLayout(new GridLayout(6, 7));

        setVisible(true);
        this.player = "X";
    }

    private void fillHashMap(int columns) {
        for (char i = 'A'; i < 'A' + columns; i++) {
            buttonsMap.put(i, new ArrayList<>());
        }
    }

    private void addButtons(int rows, int columns) {
        for (int i = rows; i > 0; i--) {
            for (char j = 'A'; j < 'A' + columns; j++) {
                JButton button = new JButton(" ");
                button.setName("Button" + j + i);
                button.addActionListener(e -> insertInFirstColumnElement(button));
                button.setFocusPainted(false);
                buttonsMap.get(j).add(button);

                add(button);
            }
        }
    }

    private void insertInFirstColumnElement(JButton button) {
        char buttonColumn = button.getName().charAt(6);
        var buttonsArray = buttonsMap.get(buttonColumn);
        for (int i = buttonsArray.size() - 1; i >= 0; i--) {
            JButton eachButton = buttonsArray.get(i);
            if (eachButton.getText().isBlank()) {
                eachButton.setText(player);
                player = player.equals("X") ? "O" : "X";
                break;
            }
        }
    }
}
