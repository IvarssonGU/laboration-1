/**
 * An interface that forces the following methods to be defined.
 */
public interface Movable extends IPostionable {

    /**
     * A method intended to change object position, and thereby move the Movable object.
     */
    void move();

    /**
     * A method that changes the objects direction to the left.
     */
    void turnLeft();

    /**
     * A method that changes the objects direction to the right.
     */
    void turnRight();

}
