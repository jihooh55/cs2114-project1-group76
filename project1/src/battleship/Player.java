package battleship;

public class Player
{
    private Grid board = new Grid();
    private Battleships[] ships = new Battleships[5];
    private int currentShip = 0;

    public Player()
    {
        ships[0] = new Carrier();
        ships[1] = new Battleship();
        ships[2] = new Submarine();
        ships[3] = new Destroyer();
        ships[4] = new Patrol();
    }

    public boolean otherShip(char input) {
        if (input == 'n') {
            currentShip ++;
            if (currentShip > 4) {
                currentShip = 0;
            }
            return true;
        }
        return false;
    }
    public Grid board()
    {
        return board;
    }


    public Battleships ships()
    {
        return ships[currentShip];
    }
    
    public int getCurrentShip() {
        return currentShip;
    }

//
//    abstract boolean place(Battleships ship);
//
//
//    abstract boolean drop(Bomb bomb);
}
