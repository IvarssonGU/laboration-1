import Vehicle.Car;
import Vehicle.ImmutableCar;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public interface ModelObserver {
    void actOnModelChange(ArrayList<ImmutableCar> newStatus);
}
