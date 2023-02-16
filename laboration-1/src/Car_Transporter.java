
import java.awt.*;
import java.util.Deque;


/**
 * An abstract class that implements <i>Movable</i> and extends car, and adds more more specific methods and functionality.
 *
 * <p>
 *     <i>Very good class, not abstract!</i>
 * </p>
 */
public class Car_Transporter <T extends Personal_Car> extends Truck {
    private final CargoHolder<T> cargoHolder;

    /**
     * A constructor for the <i>Car</i> class.
     * Passes most constructor-values to its superclass, Car, but also adds some values unique to this class!
     */
    public Car_Transporter (int capacity) {
        super(2, 500, 0, Color.yellow, "Herpa -Scania CS 20 HD halvsläpvagn X pendel med interdolly Esser tung transport (Nordrhein-Westfalen/Würselen)");
        this.cargoHolder = new CargoHolder<T>(capacity, this);
    }

    /**
     * A method to move the 'flak' of the Car_transporter down.
     */
    public void downTrailer () {
        super.downTrailer(70);
    }

    /**
     * A method to move the 'flak' of the Car_Transporter up:
     */
    public void upTrailer () {
        super.upTrailer(70);
    }


    /**
     * A method that pushes a Car to the Car_transporters local stack.
     * Simulates the process of loading on a car to a car transporter.
     * @param car - pushes the car object to the Car_transporters stack.
     */
    public void loadCar (T car) {
        if (this.getTrailer() == 70) {
            cargoHolder.loadCar(car);
        }
    }



    public Car unLoadCar () {
        if (this.getTrailer() == 70) {
            return cargoHolder.unLoadCar();
        }
        throw new RuntimeException("Trailer was not down >:(");
    }

    /**
     * A method that moves the car in the right direction. (modified for you know what!)
     */
    @Override
    public void move(){
        int currentSpeed = (int) getCurrentSpeed();
        if (getDir() == 0) {
            this.setX(this.getX() + currentSpeed);
        } else if (getDir() == 1) {
            this.setY(this.getY() + (int) currentSpeed);
        } else if (getDir() == 2) {
            this.setX(this.getX() - currentSpeed);
        } else {
            this.setY(this.getY() - (int) currentSpeed);
        }
        for (Car car : cargoHolder.getCars()) {
            this.setX(this.getX() + currentSpeed);
            car.setX(this.getX());
            car.setY(this.getY());
        }
    }

    /**
     * A method that returns the speed factor of the car transporter.
     * @return double
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void gas(double amount){
        if (this.getTrailer() == 0) {
            super.gas(amount);
        }
    }
    public Deque<T> getCars(){
        return cargoHolder.getCars();
    }
}
