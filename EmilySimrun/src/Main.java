import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by simrun_virkud on 3/15/17.
 */
public class Main extends JPanel{

    public static final int FRAMEWIDTH = 1000, FRAMEHEIGHT = 600;
    private Pepsi unicorn, candy, candy2, ab, bs, cm, dm, eb, fm, gm, hs, a, b, c, d;
    private Timer timer;
    private boolean[] keys;
    private ArrayList<Cloud> clouds;
    private ArrayList<Pepsi> candies;
    private boolean dead = false;
    private int count;

    public Main(){
        unicorn = new Unicorn();
        dead = false;
        count = 0;

        a = new Candy(100, 400);
        b = new Candy(100, 270);

        c = new Candy(230, 350);
        d = new Candy(230, 0);

        candy = new Candy(400, 0);
        ab = new Candy(400, 350);

        candy2 = new Candy(510, 0);
        bs = new Candy(510, 400);

        cm = new Candy(620, 0);
        dm = new Candy(620, 450);

        eb = new Candy(730, 0);
        fm = new Candy(760, 450);

        gm = new Candy(880, 0);
        hs = new Candy(880, 350);

        keys = new boolean[500];
        clouds = new ArrayList<Cloud>();
        candies = new ArrayList<Pepsi>();

        for (int i = 0; i < 6; i++) {
            clouds.add(new Cloud((int)(Math.random()*1000), 500));
        }


        timer = new Timer(40, new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

                //move the unicorn


                if(keys[KeyEvent.VK_SPACE] && !dead){
                    unicorn.setDir(90);
                    unicorn.jump();
                    keys[KeyEvent.VK_SPACE] = false;
                    //If you want to have the user have to push the key each move use the false.

                }else if (keys[KeyEvent.VK_SPACE] == false && !dead) {
                    unicorn.setDir(270);
                    unicorn.setSpeed(6);
                    unicorn.update();
                    unicorn.rotateBy(180);
                }
                if (keys[KeyEvent.VK_R] && dead == true){
                    dead = false;
                    unicorn.setLoc(new Point(500, 260));
                    unicorn.setDir(90);
                    keys[KeyEvent.VK_R] = false;
                    count = 0;
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
                bs.rotateBy(270);
                cm.setDir(180);
                cm.setSpeed(3);
                cm.update();
                cm.rotateBy(90);
                dm.setDir(180);
                dm.setSpeed(3);
                dm.update();
                dm.rotateBy(270);
                eb.setDir(180);
                eb.setSpeed(3);
                eb.update();
                eb.rotateBy(270);
                fm.setDir(180);
                fm.setSpeed(3);
                fm.update();
                fm.rotateBy(270);
                gm.setDir(180);
                gm.setSpeed(3);
                gm.update();
                gm.rotateBy(90);
                hs.setDir(180);
                hs.setSpeed(3);
                hs.update();
                hs.rotateBy(270);
                a.setDir(180);
                a.setSpeed(3);
                a.update();
                a.rotateBy(90);
                b.setDir(180);
                b.setSpeed(3);
                b.update();
                b.rotateBy(270);
                c.setDir(180);
                c.setSpeed(3);
                c.update();
                c.rotateBy(90);
                d.setDir(180);
                d.setSpeed(3);
                d.update();
                d.rotateBy(270);

                candies.add(candy);
                candies.add(candy2);
                candies.add(ab);
                candies.add(bs);
                candies.add(cm);
                candies.add(dm);
                candies.add(eb);
                candies.add(fm);
                candies.add(gm);
                candies.add(hs);
                candies.add(a);
                candies.add(b);
                candies.add(c);
                candies.add(d);


                for (Cloud c: clouds){
                    c.setDir(180);
                    c.setSpeed(5);
                    c.update();
                    c.rotateBy(-90);
                }

                //check for collisions
//                boolean dead = false;

                for (int i = 0; i < candies.size(); i++) {
                    Pepsi c = candies.get(i);
                    if (c instanceof Candy) {
                        if (unicorn.intersects(c)) {
                            dead = true;
                            i = candies.size();
                        }
                    }
                }

                if(dead){
                    keys[KeyEvent.VK_SPACE] = false;
                    unicorn.setDir(270);
                    unicorn.update();
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
        eb.setPic("candy.png", 90);
        eb.draw(g2);
        fm.setPic("medcandy.png", 90);
        fm.draw(g2);
        gm.draw(g2);
        hs.setPic("candy.png", 90);
        hs.draw(g2);
        a.setPic("smallcandy.png", 90);
        a.draw(g2);
        b.setPic("medcandy.png", 90);
        b.draw(g2);
        c.setPic("candy.png", 90);
        c.draw(g2);
        d.setPic("smallcandy.png", 90);
        d.draw(g2);


        for (Cloud c: clouds){
            c.draw(g2);
        }

        if (dead == true){
            g2.setColor(Color.MAGENTA);
            g2.fillRect(0, 0, 1000, 600);
            try {
                BufferedImage pic = ImageIO.read(new File("EmilySimrun/res/game over.png"));
                g2.drawImage(pic, 100, 0, null);

            } catch (Exception e) {
                e.printStackTrace();
            }
            for (Pepsi p: candies){
                if (p.getLoc().x <= 500) {
                    p.setpast(true);
                }
            }
        }


        for (Pepsi p: candies){
            if (p.getLoc().x <= 500) {
                //p.setpast(true);
                if (p.getpast() == false) {
                    count++;
                    p.setpast(true);
                }
//                p.setpast(false);
            }

        }
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Helvetica", Font.BOLD, 48));
        g2.drawString(" " + count/2, 800, 300);

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

