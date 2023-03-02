package Vehicle;

import java.awt.*;

public final class ImmutableCar {

    private final int x;
    private final int y;
    private final int dir;
    private final int nrDoors;
    private final double enginePower;
    private final double currentSpeed;
    private final Color color;
    private final String modelName;

    public ImmutableCar(Car car) {
        this.x = car.getX();
        this.y = car.getY();
        this.dir = car.getDir();
        this.nrDoors = car.getNrDoors();
        this.enginePower = car.getEnginePower();
        this.currentSpeed = car.getCurrentSpeed();
        this.color = car.getColor();
        this.modelName = car.getModelName();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDir() {
        return dir;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public String getModelName() {
        return modelName;
    }

}
