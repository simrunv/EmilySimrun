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
        dir = 90;
        speed = 5;
//        setPic()

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
            pic = ImageIO.read(new File("res/" + fileName));
            picOrientation = orientation;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
