package battleship;

import student.TestCase;

public class BattleshipsTest extends TestCase {
    //~ Fields ................................................................
    Battleships ship = new Carrier();
    //~ Constructors ..........................................................
    
    //~Public  Methods ........................................................
    public void testMove() {
        assertFalse(ship.move('q'));
        assertTrue(ship.move('w'));
    }
    
}
