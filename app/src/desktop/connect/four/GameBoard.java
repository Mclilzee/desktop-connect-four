package desktop.connect.four;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GameBoard {

    private String player;
    private final JButton[][] buttonsBoard;
    private final int rows;
    private final int columns;
    private final JPanel panel;
    private boolean gameOver;
    public GameBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.player = "X";
        this.buttonsBoard = new JButton[rows][columns];
        this.panel = new JPanel(new GridLayout(rows, columns));
        gameOver = false;
        addButtonsToPanel();
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public void addButtonsToPanel() {
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < columns; j++) {
                JButton button = new JButton(" ");
                button.setName("Button" + ((char) (j + 65)) + (i + 1));
                button.setBackground(Color.gray);
                button.setFocusPainted(false);
                button.addActionListener(e -> insertInFirstColumnElement(button));
                buttonsBoard[i][j] = button;

                panel.add(button);
            }
        }
    }

    private void insertInFirstColumnElement(JButton button) {
        if (gameOver) {
            return;
        }

        int buttonColumnIndex = button.getName().charAt(6) - 65;

        for (int i = 0; i < rows; i++) {
            JButton eachButton = buttonsBoard[i][buttonColumnIndex];
            if (eachButton.getText().isBlank()) {
                eachButton.setText(player);
                player = player.equals("X") ? "O" : "X";
                break;
            }
        }

//        checkIfGameOver();
    }

//    private void checkIfGameOver() {
//        if (rowsConditionMet() || columnsConditionMet() || diagonalLeftConditionMet() || diagonalRightConditionMet()) {
//            gameOver = true;
//        };
//    }
//
//    private boolean rowsConditionMet() {
//
//    }

    public void reset() {
        for (JButton[] buttons : buttonsBoard) {
            for (JButton button : buttons) {
                button.setText(" ");
            }
        }

        player = "X";
    }
}
