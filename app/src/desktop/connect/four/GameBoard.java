package desktop.connect.four;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GameBoard {

    private String player;
    private final HashMap<Character, ArrayList<JButton>> buttonsMap;
    private final int rows;
    private final int columns;
    private final JPanel panel;

    public GameBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.player = "X";
        this.buttonsMap = new HashMap<>();
        this.panel = new JPanel(new GridLayout(rows, columns));
        addButtonsToPanel();
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public void addButtonsToPanel() {
        fillButtonsMap();

        for (int i = rows; i > 0; i--) {
            for (char key : buttonsMap.keySet()) {
                JButton button = new JButton(" ");
                button.setName("Button" + key + i);
                button.setBackground(Color.gray);
                button.setFocusPainted(false);
                button.addActionListener(e -> insertInFirstColumnElement(button));
                buttonsMap.get(key).add(button);

                panel.add(button);
            }
        }
    }

    private void fillButtonsMap() {
        for (char i = 'A'; i < 'A' + this.columns; i++) {
            buttonsMap.put(i, new ArrayList<>());
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

    public void reset() {
        for (ArrayList<JButton> buttons : buttonsMap.values()) {
            for (JButton button : buttons) {
                button.setText(" ");
            }
        }

        player = "X";
    }
}
