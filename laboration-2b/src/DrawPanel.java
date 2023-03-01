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

    //JLabel cs = new JLabel();
    //JFrame css = new JFrame();
    //JPanel tmpTest = new JPanel(); // yes

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        //tmpTest.setLocation(0, 200); //(CarSim.frameWidth - 100, 100);
        //tmpTest.setBackground(Color.yellow);
        //tmpTest.setPreferredSize(new Dimension((100), 200));
        //tmpTest.setLayout(new GridLayout(10,1));

        //this.add(tmpTest); // yes
        //cs = new JLabel("testing testing");
        //JLabel cs2 = new JLabel("testing2 testing2 yeah 2");
        //tmpTest.add(cs, 0); // yes
        //tmpTest.add(cs2, 1); // yes2

        //tmpTest.setVisible(true);


        //cs.setVisible(true);

        //css.add(cs);
        //css.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
        //for (int i = 0; i < cars.size(); i++) {
            //cs = new JLabel(cars.get(i).getModelName() + ": " + cars.get(i).getCurrentSpeed());
        //}
        //cs.setLocation(e);
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.lightGray);
        // Print an error message in case file is not found with a try/catch block
        try {
            volvoPic = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saab95Pic = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaPic = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void actOnModelChange (ArrayList<Car> cars) {
        this.cars = new ArrayList<>(cars);
        this.repaint();
    }

    // This method is called each time the panel updates/refreshes/repaints itself
     // TODO: Change to suit your needs./*
     @Override
     protected void paintComponent(Graphics g) {
         super.paintComponent(g);
         for (Car car : this.cars) {
             switch (car.getModelName()) {
                 case "Volvo240" -> g.drawImage(volvoPic, car.getX(), car.getY(), null);
                 case "Scania R730" -> g.drawImage(scaniaPic, car.getX(), car.getY(), null);
                 case "Saab95" -> g.drawImage(saab95Pic, car.getX(), car.getY(), null);
             }


             //cs = new JLabel(car.getModelName() + ": ");
             //t


         }
     }

}
