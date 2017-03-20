import javax.swing.*;

/**
 * Created by simrun_virkud on 3/15/17.
 */
public class Main extends JPanel{

    public static final int FRAMEWIDTH = 1000, FRAMEHEIGHT = 600;

    public static void main(String[] args) {
        JFrame window = new JFrame("Flappy Unicorn");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, FRAMEWIDTH, FRAMEHEIGHT + 22);

        Main panel = new Main();
        panel.setSize(FRAMEWIDTH, FRAMEHEIGHT);

        panel.setFocusable(true);
        panel.grabFocus();

        window.add(panel);
        window.setVisible(true);
        window.setResizable(false);
    }
}

