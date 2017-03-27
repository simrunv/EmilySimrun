import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by simrun_virkud on 3/15/17.
 */
public class Main extends JPanel{

    public static final int FRAMEWIDTH = 1000, FRAMEHEIGHT = 600;
    private Pepsi unicorn, candy, candy2, ab, bs, cm, dm;
    private Timer timer;
    private boolean[] keys;
    private ArrayList<Cloud> clouds;

    public Main(){
        unicorn = new Unicorn();
        candy = new Candy(100,0);
        candy2 = new Candy(210,0);
        cm = new Candy(380, 0);
        ab = new Candy(100, 300);
        bs = new Candy(210, 425);
        dm = new Candy(380, 350);
        keys = new boolean[500];
        clouds = new ArrayList<Cloud>();

        for (int i = 0; i < 6; i++) {
            clouds.add(new Cloud((int)(Math.random()*1000), 500));
        }


        timer = new Timer(40, new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

                //move the unicorn

                if(keys[KeyEvent.VK_SPACE]){
                    unicorn.setDir(90);
                    unicorn.jump();
                    keys[KeyEvent.VK_SPACE] = false;
                    //If you want to have the user have to push the key each move use the false.

                }else if (keys[KeyEvent.VK_SPACE] == false) {
                    unicorn.setDir(270);
                    unicorn.setSpeed(6);
                    unicorn.update();
                    unicorn.rotateBy(180);
                }

                candy.setDir(180);
                candy.setSpeed(3);
                candy.update();
                candy.rotateBy(90);
                candy2.setDir(180);
                candy2.setSpeed(3);
                candy2.update();
                candy2.rotateBy(270);
                ab.setDir(180);
                ab.setSpeed(3);
                ab.update();
                ab.rotateBy(270);
                bs.setDir(180);
                bs.setSpeed(3);
                bs.update();
                bs.rotateBy(90);
                cm.setDir(180);
                cm.setSpeed(3);
                cm.update();
                cm.rotateBy(90);
                dm.setDir(180);
                dm.setSpeed(3);
                dm.update();
                dm.rotateBy(270);

                for (Cloud c: clouds){
                    c.setDir(180);
                    c.setSpeed(5);
                    c.update();
                    c.rotateBy(-90);
                }

                repaint();
                }
        });
        timer.start();

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                keys[keyEvent.getKeyCode()] = true;
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                keys[keyEvent.getKeyCode()] = false;
            }
        });

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.MAGENTA);
        g2.fillRect(0, 0, 1000, 600);

        unicorn.draw(g2);
        candy.draw(g2);
        ab.draw(g2);
        candy2.setPic("smallcandy.png", 90);
        candy2.draw(g2);
        bs.setPic("smallcandy.png", 90);
        bs.draw(g2);
        cm.setPic("medcandy.png", 90);
        cm.draw(g2);
        dm.setPic("medcandy.png", 90);
        dm.draw(g2);

        for (Cloud c: clouds){
            c.draw(g2);
        }

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

