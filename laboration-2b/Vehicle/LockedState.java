package Vehicle;

public class LockedState implements IMoveState {

    private final Truck t;

    public LockedState (Truck t) {
        this.t = t;
    }

    public void gas (int amount) {
        t.gas(0); // perhaps throw an exception
    }
}
