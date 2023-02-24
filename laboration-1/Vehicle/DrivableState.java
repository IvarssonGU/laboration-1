package Vehicle;

public class DrivableState implements IMoveState {

    private final Truck t;

    public DrivableState (Truck t) {
        this.t = t;
    }

    public void gas(int amount) {
        t.gas(amount);
    }
}
