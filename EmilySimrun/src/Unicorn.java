import java.awt.*;

/**
 * Created by emily_wang on 3/16/17.
 */
public class Unicorn extends Pepsi{

    public Unicorn(){
        super(500, 260, false);
        setPic("unicorn.png", 90);
        setSpeed(this.getBoundingRectangle().height * 2);
    }

    @Override
    public void update(){
        super.update();
    }
}
