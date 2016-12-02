import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TrafficLight extends JPanel /*implements MouseListener*/ {

    // JPanel panel;
    private int status;
    private Color offRed;
    private Color offYellow;
    private Color offGreen;

    public TrafficLight() {
         // panel = new JPanel(new FlowLayout());
        // panel.setSize(90, 250);
        //panel.setBackground(Color.LIGHT_GRAY);
        //addMouseListener(this);

        offRed = new Color(128, 0, 0);
        offYellow = new Color(192, 192, 0);
        offGreen = new Color(0, 96, 0);
        status = 0;

    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        // Set the actual colours to the "off" shades to begin with.
        Color actualRed = offRed;
        Color actualYellow = offYellow;
        Color actualGreen = offGreen;

        // These combinations match traffic lights in the UK.
        if (status == 0) {
            actualGreen = Color.GREEN;
        } else if (status == 1) {
            actualYellow = Color.YELLOW;
        } else if (status == 2) {
            actualRed = Color.RED;
        } else if (status == 3) {
            actualYellow = Color.YELLOW;
            actualRed = Color.RED;
        }

        // Now draw the lights once each
        drawLight(g2d, 10, actualRed);
        drawLight(g2d, 20, actualYellow); //90
        drawLight(g2d, 30, actualGreen); //170
    }

    private void drawLight(Graphics g, int height, Color colour) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(colour);
        g2d.fillOval(10, height, 10, 10);
        g2d.setColor(Color.BLACK);
        g2d.drawOval(10, height, 10, 10);
    }

    /*@Override
    public void mouseClicked(MouseEvent event) {
        status = status + 1;
        if (status == 4) {
            status = 0;
        }
        repaint();
    }*/

    /*@Override
    public void mouseEntered(MouseEvent event) {
    }

    @Override
    public void mouseExited(MouseEvent event) {
    }

    @Override
    public void mousePressed(MouseEvent event) {
    }

    @Override
    public void mouseReleased(MouseEvent event) {
    }*/

   /* public static void main(String[] args) {

        JFrame win = new JFrame("Traffic Light");
        win.setSize(130, 290);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        win.add(new TrafficLight());
        // win.pack();
        win.setVisible(true);

    }*/

}
