import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ButtonHandler implements ActionListener {
    private List<Button> buttons = new ArrayList<>();
    private final Button[][] board = new Button[4][4];
    private final JButton newGame = new JButton("New Game");
    public JButton getNewGameButton() {
        newGame.setFont(new Font("Arial", Font.PLAIN, 20));
        return newGame;
    }

    private void addButtons() {
        int index = 1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(index == 16){
                    board[i][j] = new Button(0);
                    board[i][j].addActionListener(this);
                } else {
                    board[i][j] = new Button(index);
                    board[i][j].addActionListener(this);
                    index++;
                }
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
        return board;
    }

//    public Button[][] getNewGame() {
//        return getButtons();
//    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
