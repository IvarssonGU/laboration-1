package Vehicle;

import java.awt.*;

/**
 * @author Oliver, Ååååhh-mar och alleballeboss
 * An abstract class that implements <i>Vehicle.Movable</i> with more car-specific methods and functionality.
 *
 * <p>
 *     <i>Very good class, altbeit abstract!</i>
 * </p>
 */
public abstract class Car implements Movable {

    /**
     * Instance variables
     */
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name
    private int x;
    private int y;
    private int dir;

    /**
     * A constructor for the <i>Vehicle.Car</i> class.
     *
     * @param nrDoors - The number of doors on the car
     * @param enginePower - The power of the engine represented in an integer
     * @param currentSpeed - The current speed of the car
     * @param color - The color of the car
     * @param modelName - The name of the model
     * @param x - The x coordinate
     * @param y - The y coordinate
     * @param dir - The direction
     */


    /**
     * A car constructor that subclasses inherits.
     */
    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        x = 0;
        y = 0;
    }

    public Car(int x, int y, int nrDoors, double enginePower, double currentSpeed, int dir, Color color, String modelName) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
    }

    /**
     * A getter method for <i>nrDoors</i>.
     *
     * @return - The number of doors
     */
    public int getNrDoors(){
        return nrDoors;
    }

    public String getModelName () {
        return this.modelName;
    }

    /**
     * A getter method for <i>enginePower</i>.
     *
     * @return - The engine power
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * A getter method for <i>currentSpeed</i>
     *
     * @return - The current speed
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * A getter method for <i>color</i>.
     *
     * @return - The color of the car
     */
    public Color getColor(){
        Color newColor = color;
        return newColor;
    }

    /**
     * A setter method for <i>color</i>.
     *
     * @param clr - The color to be set
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * A method that "starts" the engine by setting <i>currentSpeed</i> to 0.1.
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * A method that simulates turning <i>off</i> the engine of the car.
     * The method sets the <i>currentSpeed</i> to 0.
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * An abstract method to be implemented by object instances extending this class.
     *
     * @return - The speedFactor of the car
     */
    public double speedFactor(){
        return 0.0;
    }

    public int getDir () {
        return dir;
    }

    /**
     *
     * @return - It returns the pixel value at the x.
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return - It returns the pixel value at the y.
     */
    public int getY(){
        return y;
    }

    public void setX(int newx) { x = newx; }

    public void setY(int newy) { y = newy; }

    /**
     * This method increase the car speed with amount speed.
     * @param amount
     */
    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /**
     * A method that decreases the cars speed by a given <i>amount</i>.
     *
     * @param amount - The amount sent in to the method
     */
    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    /**
     * A method that uses the <i>incrementSpeed</i> method to increase the <i>currentSpeed</i>.
     * @param amount - The amount the method should increase the speed.
     */

    public void gas(double amount){
        if (0 <= amount && amount <= 1) {
            incrementSpeed(amount);
        }
    }

    /**
     * A public method that calls the private equivalent <i>decrementSpeed()</i>.
     *
     * @param amount - The amount to brake with
     */
    public void brake(double amount){
        if (0 <= amount && amount <= 1) {
            decrementSpeed(amount);
        }
    }

    /**
     * A method that moves the car in the right direction.
     */
    public void move(){
        if (dir == 0) {
            y += (int) currentSpeed;
        } else if (dir == 1) {
            x -= (int) currentSpeed;
        } else if (dir == 2) {
            y -= (int) currentSpeed;
        } else {
            x += (int) currentSpeed;
        }
    }

    /**
     * A method that turns the car to the left.
     */
    public void turnLeft(){
        if (dir >= 3) {
            dir = 0;
        } else {
            dir++;
        }
    }

    /**
     * A method that turns the car to the right.
     */
    public void turnRight() {
        if (dir <= 0) {
            dir = 3;
        } else {
            dir--;
        }
    }


}
