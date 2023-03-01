import Vehicle.Car;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SpeedPanel extends JPanel implements ModelObserver {
    JPanel tmpTest;
    List<Car> cars = new ArrayList<>();

    public SpeedPanel(int x, int y){
        tmpTest = new JPanel();
        this.setPreferredSize(new Dimension(x, y));
        initComponents();
    }

    private void initComponents() {
        this.setDoubleBuffered(true);
        this.setBackground(Color.yellow);
        this.setLayout(new GridLayout(10,1));

        for (int i = 0; i < 10; i++){
            this.add(new JLabel(),i);
        }
    }

    public void actOnModelChange (ArrayList<Car> cars) {
        this.cars = new ArrayList<>(cars);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 10; i++) {
            JLabel piss = (JLabel) this.getComponent(i);
            if (i < cars.size()){
                piss.setText(cars.get(i).getModelName() + " : " + ((Double) cars.get(i).getCurrentSpeed()).toString());
            } else {
                piss.setText("");
            }
        }
    }

}
