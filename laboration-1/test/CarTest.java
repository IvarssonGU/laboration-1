import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class CarTest {
    Saab95 saab;
    Volvo240 volvo;

    @Before
    public void before () {
        saab = new Saab95();
        volvo = new Volvo240();
    }

    @After
    public void after () {
        saab = null;
        volvo = null;
    }

    @Test
    public void getNrDoors() {
        assert(saab.getNrDoors() == 2);
    }

    @Test
    public void getcolor(){
        saab.setColor(Color.black);
        assert(saab.getColor().equals(Color.black));
    }

    @Test
    public void turboOff_test () {
        saab.setTurboOff();
        assert(!saab.getTurboOn());
    }

    @Test
    public void turboOn_test () {
        saab.setTurboOn();
        assertTrue(saab.getTurboOn());
    }

    @Test
    public void startEngine() {
        saab.startEngine();
        assert(saab.getCurrentSpeed() == 0.1);
    }

    @Test
    public void engineOff() {
        saab.gas(10.0);
        saab.stopEngine();
        assert(saab.getCurrentSpeed() == 0);
    }

    @Test
    public void turnLeft360 () {
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        assert(saab.getDir() == 0);

    }

    @Test
    public void turnRight360 () {
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        assert(saab.getDir() == 0);
    }

    @Test
    public void move3() {
        saab.gas(10);
        saab.turnRight();
        saab.move();
        assert(saab.getX() == 12);
    }

    @Test
    public void move2() {
        saab.gas(10);
        saab.turnRight();
        saab.turnRight();
        saab.move();
        assert(saab.getY() == -12);
    }

    @Test
    public void move1() {
        saab.gas(10);
        saab.turnLeft();
        saab.move();
        assert(saab.getX() == -12);
    }

    @Test
    public void move0() {
        saab.gas(10);
        saab.move();
        assert(saab.getY() == 12);
    }

    @Test
    public void getDir_test(){
        assert(saab.getDir() == 0);
    }

    @Test
    public void incrementSpeed_test(){
        saab.gas(10);
        assert(saab.getCurrentSpeed() == 12.5);
    }

    @Test
    public void decrementSpeed_test(){
        saab.gas(10);
        saab.brake(100);
        assert(saab.getCurrentSpeed() == 0);
    }

    @Test
    public void incrementSpeedVolvo_test(){
        volvo.gas(10);
        assert(volvo.getCurrentSpeed() == 12.5);
    }
}
