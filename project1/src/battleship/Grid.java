package battleship;

public class Grid {
    private int[][] grid;
    
    public Grid() {
        grid = new int[10][10];
    }
    
    public boolean placeShip(Battleships ship) {
        for(Coordinate coord : ship.getCoords()) {
            if(grid[coord.getX()][coord.getY()] == 0) {
                return false;
            }
        }
        for(Coordinate coord : ship.getCoords()) {
            grid[coord.getX()][coord.getY()] = 0;
        }
        return true;
    }
    
    public boolean canHit(int x, int y) {
        return (grid[x][y] != 1) && (grid[x][y] != -1);
    }
    
    public boolean checkHit(int x, int y) {
        if(grid[x][y] == 0) {
            grid[x][y] = 1;
            return true;
        }
        grid[x][y] = -1;
        return false;
    }
}
