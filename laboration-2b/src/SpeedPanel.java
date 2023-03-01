import Vehicle.Car;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SpeedPanel extends JPanel implements ModelObserver {
    JPanel tmpTest;
    DrawPanel dp;
    List<Car> cars = new ArrayList<>();

    JLabel bo ;


    public SpeedPanel(DrawPanel dp){
        this.bo = new JLabel();
        tmpTest = new JPanel();
        this.dp = dp;
        initComponents();
        dp.add(tmpTest);
        //tmpTest.add(dp);
    }

    private void initComponents() {


        this.bo.setBounds(600,0,800,800);
        this.tmpTest.setSize(200,300);
        this.tmpTest.setLocation(600,0);
        this.tmpTest.setBackground(Color.yellow);
        this.tmpTest.setLayout(new GridLayout(10,1));
        this.bo.add(tmpTest);
       // this.tmpTest.setPreferredSize(new Dimension((200), 300));

        for (int i = 0; i < 10; i++){
            tmpTest.add(new JLabel(),i);
        }
        //this.tmpTest.add(dp);
    }

    public void actOnModelChange (ArrayList<Car> cars) {
        this.cars = new ArrayList<>(cars);


        //if (cars.size()>)
        for (int i = 0; i < 10; i++) {
            JLabel piss = (JLabel) tmpTest.getComponent(i);

            if (i < cars.size()){
                piss.setText(cars.get(i).getModelName() + " : " + ((Double) cars.get(i).getCurrentSpeed()).toString());
            }
            else{
                piss.setText("");
            }
        }
        repaint();
    }


}
