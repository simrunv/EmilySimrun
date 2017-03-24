import java.awt.*;

/**
 * Created by emily_wang on 3/24/17.
 */
public class Cloud extends Pepsi{


    public Cloud( int x, int y){
        super(x, y);
        setPic("cloud.png", 90);

    }


    @Override
    public void update() {
        super.update();
        if (getLoc().x < 0) {
            setLoc(new Point(1000, getLoc().y));
        }
        super.update();
    }
}
