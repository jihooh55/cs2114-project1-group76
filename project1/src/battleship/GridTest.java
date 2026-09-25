package battleship;

import student.TestCase;

public class GridTest extends TestCase {
    //~ Fields ................................................................

    private Grid grid;
    private Battleships ship;

    //~Public  Methods ........................................................

    public void setUp() {
        grid = new Grid();
        ship = new Battleships(3);
    }


    public void testConstructor() {
        assertEquals(0, grid.totalHits());
    }


    public void testPlace() {
        assertTrue(grid.place(ship));
        assertFalse(grid.place(ship));
    }


    public void testCheckHit() {
        grid.place(ship);

        assertTrue(grid.checkHit(0, 0));
        assertEquals(1, grid.totalHits());
        assertFalse(grid.checkHit(0, 1));
        assertEquals(1, grid.totalHits());
    }


    public void testCanHit() {
        grid.place(ship);

        assertTrue(grid.canHit(5, 5));

        grid.checkHit(0, 0);
        assertFalse(grid.canHit(0, 0));

        grid.checkHit(5, 5);
        assertFalse(grid.canHit(5, 5));
    }
}
