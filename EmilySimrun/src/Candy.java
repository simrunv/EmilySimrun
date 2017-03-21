import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by simrun_virkud on 3/16/17.
 */
public class Candy extends Pepsi{

    public Candy( int x, int y){
        super (500, 100);
        setPic("candy.png", 90);

}

    public void update() {
        super.update();
        if (getLoc().x < 0) {
            setLoc(new Point(1000, getLoc().y));
        }
    }
}