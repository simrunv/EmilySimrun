import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by simrun_virkud on 3/16/17.
 */
public class Candy extends Pepsi{

    public Candy( int x, int y){
        super (500, 300);
        setPic("candy.png", 0);

}
//    @Override
//    public void update() {
//        super.update();
//        if (getLoc().x > 1000) {
//            setLoc(new Point(0, getLoc().y));
//        } else if (getLoc().x < 0) {
//            setLoc(new Point(1000, getLoc().y));
//        }
//    }
//}