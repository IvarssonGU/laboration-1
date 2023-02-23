import Vehicle.Car;
import Vehicle.Saab95;
import Vehicle.Scania;
import Vehicle.Volvo240;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel implements ModelObserver {
    ArrayList<Car> cars = new ArrayList<>();
    BufferedImage volvoPic;
    BufferedImage saab95Pic;
    BufferedImage scaniaPic;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.lightGray);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Vehicle.Volvo240.jpg"));

            volvoPic = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saab95Pic = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaPic = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void actOnModelChange (ArrayList<Car> cars) {
        // do stuff based on status. Should this be the update-method?
        this.cars = new ArrayList<>(cars);
        this.repaint();

    }

    // This method is called each time the panel updates/refreshes/repaints itself
         // TODO: Change to suit your needs./*
         @Override
         protected void paintComponent(Graphics g) {
             super.paintComponent(g);
             //for (int i = 0; i < carImages.size(); i++) {
             //    g.drawImage(carImages.get(i), points.get(i).x, points.get(i).y, null); // see javadoc for more info on the parameters
             //}
             for (Car car : this.cars) {
                 switch (car.getModelName()) {
                     case "Vehicle.Volvo240" -> g.drawImage(volvoPic, car.getX(), car.getY(), null);
                     case "Vehicle.Scania R730 Streamline" -> g.drawImage(scaniaPic, car.getX(), car.getY(), null);
                     case "Vehicle.Saab95" -> g.drawImage(saab95Pic, car.getX(), car.getY(), null);
                 }
             }
         }

}
