import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 10;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.get(0).setY(20);
        cc.cars.get(0).setX(20);
        cc.cars.add(new Scania());
        cc.cars.get(1).setY(20);
        cc.cars.get(1).setX(140);
        cc.cars.add(new Saab95());
        cc.cars.get(2).setY(20);
        cc.cars.get(2).setX(260);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < cars.size(); i++) { // listan med cars skickas in i skit
                wallCollision(i);
                cars.get(i).move();
                int x = (int) Math.round(cars.get(i).getX());
                int y = (int) Math.round(cars.get(i).getY());
                frame.drawPanel.moveit(x, y, i);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    private void wallCollision(int i) {
        if (cars.get(i).getY() > frame.getHeight() - 240 - 60) {
            turnAround(i);
            cars.get(i).setY(frame.getHeight() - 300);
        } else if (cars.get(i).getY() < 0) {
            turnAround(i);
            cars.get(i).setY(0);
        } else if (cars.get(i).getX() > frame.getWidth() - 100) {
            turnAround(i);
            cars.get(i).setX(frame.getWidth() - 100);
        } else if (cars.get(i).getX() < 0) {
            turnAround(i);
            cars.get(i).setX(0);
        }
    }

    private void turnAround (int i) {
        cars.get(i).stopEngine();
        cars.get(i).turnRight();
        cars.get(i).turnRight();
        cars.get(i).startEngine();
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
            car.move();
        }
    }

    void brake(double amount) {
        for (Car car : cars) {
            car.brake(amount / 100);
        }
    }

    void startEngine () {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    void stopEngine () {
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    void setTurboOn () {
        for (Car car : cars) {
            if (car instanceof Saab95 saab) {
                saab.setTurboOn();
            }
        }
    }

    void setTurboOff () {
        for (Car car : cars) {
            if (car instanceof Saab95 saab) {
                saab.setTurboOff();
            }
        }
    }

    void setTrailerDown () {
        for (Car car : cars) {
            if (car instanceof Scania scania) {
                scania.downTrailer();
            }
        }
    }

    void setTrailerUp () {
        for (Car car : cars) {
            if (car instanceof Scania scania) {
                scania.upTrailer();
            }
        }
    }
}
