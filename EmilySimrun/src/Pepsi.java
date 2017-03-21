import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by emily_wang on 3/16/17.
 */
public class Pepsi {

    private Point loc;
    private int dir, picOrientation;
    private int speed;
    private BufferedImage pic;

    public Pepsi(int x, int y){
        loc = new Point(x, y);
        setLoc(loc);
        dir = 90;
        speed = 5;
        setPic("blank.png", 0);
    }

    public void draw(Graphics2D g2) {
        double rotationRequired = Math.toRadians(picOrientation - dir);
        double locationX = pic.getWidth() / 2;
        double locationY = pic.getHeight() / 2;
        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        g2.drawImage(op.filter(pic, null), loc.x, loc.y, null);
    }

    public void setPic(String fileName, int orientation) {
        try {
            pic = ImageIO.read(new File("EmilySimrun/res/" + fileName));
            picOrientation = orientation;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        int dx = (int) (Math.cos(Math.toRadians(dir)) * speed);
        int dy = -(int) (Math.sin(Math.toRadians(dir)) * speed);
        loc.translate(dx, dy);
    }

    public void setDir(int newDir) {
        dir = newDir;
    }

    public Point getLoc() {
        return loc;
    }

    public void setLoc(Point loc) {
        this.loc = loc;
    }

    public int getDir() {
        return dir;
    }

    public Rectangle getBoundingRectangle() {
        return new Rectangle(loc.x, loc.y, pic.getWidth(), pic.getHeight());
    }

    public boolean intersects(Pepsi other){
        return getBoundingRectangle().intersects(other.getBoundingRectangle());
    }

}
