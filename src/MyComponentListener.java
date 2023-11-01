import javax.swing.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Timer;
import java.util.TimerTask;

public class MyComponentListener implements ComponentListener {
    JPanel panel;
    Timer resizeTimer;

    public MyComponentListener(JPanel panel) {
        this.panel = panel;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        if (resizeTimer != null) {
            resizeTimer.cancel();
        }
        resizeTimer = new Timer();
        resizeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < 16; i++) {
                    ((Button) panel.getComponent(i)).setFontSize();
                }
            }
        }, 50);
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
