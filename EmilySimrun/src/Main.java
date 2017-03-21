import javax.swing.*;
import java.awt.*;

/**
 * Created by simrun_virkud on 3/15/17.
 */
public class Main extends JPanel{

    public static final int FRAMEWIDTH = 1000, FRAMEHEIGHT = 600;
    private Pepsi unicorn, candy, candy2;

    public Main(){
        unicorn = new Unicorn();
        candy = new Candy(100,100);
        candy2 = new Candy(200,250);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        unicorn.draw(g2);
        candy.draw(g2);
        candy2.setPic("smallcandy.png", 90);
        candy2.draw(g2);

    }




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

