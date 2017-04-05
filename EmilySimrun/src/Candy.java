import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by simrun_virkud on 3/16/17.
 */
public class Candy extends Pepsi{
    private boolean patt;
    public Candy( int x, int y,boolean pat){
        super (x, y);
        setPic("candy.png", 90);
        patt=pat;

    }


    @Override
    public void update() {
        super.update();
        if (getLoc().x < 0) {
            setLoc(new Point(1000, getLoc().y));
        }
        super.update();
    }
    public boolean getpat(){
        return patt;
    }
    public void betpat(boolean pat){
        patt=pat;
    }
}