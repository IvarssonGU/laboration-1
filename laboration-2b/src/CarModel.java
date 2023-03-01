import Vehicle.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/*
* This class represents the Model part in the MVC pattern.
* It's responsibilities is to listen to the Controller and responds in a appropriate manner by
* modifying it's state and the updating the view.
 */

public class CarModel {
    // member fields:
    private List<ModelObserver> observers = new ArrayList<>();

    private final CompositeCar c;

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 10;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    //CarController frame;
    // A list of cars, modify if needed
    //ArrayList<Car> cars = new ArrayList<>(10);

    //methods:

    public CarModel () {
        this.c = new CompositeCar();
        this.c.addAll(VehicleFactory.createCarList());
        // Start the timer
        this.timer.start();
    }


    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            c.wallCollision();
            c.move();
            multicastStatusChange(c.getAll());
        }
    }

    public void addObserver(ModelObserver observer){
        observers.add(observer);
    }

    private void multicastStatusChange(List<Car> newStatus){
        for (ModelObserver observer : observers){
            observer.actOnModelChange((ArrayList<Car>) newStatus);
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : c.getAll()) {
            car.gas(gas);
            car.move();
        }
    }

    void brake(double amount) {
        for (Car car : c.getAll()) {
            car.brake(amount / 100);
        }
    }

    void startEngine () {
        for (Car car : c.getAll()) {
            car.startEngine();
        }
    }

    void stopEngine () {
        for (Car car : c.getAll()) {
            car.stopEngine();
        }
    }

    void setTurboOn () {
        for (Car car : c.getAll()) {
            if (car instanceof Saab95 saab) {
                saab.setTurboOn();
            }
        }
    }

    void setTurboOff () {
        for (Car car : c.getAll()) {
            if (car instanceof Saab95 saab) {
                saab.setTurboOff();
            }
        }
    }

    void setTrailerDown () {
        for (Car car : c.getAll()) {
            if (car instanceof Scania scania) {
                scania.downTrailer();
            }
        }
    }

    void setTrailerUp () {
        for (Car car : c.getAll()) {
            if (car instanceof Scania scania) {
                scania.upTrailer();
            }
        }
    }

    void addCar () {
        if (c.size()< 10) {
            Car tmp = VehicleFactory.createRandomCar(CarSim.frameWidth, CarSim.frameHeight);
            c.add(tmp);
        }
    }

    void removeCar () {
        if (c.size() > 0) {
            c.remove();
        }
    }
}
