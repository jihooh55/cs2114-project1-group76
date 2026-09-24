package battleship;

public class Grid
{
    private int[][] grid = new int[10][10]; //grid 10 x 10 
    private int hits = 0;

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
     * returns the total number of hits
     */
    public int totalHits()
    {
        return hits;
    }
    
    /**
     * prints the grid. 
     * IMPORTANT!!!!!!!!!!! first [] in grid[][] is the Y POSITION!!!!!!
     * IMPORTANT!!!!!!!!!!! second [] is the X POSTION!!!!
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!! so the coordinates are flipped (y, x)!!!!
     * Don't edit.
     */
    public void printGrid() {
        for (int i = 0; i < 10; i++) {
            System.out.println("-----------------------------------------");
            for (int j = 0; j < 10; j++) {
                switch (grid[i][j])
                {
                    case 0:
                        System.out.print("|   ");
                        break;
                    case -1:
                        System.out.print("| X ");
                        break;
                    case 1:
                        System.out.print("| \u25CF ");
                        break;
                    case 2:
                        System.out.print("| O ");
                }
            }
            System.out.println("|");
        }
        System.out.println("-----------------------------------------");
    }

    /**
     * places the ship in the coordinate. 
     * @param
     *          the ship object you are trying to place
     * @return
     *          true if placed correctly
     */
    public boolean place(Battleships ship)
    {
        for (Coordinate coord : ship.getCoords())
        {
            if (grid[coord.getY()][coord.getX()] == 1) {
                return false;
            }
            grid[coord.getY()][coord.getX()] = 1;
//            if (grid[coord.getX()][coord.getY()] == 10)
//            {
//                return false;
//            }
//        }
//        for (Coordinate coord : ship.getCoords())
//        {
//            grid[coord.getX()][coord.getY()] = 10;
//        }
//        return true;
//    }
        }
        
        return true;
    }
    
    public boolean updateGrid(Battleships ship)
    {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (grid[i][j] == 2) {
                    grid[i][j] = 0;
                }
            }
        }
        ship.updateCoordinate();
        
        for (Coordinate coordNew : ship.getCoords())
        {
            if (grid[coordNew.getY()][coordNew.getX()] != 1) {
                grid[coordNew.getY()][coordNew.getX()] = 2;
            }
//            if (grid[coord.getX()][coord.getY()] == 10)
//            {
//                return false;
//            }
//        }
//        for (Coordinate coord : ship.getCoords())
//        {
//            grid[coord.getX()][coord.getY()] = 10;
//        }
//        return true;
//    }
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
