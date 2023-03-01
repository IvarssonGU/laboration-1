import Vehicle.Car;

import java.util.ArrayList;
import java.util.List;

public class CompositeCar {
    private List<Car> cars = new ArrayList<>();

    // add all cars method
    public void addAll (ArrayList<Car> cs) {
        cars.addAll(cs);
    }

    public void add (Car car) {
        cars.add(car);
    }

    public void remove () {
        cars.remove(0);
    }

    public void move () {
        for (Car car : cars) {
            car.move();
        }
    }

    public void wallCollision() {
        for (Car c : cars) {
            if (c.getY() > CarSim.frameHeight - 240 - 60) {
                turnAround(c);
                c.setY(CarSim.frameHeight - 300);
            } else if (c.getY() < 0) {
                turnAround(c);
                c.setY(0);
            } else if (c.getX() > CarSim.frameWidth - 100) {
                turnAround(c);
                c.setX(CarSim.frameWidth - 100);
            } else if (c.getX() < 0) {
                turnAround(c);
                c.setX(0);
            }
        }
    }

    private void turnAround (Car c) {
        c.stopEngine();
        c.turnRight();
        c.turnRight();
        c.startEngine();
    }

    public int size() {
        int i = 0;
        for (Car c : cars) {
            i++;
        }
        return i;
    }

    public List<Car> getAll() {
        return this.cars;
    }
}
