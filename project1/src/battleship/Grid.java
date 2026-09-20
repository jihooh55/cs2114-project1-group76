package battleship;

public class Grid
{
    private int[][] grid = new int[10][10];
    private int hits = 0;

    public Grid()
    {
    }


    public int totalHits()
    {
        return hits;
    }


    public boolean place(Battleships ship)
    {
        for (Coordinate coord : ship.getCoords())
        {
            if (grid[coord.getX()][coord.getY()] == 10)
            {
                return false;
            }
        }
        for (Coordinate coord : ship.getCoords())
        {
            grid[coord.getX()][coord.getY()] = 10;
        }
        return true;
    }


    public boolean canHit(int x, int y)
    {
        return (grid[x][y] != 1) && (grid[x][y] != -1);
    }


    public boolean checkHit(int x, int y)
    {
        if (grid[x][y] == 10)
        {
            grid[x][y] = 1;
            hits++;
            return true;
        }
        grid[x][y] = -1;
        return false;
    }
}
