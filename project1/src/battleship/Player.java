package battleship;

abstract class Player
{
    private Grid board = new Grid();
    private Battleships[] ships = new Battleships[5];

    public Player()
    {
        ships[0] = new Carrier();
        ships[1] = new Battleship();
        ships[2] = new Submarine();
        ships[3] = new Destroyer();
        ships[4] = new Patrol();
    }


    public Grid board()
    {
        return board;
    }


    public Battleships[] ships()
    {
        return ships;
    }


    abstract boolean place(Battleships ship);


    abstract boolean drop(Bomb bomb);
}
