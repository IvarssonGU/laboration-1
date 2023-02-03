import java.awt.*;

public class Truck extends Car {
    private int trailerAngle;

    public Truck (int nrDoors, int enginePower, double currentSpeed, Color color, String modelName) {
        super(2, 1200, 0, Color.white, "Scania R730 Streamline");
        this.trailerAngle = 0;
    }

    /**
     * A method to move the trailer of the Truck down.
     */
    public void downTrailer(int amount){
        Double tmp = super.getCurrentSpeed();
        if (tmp.equals(0.0) && trailerAngle + amount <= 70){
            trailerAngle+= amount;
        }
    }

    /**
     * A method to move the trailer of the Truck up.
     */
    public void upTrailer(int amount){
        Double tmp = super.getCurrentSpeed();
        if (tmp.equals(0.0) && trailerAngle - amount >= 0) {
            trailerAngle-= amount;
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
}
