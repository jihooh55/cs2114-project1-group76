package battleship;

import student.TestCase;

public class BattleshipsTest extends TestCase {
    //~ Fields ................................................................
    Battleships ship = new Battleships(4);

    //~Public  Methods ........................................................

    public void testConstructor() {
        assertEquals(4, ship.size());
        assertEquals(0, ship.getCoords()[0].getX());
        assertEquals(0, ship.getCoords()[0].getY());
        assertEquals(3, ship.getCoords()[3].getX());
        assertEquals(0, ship.getCoords()[3].getY());
    }


    public void testSetPosition() {
        assertTrue(ship.setPosition(2, 3));
        assertEquals(2, ship.getCoords()[0].getX());
        assertEquals(3, ship.getCoords()[0].getY());
        assertEquals(5, ship.getCoords()[3].getX());
        assertEquals(3, ship.getCoords()[3].getY());
    }


    public void testSetPositionOutOfBounds() {
        assertFalse(ship.setPosition(8, 0));
        assertFalse(ship.setPosition(0, 8));
    }


    public void testMove() {
        assertFalse(ship.move('q'));

        assertTrue(ship.move('w'));
        assertEquals(1, ship.getCoords()[0].getY());

        assertTrue(ship.move('a'));
        assertEquals(-1, ship.getCoords()[0].getX());

        assertTrue(ship.move('s'));
        assertEquals(0, ship.getCoords()[0].getY());

        assertTrue(ship.move('d'));
        assertEquals(0, ship.getCoords()[0].getX());
    }


    public void testRotate() {
        ship.setPosition(5, 5);

        assertTrue(ship.move('r'));
        assertEquals(5, ship.getCoords()[0].getX());
        assertEquals(5, ship.getCoords()[0].getY());
        assertEquals(5, ship.getCoords()[3].getX());
        assertEquals(8, ship.getCoords()[3].getY());

        assertTrue(ship.move('r'));
        assertEquals(2, ship.getCoords()[3].getX());

        assertTrue(ship.move('r'));
        assertEquals(2, ship.getCoords()[3].getY());

        assertTrue(ship.move('r'));
        assertEquals(8, ship.getCoords()[3].getX());
    }
}
