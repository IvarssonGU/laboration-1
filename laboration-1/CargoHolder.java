import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public abstract class CargoHolder <T extends Car> extends Car {
    private int capacity;
    private final Deque <Car> cars;
    private int trailerAngle;

    public CargoHolder(int capacity){
        this.capacity = capacity;
        cars = new ArrayDeque<>(capacity);
    }

    public CargoHolder(int capacity, int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, boolean personbiel) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, personbiel);
        this.capacity = capacity;
        cars = new ArrayDeque<>(capacity);
        this.trailerAngle = 0;
    }

    public void loadCar(Car car) {
        if (loadingDistance(car) && cars.size() < capacity) {
            if (this.getClass() != car.getClass()) {
                car.setXY(this.getXY());
                cars.push(car);
            }
        }
        //cars.push(car);
    }

    /**
     * A method that unloads the outermost car. Only unloads the car if the flak is down.
     */
    public Car unLoadCar() {
        if (cars.size() > 0) {
            Car tmp = cars.pop();
            int[] newPos = {this.getX(), this.getY()};
            tmp.setXY(newPos);
            return tmp;
        } else {
            throw new RuntimeException ("Requested object not found");
        }
    }

    public int getCarSize () {
        return this.cars.size();
    }

    /**
     * A method that checks whether a given car is withing loading distance from the transport.
     *
     * @param car - the car in question.
     * @return boolean - true if the car is within loading-distance, otherwise false.
     */
    private boolean loadingDistance (Car car) {
        return Math.abs(this.getX() - car.getX()) + Math.abs(this.getY() - car.getY()) <= 10;
    }

    /**
     * A method to move the trailer of the CargoHolder down.
     */
    public void downTrailer(int amount){
        Double tmp = getCurrentSpeed();
        if (tmp.equals(0.0) && trailerAngle + amount <= 70){
            trailerAngle+= amount;
        }
    }

    /**
     * A method to move the trailer of the CargoHolder up.
     */
    public void upTrailer(int amount){
        Double tmp = getCurrentSpeed();
        if (tmp.equals(0.0) && trailerAngle - amount >= 0) {
            trailerAngle-= amount;
        }
    }

    public int getTrailer() {
        return trailerAngle;
    }
}
