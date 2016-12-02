import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 * Created by Piotrek on 2016-12-02.
 */
public class SUV extends Vehicle {
    Image myImage;

    public SUV(int newx, int newy){
        super(newx, newy);
        width = 60;
        height = 30;
        speed = 8;
        try {
            myImage = ImageIO.read(new File("my_car_suv.png"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void paintMe(Graphics g) {
       /* g.setColor(Color.GREEN);
        g.fillRect(x,y,width,height);*/
        g.drawImage(myImage, x, y,null);

    }
}
