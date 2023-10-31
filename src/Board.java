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
    ButtonHandler button = new ButtonHandler();
    java.util.List<Button> buttonsList = button.getButtonsList();
    JButton newGame = button.getNewGameButton();

    Board() {

        this.add(mainPanel);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(north, BorderLayout.NORTH);
        mainPanel.add(south, BorderLayout.SOUTH);

        north.add(board);
        board.setLayout(new GridLayout(4, 4));

        south.add(newGame);
        newGame.addActionListener(this);
        north.setBackground(Color.PINK);
        south.setForeground(Color.PINK);

        for (int i = 0; i < 16; i++) {
            Button button = buttonsList.get(i);
            board.add(button);
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
            List<Button> shuffled = button.getButtonsList();
            for (Button button : shuffled) {
                board.add(button);
            }
            board.revalidate();
            board.repaint();
        }
    }
}
