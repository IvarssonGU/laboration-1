import Vehicle.Car;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public interface ModelObserver {
    void actOnModelChange(ArrayList<Car> newStatus);
}
