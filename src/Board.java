import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Board extends JFrame implements ActionListener {
    JPanel mainPanel = new JPanel();
    JPanel north = new JPanel();
    JPanel south = new JPanel();
    JPanel board = new JPanel();
    ButtonHandler buttonHandler = new ButtonHandler();
    Button[][] buttonArray = new Button[4][4];
    JButton newGame = buttonHandler.getNewGameButton();

    Board() {

        this.add(mainPanel);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(north, BorderLayout.NORTH);
        mainPanel.add(south, BorderLayout.SOUTH);

        north.add(board);
        board.setLayout(new GridLayout(4, 4));

        south.add(newGame);
        newGame.addActionListener(this);
        north.setBackground(Color.WHITE);
        south.setForeground(Color.PINK);

        for (Button[] row : buttonHandler.getButtons()) {
            for (Button button : row) {
                board.add(button);
            }
        }


        pack();
        setTitle("15-Puzzle");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGame) {
            board.removeAll();
            for (Button[] row : buttonHandler.getButtons()){
                for (Button button : row) {
                    board.add(button);
                }
            }
            board.revalidate();
            board.repaint();
        }
    }
}
