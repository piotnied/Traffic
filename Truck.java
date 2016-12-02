import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 * Created by Piotrek on 2016-12-02.
 */
public class Truck extends Vehicle {
    Image myImage;

    public Truck(int newx, int newy){
        super(newx, newy);
        width = 100;
        height = 40;
        speed = 5;
        try {
            myImage = ImageIO.read(new File("my_car_semi.png"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void paintMe(Graphics g) {
       /* g.setColor(Color.BLUE);
        g.fillRect(x,y,width,height);*/
        g.drawImage(myImage, x, y, null);

    }
}
