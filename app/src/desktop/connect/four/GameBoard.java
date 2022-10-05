package desktop.connect.four;

import javax.swing.*;
import java.awt.*;

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
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                JButton button = new JButton(" ");
                button.setName("Button" + ((char) (j + 65)) + (rows - i));
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

        for (int i = rows - 1; i >= 0; i--) {
            JButton eachButton = buttonsBoard[i][buttonColumnIndex];
            if (eachButton.getText().isBlank()) {
                eachButton.setText(player);
                player = player.equals("X") ? "O" : "X";
                checkIfGameOver(i, buttonColumnIndex);
                break;
            }
        }
    }

    private void checkIfGameOver(int row, int column) {
        if (rowsConditionMet(row, column) || columnsConditionMet(row, column) || leftDiagonalConditionMet(row, column) || rightDiagonalConditionMet(row, column)) {
            gameOver = true;
        }
    }

    private boolean rowsConditionMet(int row, int column) {

        for (int i = row - 3; i < this.rows - 3; i++) {
            if (i < 0) {
                continue;
            }

            JButton first = buttonsBoard[i][column];
            JButton second = buttonsBoard[i + 1][column];
            JButton third = buttonsBoard[i + 2][column];
            JButton fourth = buttonsBoard[i + 3][column];

            if (buttonsAreEqual(first, second, third, fourth)) {

                return true;
            }
        }

        return false;
    }

    private boolean columnsConditionMet(int row, int column) {
        for (int i = column - 3; i < this.columns - 3; i++) {
            if (i < 0) {
                continue;
            }

            JButton first = buttonsBoard[row][i];
            JButton second = buttonsBoard[row][i + 1];
            JButton third = buttonsBoard[row][i + 2];
            JButton fourth = buttonsBoard[row][i + 3];

            if (buttonsAreEqual(first, second, third, fourth)) {
                return true;
            }
        }

        return false;
    }

    private boolean leftDiagonalConditionMet(int row, int column) {
        for (int i = - 3; row + i + 3 < this.rows && column + i + 3 < this.columns; i++) {
            if (row + i < 0 || column + i < 0) {
                continue;
            }

            JButton first = buttonsBoard[row + i][column + i];
            JButton second = buttonsBoard[row + i + 1][column + i + 1];
            JButton third = buttonsBoard[row + i + 2][column + i + 2];
            JButton fourth = buttonsBoard[row + i + 3][column + i + 3];

            if (buttonsAreEqual(first, second, third, fourth)) {
                return true;
            }
        }

        return false;
    }

    private boolean rightDiagonalConditionMet(int row, int column) {
        for (int i = - 3; row + i + 3 < this.rows && column - i - 3 < this.columns; i++) {
            if (row + i < 0 || column - i >= this.columns) {
                continue;
            }

            JButton first = buttonsBoard[row + i][column - i];
            JButton second = buttonsBoard[row + i + 1][column - i - 1];
            JButton third = buttonsBoard[row + i + 2][column - i - 2];
            JButton fourth = buttonsBoard[row + i + 3][column - i - 3];

            if (buttonsAreEqual(first, second, third, fourth)) {
                return true;
            }
        }

        return false;
    }

    private boolean buttonsAreEqual(JButton first, JButton second, JButton third, JButton fourth) {
        if (!first.getText().isBlank() && first.getText().equals(second.getText()) && first.getText().equals(third.getText()) && first.getText().equals(fourth.getText())) {
            first.setBackground(Color.GREEN);
            second.setBackground(Color.GREEN);
            third.setBackground(Color.GREEN);
            fourth.setBackground(Color.GREEN);
            return true;
        } else {
            return false;
        }
    }

    public void reset() {
        for (JButton[] buttons : buttonsBoard) {
            for (JButton button : buttons) {
                button.setText(" ");
                button.setBackground(Color.gray);
            }
        }

        gameOver = false;
        player = "X";
    }
}
