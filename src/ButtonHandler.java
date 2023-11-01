import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ButtonHandler implements ActionListener {
    private final Button[][] board = new Button[4][4];
    private final JButton newGame = new JButton("New Game");

    public JButton getNewGameButton() {
        newGame.setFont(new Font("Arial", Font.PLAIN, 20));
        newGame.setFocusable(false);
        return newGame;
    }

    private void addButtons() {
        int index = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = new Button(index);
                board[i][j].addActionListener(this);
                index++;
            }
        }
    }

    private void shuffleArray() {
        List<Integer> tempList = new ArrayList<>();
        for (int i = 1; i < 16; i++) {
            tempList.add(i);
        }
        Collections.shuffle(tempList);
        tempList.add(0);

        int index = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j].setNumber(tempList.get(index));
                board[i][j].setArrayPosition(new int[]{i, j});
                board[i][j].setVisible(true);
                index++;
            }
        }
    }

    public ButtonHandler() {
        addButtons();
    }

    public Button[][] getButtons() {
        do {
            shuffleArray();
        } while (!BoardUtils.isSolvable(board, 4));
        board[3][3].setVisible(false);
        return board;
    }

    public void moveButton(int[] position) {
        int[] blank = new int[2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j].getNumber() == 0){
                    blank = board[i][j].getArrayPosition();
                }
            }
        }
        boolean sameRow = position[0] == blank[0];
        boolean sameColumn = position[1] == blank[1];
        boolean nextToRow = position[0] - blank[0] == 1 || position[0] - blank[0] == -1;
        boolean nextToColumn = position[1] - blank[1] == 1 || position[1] - blank[1] == -1;

        if((sameRow && nextToColumn) || (sameColumn && nextToRow)) {
            swapButtons(position, blank);
        }
    }
    public void swapButtons (int[] position, int[] blank) {
        Button blankButton = board[blank[0]][blank[1]];
        Button clickedButton = board[position[0]][position[1]];
        blankButton.setNumber(clickedButton.getNumber());
        blankButton.setVisible(true);
        clickedButton.setNumber(0);
        clickedButton.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int[] clickedButtonPosition = ((Button)e.getSource()).getArrayPosition();
        moveButton(clickedButtonPosition);
        if(BoardUtils.winCheck(board, board.length)) {
            JOptionPane.showMessageDialog(null, "Grattis, du vann!");
        }
    }
}
