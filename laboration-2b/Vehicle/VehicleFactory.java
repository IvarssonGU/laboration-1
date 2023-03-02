package Vehicle;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public abstract class VehicleFactory {
    public static Car createVolvo240 () {
        return new Volvo240();
    }

    public static Car createSaab95 () {
        return new Saab95();
    }

    public static Car createScania () {
        return new Scania();
    }

    public static Car createCarTransporter (int capacity) {
        return new Car_Transporter(capacity);
    }

    public static ArrayList<Car> createCarList () {
        ArrayList<Car> carList = new ArrayList<>();
        carList.add(createVolvo240());
        carList.add(createSaab95());
        carList.add(createScania());
        carList.get(0).setX(20);
        carList.get(1).setX(120);
        carList.get(2).setX(240);
        return carList;
    }

    public static Car createRandomCar (int width, int height) {
        Car tmp = getRandomCar();

        randomStartPosition(tmp, width, height);
        randomStartDirection(tmp);

        return tmp;
    }

    private static Car getRandomCar() {
        ArrayList<Car> rc = VehicleFactory.createCarList();
        int x = ((int) (Math.random() * 2.9)); // big math
        return rc.get(x);
    }

    private static void randomStartPosition(Car tmp, int width, int height) {
        tmp.setX((int) (Math.random() * width - 100));
        tmp.setY((int) (Math.random() * height - 240));
    }

    private static void randomStartDirection(Car tmp) {
        int randTimesTurned = ((int) (Math.random() * 10));
        for (int i = 0; i < randTimesTurned; i++){
            tmp.turnLeft();

        }
    }

    /* public <T extends Car > copyCar (T car) {
        int x = car.getX();
        int y = car.getY();
        double cs = car.getCurrentSpeed();
        int dir = car.getDir();
        String modelname = car.getModelName();
        if (Objects.equals(modelname, "Volvo240")) {
            return new Car.T(car);
            //return new Volvo240(x, y, cs, dir);
        } else if (Objects.equals(modelname, "Saab95")){
            //return new Saab95(x, y, cs, dir);
        }
    } */

    /*public static Car newMovedCar (Car car) {
        int x = car.getX();
        int y = car.getY();
        if (car.getDir()  == 0) {
            y += (int) car.getCurrentSpeed();
        } else if (car.getDir() == 1) {
            x -= (int) car.getCurrentSpeed();
        } else if (car.getDir()  == 2) {
            y -= (int) car.getCurrentSpeed();
        } else {
            x += (int) car.getCurrentSpeed();
        }
        return new Saab95(x, y, car.getCurrentSpeed(), car.getDir());
    }*/

    public static Volvo240 updatedCar (Volvo240 car) {
        return new Volvo240(car);
    }
}
