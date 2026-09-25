package battleship;

import student.TestCase;

public class ShipTest extends TestCase {
    //~Public  Methods ........................................................

    public void testShipSizes() {
        assertEquals(5, new Carrier().size());
        assertEquals(4, new Battleship().size());
        assertEquals(3, new Submarine().size());
        assertEquals(3, new Destroyer().size());
        assertEquals(2, new Patrol().size());
    }
}
