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
    private Pepsi unicorn, candy, candy2, a;
    private Timer timer;
    private boolean[] keys;
    private ArrayList<Cloud> clouds;

    public Main(){
        unicorn = new Unicorn();
        candy = new Candy(100,0);
        candy2 = new Candy(300,0);
        a = new Candy(100, 100);
        keys = new boolean[500];
        clouds = new ArrayList<Cloud>();

        for (int i = 0; i < 6; i++) {
            clouds.add(new Cloud((int)(Math.random()*1000), 450));
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
                candy.setSpeed(2); //
                candy.update();
                candy.rotateBy(90);
                candy2.setDir(180);
                candy2.setSpeed(2);
                candy2.update();
                candy2.rotateBy(270);

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
        candy2.setPic("smallcandy.png", 90);
        candy2.draw(g2);

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

