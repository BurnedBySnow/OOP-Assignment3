import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    private int number;
    public Button(int number){
        this.number = number;
        setText(String.valueOf(number));
        setFocusable(false);
        setOpaque(true);
        setPreferredSize(new Dimension(100, 100));
        setBackground(Color.PINK);
        setForeground(Color.BLACK);
        setFont(new Font("Arial", Font.PLAIN, 48));
    }

    public void setNumber(int number) {
        this.number = number;
        this.setText(String.valueOf(number));
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
