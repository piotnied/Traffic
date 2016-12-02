import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Piotrek on 2016-12-02.
 */
public class Sports extends Vehicle{
    Image myImage;

    public Sports(int newx, int newy){
        super(newx, newy);
        width = 40;
        height = 20;
        speed = 12;
        try {
            myImage = ImageIO.read(new File("my_car_s.png"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void paintMe(Graphics g) {
        /*g.setColor(Color.RED);
        g.fillRect(x,y,width,height);*/
        g.drawImage(myImage, x, y, null);

    }
}
