// TODO: cargoHolder klass (deque) som "innmehåller" bilar med all gemensam.
/*
    - load-function som bara trycker in en car i en deque-lista.
    - eventuellt gas-funktion (ska inte kunna gasa vid flak-up)
    -
 */

/**
 * A class that is designed to represent a car-workshop. It holds a certain type and amount of cars.
 *
 * @param <T> - The type of Car that can be worked on in the garage.
 */
public class Workshop <T extends Car> extends CargoHolder{
    /**
     * The one and only constructor for this class.
     *
     * @param capacity - the max amount of cars that the workshop can work on/hold/store at the same time.
     */
    public Workshop (int capacity) {
      super(capacity);
    }
}
