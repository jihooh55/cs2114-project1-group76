package battleship;

public class Game
{
    private Computer player1;
    private Grid board1;
    private Computer player2;
    private Grid board2;
    private int turn = 0;

    public Game(Computer p1, Computer p2)
    {
        player1 = p1;
        board1 = p1.board();
        player2 = p2;
        board2 = p2.board();
    }


    public void start()
    {
        for (Battleships ship : player1.ships())
        {
            player1.place(ship, board1);
        }
        for (Battleships ship : player2.ships())
        {
            player2.place(ship, board2);
        }
        turn = 1;
        // game continues until either player gets hit 17 times (i.e. all their
        // ships are sunk and they lose)
        while ((board1.totalHits() < 17) && (board2.totalHits() < 17))
        {
            Bomb bomb1 = new Bomb();
            player1.drop(bomb1);
            board2.checkHit(bomb1.getX(), bomb1.getY());
            turn++;

            Bomb bomb2 = new Bomb();
            player2.drop(bomb2);
            board1.checkHit(bomb2.getX(), bomb2.getY());
            turn++;
        }
        if (board1.totalHits() > 16)
        {
            System.out.println("player 2 wins!");
        }
        else
        {
            System.out.println("player 1 wins!");
        }
    }
}