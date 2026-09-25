package battleship;
 
// -------------------------------------------------------------------------
/**
 *  score class to keep track of the game progres and other variables
 *  
 *  @author Jiho Oh
 *  @version Sep 25, 2026
 */
public class Score
{
    //~ Fields ................................................................
    private int turn = 0; // 0: setup, 1: player, 2: computer
 
    private int playerHits = 0;
    private int computerHits = 0;
 
    private int playerShipsSunk = 0; // ships the computer has sunk
    private int computerShipsSunk = 0; // ships the player has sunk
 
    private static final int TOTAL_SHIPS = 5;
 
    // ----------------------------------------------------------
    /**
     * Create a new Score object.
     */
    //~ Constructors ..........................................................
    public Score()
    {
        this.turn = 0;
    }
 
 
    //~Public  Methods ........................................................
    // ----------------------------------------------------------
    /**
     * @return
     *          return the current turn
     */
    public int getTurn()
    {
        return turn;
    }
 
    /**
     * @param newTurn
     *          sets the turn to integer passed
     *          
     */
    public void setTurn(int newTurn)
    {
        this.turn = newTurn;
    }
 
 
    /**
     * advances the turn: setup -> player -> computer -> player -> ...
     */
    public void nextTurn()
    {
        if (turn == 0)
        {
            turn = 1;
        }
        else if (turn == 1)
        {
            turn = 2;
        }
        else
        {
            turn = 1;
        }
    }
 
 
    /**
     * records a landed hit for the attacking side
     *
     * @param isPlayerAttacking
     *            true if the player is attacking, false if the computer is
     */
    public void recordHit(boolean isPlayerAttacking)
    {
        if (isPlayerAttacking)
        {
            playerHits++;
        }
        else
        {
            computerHits++;
        }
    }
 
 
    /**
     * records a ship being sunk
     *
     * @param attackerIsPlayer
     *            true if the player sank the ship, false if the computer did
     */
    public void recordShipSunk(boolean attackerIsPlayer)
    {
        if (attackerIsPlayer)
        {
            computerShipsSunk++;
        }
        else
        {
            playerShipsSunk++;
        }
    }
 
 
    /**
     * @return
     *          number of hits
     */
    public int getPlayerHits()
    {
        return playerHits;
    }
 
 
    public int getComputerHits()
    {
        return computerHits;
    }
 
 
    public int getPlayerShipsSunk()
    {
        return playerShipsSunk;
    }
 
 
    public int getComputerShipsSunk()
    {
        return computerShipsSunk;
    }
 
 
    public boolean isGameOver()
    {
        return playerShipsSunk >= TOTAL_SHIPS || computerShipsSunk >= TOTAL_SHIPS;
    }
}
 