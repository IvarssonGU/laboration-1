import Vehicle.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
* This class represents the Model part in the MVC pattern.
* It's responsibilities is to listen to the Controller and responds in a appropriate manner by
* modifying it's state and the updating the view.
 */

public class CarModel {
    // member fields:
    private List<ModelObserver> observers = new ArrayList<>();

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 10;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    //CarController frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>(10);

    //methods:

    public CarModel () {
        this.cars = VehicleFactory.createCarList();
        // Start the timer
        this.timer.start();
    }


    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < cars.size(); i++) {
                wallCollision(i);
                cars.get(i).move();
                //int x = (int) Math.round(cars.get(i).getX());
                //int y = (int) Math.round(cars.get(i).getY());
                //frame.drawPanel.moveit(x, y, i);
                //repaint() calls the paintComponent method of the panel
                //frame.drawPanel.repaint();
            }
            multicastStatusChange(cars);
        }
    }

    public void addObserver(ModelObserver observer){
        observers.add(observer);
    }

    private void multicastStatusChange(ArrayList<Car> newStatus){
        for (ModelObserver observer : observers){
            observer.actOnModelChange(newStatus);
        }
    }

    private void wallCollision(int i) {
        if (cars.get(i).getY() > CarSim.frameHeight - 240 - 60) {
            turnAround(i);
            cars.get(i).setY(CarSim.frameHeight - 300);
        } else if (cars.get(i).getY() < 0) {
            turnAround(i);
            cars.get(i).setY(0);
        } else if (cars.get(i).getX() > CarSim.frameWidth - 100) {
            turnAround(i);
            cars.get(i).setX(CarSim.frameWidth - 100);
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

    void addCar () {
        if (this.cars.size()< 10) {
            cars.add(VehicleFactory.createRandomCar(CarSim.frameWidth, CarSim.frameHeight));
        }
    }

    void removeCar () {
        if (this.cars.size() > 0) {
            cars.remove(0);
        }
    }
}
