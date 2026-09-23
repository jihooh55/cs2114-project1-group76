package battleship;

import student.TestCase;

public class ScoreTest extends TestCase
{
    //~ Fields ................................................................
    private Score score;

    //~Public  Methods ........................................................
    public void setUp()
    {
        score = new Score();
    }


    public void testConstructor()
    {
        assertEquals(0, score.getTurn());
        assertEquals(0, score.getPlayerHits());
        assertEquals(0, score.getComputerHits());
        assertEquals(0, score.getPlayerShipsSunk());
        assertEquals(0, score.getComputerShipsSunk());
        assertFalse(score.isGameOver());
    }


    public void testSetTurn()
    {
        score.setTurn(1);
        assertEquals(1, score.getTurn());
    }


    public void testNextTurnFromSetup()
    {
        score.nextTurn();
        assertEquals(1, score.getTurn());
    }


    public void testNextTurnFromPlayer()
    {
        score.setTurn(1);
        score.nextTurn();
        assertEquals(2, score.getTurn());
    }


    public void testNextTurnFromComputer()
    {
        score.setTurn(2);
        score.nextTurn();
        assertEquals(1, score.getTurn());
    }


    public void testRecordHitPlayer()
    {
        score.recordHit(true);
        assertEquals(1, score.getPlayerHits());
        assertEquals(0, score.getComputerHits());
    }


    public void testRecordHitComputer()
    {
        score.recordHit(false);
        assertEquals(1, score.getComputerHits());
        assertEquals(0, score.getPlayerHits());
    }


    public void testRecordShipSunkByPlayer()
    {
        score.recordShipSunk(true);
        assertEquals(1, score.getComputerShipsSunk());
        assertEquals(0, score.getPlayerShipsSunk());
    }


    public void testRecordShipSunkByComputer()
    {
        score.recordShipSunk(false);
        assertEquals(1, score.getPlayerShipsSunk());
        assertEquals(0, score.getComputerShipsSunk());
    }


    public void testIsGameOver()
    {
        for (int i = 0; i < 4; i++)
        {
            score.recordShipSunk(false);
        }
        assertFalse(score.isGameOver());

        score.recordShipSunk(false);
        assertTrue(score.isGameOver());
    }
}