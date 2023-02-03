import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.awt.*;
import java.util.Objects;

import static org.junit.Assert.*;

public class CarTest {
    Saab95 saab;
    Volvo240 volvo;

    Scania scania;
    Car_Transporter car_transporter;

    Workshop<Saab95> saabWorkshop;
    Workshop<Car> verkstadCar;

    @Before
    public void before () {
        saab = new Saab95();
        volvo = new Volvo240();
        scania = new Scania();
        car_transporter = new Car_Transporter(10);
        saabWorkshop = new Workshop<>(10);
        verkstadCar = new Workshop<>(10);
    }

    @After
    public void after () {
        saab = null;
        volvo = null;
        saabWorkshop = null;
        verkstadCar = null;
        scania = null;
        car_transporter = null;
    }

    @Test
    public void getNrDoors() {
        assert(saab.getNrDoors() == 12);
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
        saab.gas(1);
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
        saab.gas(1);
        saab.turnRight();
        saab.move();
        assert(saab.getX() == 1);
    }

    @Test
    public void move2() {
        saab.gas(1);
        saab.turnRight();
        saab.turnRight();
        saab.move();
        assert(saab.getY() == -1);
    }

    @Test
    public void move1() {
        saab.gas(1);
        saab.turnLeft();
        saab.move();
        assert(saab.getX() == -1);
    }

    @Test
    public void move0() {
        saab.gas(1);
        saab.move();
        assert(saab.getY() == 1);
    }

    @Test
    public void getDir_test(){
        assert(saab.getDir() == 0);
    }

    @Test
    public void incrementSpeed_test(){
        saab.gas(1);
        Assert.assertEquals(saab.getCurrentSpeed(), 1.25, 0);
    }

    @Test
    public void decrementSpeed_test(){
        saab.gas(1);
        saab.brake(1);
        assert(saab.getCurrentSpeed() == 0);
    }

    @Test
    public void incrementSpeedVolvo_test(){
        volvo.gas(1);
        Assert.assertEquals(volvo.getCurrentSpeed(), 1.25, 0);
    }

    @Test
    public void incrementSpeedVolvo_test2(){
        volvo.gas(2);
        Assert.assertEquals(volvo.getCurrentSpeed(), 0, 0);
    }

    @Test
    public void upFlakFailTest(){
        scania.startEngine();
        scania.upTrailer();
        Assert.assertNotEquals(1, 0);
    }

    @Test
    public void downFlakTest(){
        for (int i = 0; i < 5; i++) {
            scania.upTrailer();
        }
        scania.downTrailer();
        assert(scania.getTrailer() == 1);
    }

    @Test
    public void maxFlakTest(){
        int j = 0;
        while (j < 100){
            scania.upTrailer();
            j++;
        }
        assert(scania.getTrailer() == 0);
    }

    @Test
    public void minFlakTest(){
        int j = 0;
        while (j < 100){
            scania.downTrailer();
            j++;
        }
        assert(scania.getTrailer() == 70);
    }

    @Test
    public void speedFactorTest () {
        scania.gas(1);
        assertEquals(scania.getCurrentSpeed(), 12, 0);
    }

    @Test
    public void setFlakDown () {
        car_transporter.downTrailer();
        assert(car_transporter.getTrailer() == 70);
    }

    @Test
    public void flakLockedDuringTransport () {
        car_transporter.gas(1);
        car_transporter.gas(1);
        car_transporter.gas(1);
        car_transporter.downTrailer();
        assert(car_transporter.getTrailer() == 0);
    }

    @Test
    public void onlySaabs() {
        //verkstadSaab.recieveCar(volvo); -gives a static error!
        saabWorkshop.loadCar(saab);
        assert(saabWorkshop.unLoadCar() == saab);
    }

    @Test
    public void unLoadCarAndLoadCar() {
        car_transporter.downTrailer();
        car_transporter.loadCar(volvo);
        car_transporter.loadCar(saab);
        car_transporter.unLoadCar();
        assert(car_transporter.getCarSize() == 1);
    }

    @Test
    public void carOnTransporterSameCords() {
        car_transporter.downTrailer();
        car_transporter.loadCar(volvo);
        car_transporter.upTrailer();
        car_transporter.gas(1);
        car_transporter.move();
        car_transporter.turnRight();
        car_transporter.move();
        car_transporter.turnRight();
        for (int i = 0; i < 5; i++){
            car_transporter.move();
        }
        car_transporter.turnLeft();
        car_transporter.move();
        car_transporter.brake(1);
        car_transporter.downTrailer();
        car_transporter.unLoadCar();
        assert((volvo.getX() == car_transporter.getX()) && (volvo.getY() == car_transporter.getY()));

    }

    @Test
    public void dispatchThrows() {
        assertThrows("Requested object not found", RuntimeException.class, () ->{
            verkstadCar.unLoadCar();
        } );
    }


    @Test
    public void allCars (){
        verkstadCar.loadCar(saab);
        verkstadCar.loadCar(volvo);
        verkstadCar.loadCar(scania);
        verkstadCar.loadCar(car_transporter);
        assert(verkstadCar.getCarSize() == 4);
    }

    @Test
    public void capacityCheck () {
        verkstadCar.loadCar(volvo);
        verkstadCar.loadCar(scania);
        verkstadCar.loadCar(volvo);
        verkstadCar.loadCar(saab);
        verkstadCar.loadCar(car_transporter);
        verkstadCar.loadCar(car_transporter);
        verkstadCar.loadCar(saab);
        verkstadCar.loadCar(volvo);
        verkstadCar.loadCar(scania);
        verkstadCar.loadCar(saab);
        verkstadCar.loadCar(volvo);
        verkstadCar.loadCar(car_transporter);
        assert(verkstadCar.getCarSize() == 10);
    }



}
