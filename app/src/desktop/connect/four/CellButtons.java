package desktop.connect.four;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CellButtons {

    private String player;
    private final HashMap<Character, ArrayList<JButton>> buttonsMap;
    int rows;
    int columns;

    public CellButtons(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.player = "X";
        this.buttonsMap = new HashMap<>();
        fillButtonsMap();
    }

    private void fillButtonsMap() {
        for (char i = 'A'; i < 'A' + this.columns; i++) {
            buttonsMap.put(i, new ArrayList<>());
        }
    }

    public void addButtonsToFrame(JFrame frame) {
        for (int i = rows; i > 0; i--) {
            for (char key : buttonsMap.keySet()) {
                JButton button = new JButton(" ");
                button.setName("Button" + key + i);
                button.setFocusPainted(false);
                button.addActionListener(e -> insertInFirstColumnElement(button));
                buttonsMap.get(key).add(button);

                frame.add(button);
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
