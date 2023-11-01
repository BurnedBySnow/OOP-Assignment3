import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    private int number;
    private int[] arrayPosition;
    public Button(int number){
        this.number = number;
        setText(String.valueOf(number));
        setFocusable(false);
        setOpaque(true);
        setPreferredSize(new Dimension(100, 100));
        setMinimumSize(new Dimension(50, 50));
        setBackground(Color.PINK);
        setForeground(Color.BLACK);
        setFont(new Font("Arial", Font.PLAIN, 48));
    }


    public void setFontSize(){
        setFont(new Font("Arial", Font.PLAIN, getHeight() /2));
    }
    public void setNumber(int number) {
        this.number = number;
        this.setText(String.valueOf(number));
    }

    public int[] getArrayPosition() {
        return arrayPosition;
    }
    public void setArrayPosition(int[] arrayPosition) {
        this.arrayPosition = arrayPosition;
    }

    public int getNumber() {
        return number;
    }
}
