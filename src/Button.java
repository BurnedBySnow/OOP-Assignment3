import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    public Button(String number){
        super(number);
        setOpaque(true);
        setPreferredSize(new Dimension(100, 100));
        setBackground(Color.PINK);
        setForeground(Color.BLACK);
        setFont(new Font("Arial", Font.PLAIN, 48));
    }
}
