import java.awt.*;

/**
 * A class that extends <i>Car</i> and implements the <i>Movable</i> interface.
 */
public class Scania extends CargoHolder implements Movable{
    /**
     * The only constructor for this class, which is hard-coded to always create a Scania, as the class-name implies.
     */
    public Scania(){
        super(10, 2, 1200, 0, Color.white, "Scania R730 Streamline", false);
        stopEngine();
    }

    @Override
    public double speedFactor(){
        return this.getEnginePower() * 0.01;
    }

    /**
     * A method to move the 'flak' of the Scania down.
     */
    public void downTrailer () {
        super.downTrailer(1);
    }

    /**
     * A method to move the 'flak' of the scania up:
     */
    public void upTrailer () {
        super.upTrailer(1);
    }

    @Override
    public void gas(double amount){
        if (this.getTrailer() == 0) {
            super.gas(amount);
        }
    }


}
