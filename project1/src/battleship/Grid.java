package battleship;

// -------------------------------------------------------------------------
/**
 *  Creates a grid class that can be used for user/computer grid
 * 
 *  @author jiho oh (jihooh)
 *  @version Sep 25, 2026
 */
public class Grid
{
    private int[][] grid = new int[10][10]; //grid 10 x 10 
    private int hits = 0;
    // 
    private boolean[][] cursor = new boolean[10][10];

    /**
     * default constructor for grid class. Initially occupies all indexes '0'
     */
    public Grid()
    {
        for (int i = 0; i < 10; i ++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = 0;
            }
        }
    }

    /**
     * @return 
     *          the total number of hits
     */
    public int totalHits()
    {
        return hits;
    }

    /**
     * prints the grid, revealing everything (including unhit ships). Use
     * this for a player's own board.
     * IMPORTANT!!!!!!!!!!! first [] in grid[][] is the Y POSITION!!!!!!
     * IMPORTANT!!!!!!!!!!! second [] is the X POSTION!!!!
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!! so the coordinates are flipped (y, x)!!!!
     * Don't edit.
     */
    public void printGrid() {
        for (int i = 0; i < 10; i++) {
            System.out.println("-----------------------------------------");
            for (int j = 0; j < 10; j++) {
                if (cursor[i][j]) {
                    System.out.print("| O ");
                }
                else {
                    switch (grid[i][j])
                    {
                        case -1:
                            System.out.print("| X ");
                            break;
                        case 1:
                            System.out.print("| \u25CF ");
                            break;
                        case 3:
                            System.out.print("| @ ");
                            break;
                        default:
                            System.out.print("|   ");
                    }
                }
            }
            System.out.println("|");
        }
        System.out.println("-----------------------------------------");
    }

    /**
     * prints the grid the way an opponent should see it: unhit ships stay
     * hidden, only hits, misses, and the crosshair are shown.
     */
    public void printGridMasked() {
        for (int i = 0; i < 10; i++) {
            System.out.println("-----------------------------------------");
            for (int j = 0; j < 10; j++) {
                if (cursor[i][j]) {
                    System.out.print("| O ");
                }
                else {
                    switch (grid[i][j])
                    {
                        case -1:
                            System.out.print("| X ");
                            break;
                        case 3:
                            System.out.print("| \u25CF ");
                            break;
                        default:
                            System.out.print("|   ");
                    }
                }
            }
            System.out.println("|");
        }
        System.out.println("-----------------------------------------");
    }

    /**
     * places the ship, but only if every cell it needs is free. Nothing is
     * written unless the whole ship fits.
     *
     * @param ship
     *          the ship object you are trying to place
     * @return
     *          true if placed correctly
     */
    public boolean place(Battleships ship)
    {
        for (Coordinate coord : ship.getCoords())
        {
            if (grid[coord.getY()][coord.getX()] == 1)
            {
                return false;
            }
        }
        for (Coordinate coord : ship.getCoords())
        {
            grid[coord.getY()][coord.getX()] = 1;
        }
        clearCursor();
        return true;
    }

    /**
     * @param x
     *          x position you are checking
     * @param y
     *          y position you are checking
     * @return
     *          true if unoccupied, false otherwise
     */
    public boolean isFree(int x, int y)
    {
        return grid[y][x] == 0;
    }


    /**
     * Place a description of your method here.
     * @param ship
     *          the battleships object you are trying to update the grid with by placing
     * @return
     *          true in every cases
     */
    public boolean updateGrid(Battleships ship)
    {
        clearCursor();
        ship.updateCoordinate();

        for (Coordinate coordNew : ship.getCoords())
        {
            cursor[coordNew.getY()][coordNew.getX()] = true;
        }
        return true;
    }

    /**
     * shows where a bomb's crosshair currently sits without disturbing
     * anything else on the grid.
     * @param bomb
     *          the dropped bomb the grid is updating
     * @return
     *          true in every case
     */
    public boolean updateGrid(Bomb bomb)
    {
        clearCursor();
        cursor[bomb.getY()][bomb.getX()] = true;
        return true;
    }


    /**
     * clears every crosshair cell from the previous position.
     */
    private void clearCursor()
    {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cursor[i][j] = false;
            }
        }
    }

    /**
     * @param x
     *          x postion you are trying to bomb
     * @param y
     *          y position you are trying to bomb
     * @return
     *          true if (x, y) has not already been set as a hit or a miss. An
     *          unhit ship still counts as a valid target.
     */
    public boolean canHit(int x, int y)
    {
        return (grid[y][x] != -1) && (grid[y][x] != 3);
    }


    /**
     * @param x
     *          x position the bomb had been dropped
     * @param y
     *          y position the bomb had been dropped
     * @return
     *          sets a bomb dropped at (x, y). Returns true on a hit, false on a
     *          miss or if that cell was already set previously.
     */
    public boolean checkHit(int x, int y)
    {
        if (grid[y][x] == 1)
        {
            grid[y][x] = 3;
            hits++;
            return true;
        }
        if (grid[y][x] == -1 || grid[y][x] == 3)
        {
            return false;
        }
        grid[y][x] = -1;
        return false;
    }
}