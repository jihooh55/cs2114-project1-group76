package battleship;

import student.TestCase;

public class CoordinateTest extends TestCase {
    //~ Fields ................................................................

    private Coordinate coordinate;

    //~Public  Methods ........................................................

    public void setUp() {
        coordinate = new Coordinate(2, 3);
    }


    public void testConstructor() {
        assertEquals(2, coordinate.getX());
        assertEquals(3, coordinate.getY());
    }


    public void testSetX() {
        coordinate.setX(7);
        assertEquals(7, coordinate.getX());
    }


    public void testSetY() {
        coordinate.setY(8);
        assertEquals(8, coordinate.getY());
    }
}
