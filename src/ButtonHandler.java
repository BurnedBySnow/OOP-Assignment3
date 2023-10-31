import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ButtonHandler {
    private List<Button> buttons = new ArrayList<>();
    private JButton newGame = new JButton("New Game");
    private Button numberBlank = new Button("");
    public Button getBlank() {
        return numberBlank;
    }
    public JButton getNewGameButton() {
        newGame.setFont(new Font("Arial", Font.PLAIN, 20));
        return newGame;
    }

    private void addButtonsToList() {
        int index = 1;
        for (int i = 0; i < 15; i++) {
            buttons.add(new Button(String.valueOf(index)));
            index++;
        }
    }

    public ButtonHandler() {
        addButtonsToList();
    }

    public List<Button> getButtonsList() {
        buttons.remove(getBlank());
        Collections.shuffle(buttons);
        buttons.add(15, getBlank());
        return buttons;
    }

    public List<Button> getNewGame() {
        return getButtonsList();
    }

}
