import java.awt.*;

/**
 * A class that extends <i>Car</i> and implements the <i>Movable</i> interface.
 */
public class Volvo240 extends Car {

    /**
     * The trim factor of the car.
     */
    private final static double trimFactor = 1.25;

    /**
     * The only constructor for this class, which is hard-coded to always create a Volvo240, as the class-name implies.
     */
    public Volvo240(){
        super(2, 100, 0, Color.blue, "Volvo240", true);
        stopEngine();
    }


    @Override
    public double speedFactor(){
        return this.getEnginePower() * 0.01 * trimFactor;
    }
}
