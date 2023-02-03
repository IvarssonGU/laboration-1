import javax.swing.text.Position;
import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;
import java.util.Stack;

/**
 * An abstract class that implements <i>Movable</i> and extends car, and adds more more specific methods and functionality.
 *
 * <p>
 *     <i>Very good class, not abstract!</i>
 * </p>
 */
public class Car_Transporter extends CargoHolder {

    /**
     * A constructor for the <i>Car</i> class.
     * Passes most constructor-values to its superclass, Car, but also adds some values unique to this class!
     */
    public Car_Transporter (int capacity){
        super(10, 2, 500, 0, Color.yellow, "Herpa -Scania CS 20 HD halvsläpvagn X pendel med interdolly Esser tung transport (Nordrhein-Westfalen/Würselen)", false);
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
    @Override
    public void loadCar (Car car) {
        if (this.getTrailer() == 70) {
            super.loadCar(car);
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
}
