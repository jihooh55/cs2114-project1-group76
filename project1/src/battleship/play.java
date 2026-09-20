package battleship;

public class play
{
    public static void main(String[] args)
    {
        Computer c1 = new Computer();
        Computer c2 = new Computer();
        Game game = new Game(c1, c2);
        game.start();
    }
}
