import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Traffic implements ActionListener, Runnable {

    JFrame frame = new JFrame("Traffic simulation");
    Road road = new Road();

    //South container
    JButton start = new JButton("Start");
    JButton stop = new JButton("Stop");
    JLabel throughput = new JLabel("Throughput:0");
    Container south = new Container();

    //West container
    JButton truck = new JButton("Add Truck");
    JButton suv = new JButton("Add SUV");
    JButton sports = new JButton("Add Sports");
    Container west = new Container();

    boolean running = false;
    int carCount = 0;
    long startTime = 0;

    public Traffic(){
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
        frame.add(road, BorderLayout.CENTER);

        south.setLayout(new GridLayout(1,3));
        south.add(start);
        start.addActionListener(this);
        south.add(stop);
        stop.addActionListener(this);
        south.add(throughput);
        frame.add(south, BorderLayout.SOUTH);

        west.setLayout(new GridLayout(3,1));
        west.add(truck);
        truck.addActionListener(this);
        west.add(suv);
        suv.addActionListener(this);
        west.add(sports);
        sports.addActionListener(this);
        frame.add(west, BorderLayout.WEST);

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.repaint();
    }

    public static void main(String [] args){
        new Traffic();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource().equals(start)){
            if(running == false){
                running = true;
                road.resetCarCount();
                startTime = System.currentTimeMillis();
                Thread t = new Thread(this);
                t.start();
            }
        }
        if(event.getSource().equals(stop))
            running = false;
        if(event.getSource().equals(truck)){
            Truck truck = new Truck(0, 20);
            road.addCar(truck);
            for (int x = 0; x < road.ROAD_WIDTH; x = x + 20){
                for(int y = 40; y < 480; y = y + 120){
                    truck.setX(x);
                    truck.setY(y);
                    if(road.collision(x, y, truck) == false){
                        frame.repaint();
                        return;
                    }
                }
            }
        }
        if(event.getSource().equals(suv)){
            SUV suv = new SUV(0, 20);
            road.addCar(suv);
            for (int x = 0; x < road.ROAD_WIDTH; x = x + 20){
                for(int y = 40; y < 480; y = y + 120){
                    suv.setX(x);
                    suv.setY(y);
                    if(road.collision(x, y, suv) == false){
                        frame.repaint();
                        return;
                    }
                }
            }
        }
        if(event.getSource().equals(sports)){
            Sports sports= new Sports(0, 20);
            road.addCar(sports);
            for (int x = 0; x < road.ROAD_WIDTH; x = x + 20){
                for(int y = 40; y < 480; y = y + 120){
                    sports.setX(x);
                    sports.setY(y);
                    if(road.collision(x, y, sports) == false){
                        frame.repaint();
                        return;
                    }
                }
            }
        }
        /*if(event.getSource().equals(light)) {
            TrafficLight trafficLight = new TrafficLight(150, 40);
            road.addCar(trafficLight);
            trafficLight.status = trafficLight.status + 1;
            if (trafficLight.status == 4) {
                trafficLight.status = 0;
            }
        }*/
    }

    @Override
    public void run() {
        while(running) {
            road.step();
            carCount = road.getCarCount();

            double throughputCalc = carCount / (1000 * (double)(System.currentTimeMillis() - startTime));
            throughput.setText("Throughput:" + throughputCalc);
            frame.repaint();
            try {
                Thread.sleep(100);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

}