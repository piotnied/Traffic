import java.awt.*;

/**
 * Created by Piotrek on 2016-12-02.
 */
public abstract class Vehicle {
    int x;
    int y;
    int width;
    int height;
    int speed;

    public Vehicle (int newx, int newy) {
        x = newx;
        y = newy;
    }

    public abstract void paintMe(Graphics g);

    public int getX(){
        return x;
    }

    public void setX(int newx){
        x = newx;
    }

    public int getSpeed() {
        return speed;
    }

    public int getY() {
        return y;
    }

    public void setY(int newy){
        y = newy;
    }

    public int getWidth() {
        return width;
    }



}
