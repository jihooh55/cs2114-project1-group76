package battleship;

import java.util.Random;

public class Computer
    extends Player
{
    private Coordinate[] unknownPoints = new Coordinate[100];
    private int bombsLeft = 100;
    private int[] unusedRows = new int[10];
    private int rowsLeft = 10;
    private Grid board = new Grid();
    private Battleships[] ships = new Battleships[5];

    public Computer()
    {
        super();
        for (int y = 0; y < 10; y++)
        {
            for (int x = 0; x < 10; x++)
            {
                unknownPoints[(y * 10) + x] = new Coordinate(x, y);
            }
        }
        for (int i = 0; i < 10; i++)
        {
            unusedRows[i] = i;
        }
    }


    public boolean place(Battleships ship)
    {
        Random r = new Random();
        int x = r.nextInt(11 - ship.size());
        int i = r.nextInt(rowsLeft);
        int y = unusedRows[i];
        rowsLeft--;
        unusedRows[i] = unusedRows[rowsLeft];
        unusedRows[rowsLeft] = 0;
        return ship.setPosition(x, y);
    }


    public boolean drop(Bomb bomb)
    {
        Random r = new Random();
        int i = r.nextInt(bombsLeft);
        int x = unknownPoints[i].getX(), y = unknownPoints[i].getY();
        bomb.setPosition(x, y);
        bombsLeft--;
        unknownPoints[i] = unknownPoints[bombsLeft];
        unknownPoints[bombsLeft] = null;
        return true;
    }
}
