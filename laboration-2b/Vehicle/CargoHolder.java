package Vehicle;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A class that holds the functionality for loading, unloading cars. (as well as getters and such for the list of cars)
 *
 * @param <T> - the type of cars to be handled by the Vehicle.CargoHolder.
 */
public class CargoHolder <T extends Car> {
    private final int capacity;
    private final Deque <T> cars;
    private final IPostionable bb;

    /**
     * The one and only constructor for this class.
     *
     * @param capacity - the max amount of cars that this specific Vehicle.CargoHolder can hold at the same time.
     * @param bb - reference to the 'owner-object' of the class.
     */
    public CargoHolder(int capacity, IPostionable bb) {
        this.bb = bb;
        this.capacity = capacity;
        cars = new ArrayDeque<>(capacity);

    }

    /**
     * A method used to load a requested car into the Vehicle.CargoHolder.
     *
     * @param car - The car to be loaded.
     */
    public void loadCar (T car) {
        if (loadingDistance(car) && this.cars.size() < this.capacity) {
            cars.push(car);
        }
    }

    /**
     * A method that unloads the outermost car. Only unloads the car if the flak is down.
     */
    public Car unLoadCar() {
        if (cars.size() > 0) {
            return cars.pop();
        } else {
            throw new RuntimeException ("Requested object not found");
        }
    }

    /**
     * A method that returns the list of cars currently stored in the Vehicle.CargoHolder.
     *
     * @return Deque<T> - The list of cars
     */
    public Deque<T> getCars () {
        return this.cars;
    }

    /**
     * A method that checks whether a given car is withing loading distance from the transport.
     *
     * @param car - the car in question.
     * @return boolean - true if the car is within loading-distance, otherwise false.
     */
    private boolean loadingDistance (Car car) {
            return  Math.abs(bb.getX() - car.getX()) + Math.abs(bb.getY() - car.getY()) <= 10;
    }
}
