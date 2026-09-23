package battleship;

import student.TestCase;

public class BombTest extends TestCase
{
    //~ Fields ................................................................
    private Bomb bomb;
    private Grid grid;

    //~Public  Methods ........................................................
    public void setUp()
    {
        bomb = new Bomb();
        bomb.setPosition(5, 5);
        grid = new Grid();
    }


    public void testConstructor()
    {
        assertEquals(5, bomb.getX());
        assertEquals(5, bomb.getY());
    }


    public void testSetPosition()
    {
        bomb.setPosition(2, 7);
        assertEquals(2, bomb.getX());
        assertEquals(7, bomb.getY());
    }


    public void testMoveUp()
    {
        assertTrue(bomb.move('w'));
        assertEquals(6, bomb.getY());
        assertEquals(5, bomb.getX());
    }


    public void testMoveDown()
    {
        assertTrue(bomb.move('s'));
        assertEquals(4, bomb.getY());
        assertEquals(5, bomb.getX());
    }


    public void testMoveLeft()
    {
        assertTrue(bomb.move('a'));
        assertEquals(4, bomb.getX());
        assertEquals(5, bomb.getY());
    }


    public void testMoveRight()
    {
        assertTrue(bomb.move('d'));
        assertEquals(6, bomb.getX());
        assertEquals(5, bomb.getY());
    }


    public void testMoveInvalidInput()
    {
        assertFalse(bomb.move('q'));
        assertEquals(5, bomb.getX());
        assertEquals(5, bomb.getY());
    }


    public void testFireOnOpenLocation()
    {
        assertTrue(grid.canHit(bomb.getX(), bomb.getY()));
    }


    public void testFireOnAlreadyBombedLocation()
    {
        grid.checkHit(bomb.getX(), bomb.getY());
        assertFalse(grid.canHit(bomb.getX(), bomb.getY()));
    }
}