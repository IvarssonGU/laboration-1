import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{


    ArrayList<BufferedImage> carImages;
    ArrayList<Point> points;

    void moveit(int x, int y, int i){
        points.get(i).x = x;
        points.get(i).y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        carImages = new ArrayList<>();
        points = new ArrayList<>();

        //carImageP = new HashMap<BufferedImage,Point>();
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.lightGray);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            carImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            carImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
            carImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));

            //carImageP.put((ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"))), new Point(0, 0));
            //carImageP.put((ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"))), new Point(0, 100));
            //carImageP.put((ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"))), new Point(0, 200));

            points.add(new Point(0, 0));
            points.add(new Point(0, 100));
            points.add(new Point(0, 200));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < carImages.size(); i++) {
            g.drawImage(carImages.get(i), points.get(i).x, points.get(i).y, null); // see javadoc for more info on the parameters
        }
    }
}
