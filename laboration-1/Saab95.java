import java.awt.*;

/**
 * A class that extends <i>Car</i> and implements the <i>Movable</i> interface.
 */

public class Saab95 extends Car implements Movable{
    /**
     * A boolean that conveys whether the turbo is on or off.
     */
    private boolean turboOn;


    /**
     * The only constructor for this class, which is hard-coded to always create a Saab95, as the class-name implies.
     */
    public Saab95(){
        super(2, 125, 0, Color.red, "Saab95");
        turboOn = false;
        stopEngine();
    }

    public boolean getTurboOn () {
        return turboOn;
    }

    /**
     *  A setter method for the <i>turboOn</i> variable.
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * A setter method for the <i>turboOn</i> variable.
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * A method that returns the speed factor of the car.
     *
     * @return - The speed factor of the car
     */
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return this.getEnginePower() * 0.01 * turbo;
    }

}
