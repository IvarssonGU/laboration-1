package Vehicle;

import java.awt.*;
/**
 * A class that defines a personal car
 */
public abstract class Personal_Car extends Car {

    public Personal_Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName){
        super(nrDoors, enginePower, currentSpeed, color, modelName);
    }
}
