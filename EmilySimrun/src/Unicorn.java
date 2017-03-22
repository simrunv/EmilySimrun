import java.awt.*;

/**
 * Created by emily_wang on 3/16/17.
 */
public class Unicorn extends Pepsi{

    public Unicorn(){
        super(200, 300);
        setPic("unicorn.png", 90);
        setSpeed(this.getBoundingRectangle().height);
    }

    @Override
    public void update(){
        super.update();
    }
}
