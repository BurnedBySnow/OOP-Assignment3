import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JFrame implements ActionListener {
    JPanel mainPanel = new JPanel();
    JPanel north = new JPanel();
    JPanel south = new JPanel();
    JPanel board = new JPanel();
    ButtonHandler buttonHandler = new ButtonHandler();
    JButton newGame = buttonHandler.getNewGameButton();

    Board() {
        this.addComponentListener(new MyComponentListener(board));
        this.add(mainPanel);
        BoxLayout boxLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
        mainPanel.setLayout(boxLayout);
        mainPanel.add(board);
        mainPanel.add(south);
        setMinimumSize(new Dimension(400, 400));
        south.setMaximumSize(new Dimension(400, 200));

        board.setLayout(new GridLayout(4, 4));
        board.setBackground(Color.lightGray);
        south.add(newGame);

        newGame.addActionListener(this);
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
