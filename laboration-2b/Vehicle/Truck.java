package Vehicle;

import java.awt.*;

public abstract class Truck extends Car implements IMoveState {
    private int trailerAngle;

    private IMoveState state = new DrivableState(this);

    public Truck (int nrDoors, int enginePower, double currentSpeed, Color color, String modelName) {
        super(2, 1200, 0, Color.white, modelName);
        this.trailerAngle = 0;
    }

    /**
     * A method to move the trailer of the Vehicle.Truck down.
     */
    public void downTrailer(int amount){
        Double tmp = super.getCurrentSpeed();
        if (tmp.equals(0.0) && trailerAngle + amount <= 70){
            trailerAngle+= amount;
        }
        if (trailerAngle > 0) {
            this.state = new LockedState(this);
        }
    }

    /**
     * A method to move the trailer of the Vehicle.Truck up.
     */
    public void upTrailer(int amount){
        Double tmp = super.getCurrentSpeed();
        if (tmp.equals(0.0) && trailerAngle - amount >= 0) {
            trailerAngle-= amount;
        }
        if (trailerAngle == 0) {
            this.state = new DrivableState(this);
        }
    }

    /**
     * A method to that returns the angle of the trailer.
     *
     * @return int - the angle (0-70)
     */
    public int getTrailer() {
        return trailerAngle;
    }

    @Override
    public void gas(int amount){
        state.gas(amount);
    }
}
