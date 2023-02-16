// TODO: cargoHolder klass (deque) som "innmehåller" bilar med all gemensam.
/*
    - load-function som bara trycker in en car i en deque-lista.
    - eventuellt gas-funktion (ska inte kunna gasa vid flak-up)
    -
 */

import java.util.Deque;

/**
 * A class that is designed to represent a car-workshop. It holds a certain type and amount of cars.
 *
 * @param <T> - The type of Car that can be worked on in the garage.
 */
public class Workshop <T extends Car> implements IPostionable {

    private CargoHolder<T> cargoHolder;
    private final int capacity;
    private int y;
    private int x;

    /**
     * The one and only constructor for this class.
     *
     * @param capacity - the max amount of cars that the workshop can work on/hold/store at the same time.
     */
    public Workshop (int capacity, int x, int y) {
      cargoHolder = new CargoHolder<T>(capacity, this);
      this.capacity = capacity;
      this.x = x;
      this.y = y;
    }

    public void loadCar(T car) {
        cargoHolder.loadCar(car);
    }

    public Car unLoadCar () {
        return cargoHolder.unLoadCar();
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Deque<T> getCars(){
        return cargoHolder.getCars();
    }
}
