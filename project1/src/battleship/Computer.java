package battleship;

import java.util.Random;

public class Computer
{
    private Coordinate[] unknownPoints = new Coordinate[100];
    private int bombsLeft = 100;
    private int[] unusedRows = new int[10];
    private int rowsLeft = 10;
    private Grid board = new Grid();
    private Battleships[] ships = new Battleships[5];
    private int shipsLeft = 5;

    public Computer()
    {

        ships[0] = new Carrier();
        ships[1] = new Battleship();
        ships[2] = new Submarine();
        ships[3] = new Destroyer();
        ships[4] = new Patrol();
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


    /**
     * this computer's own board, where its ships live.
     */
    public Grid board()
    {
        return board;
    }


    /**
     * this computer's fleet.
     */
    public Battleships[] ships()
    {
        return ships;
    }


    /**
     * randomly places a ship onto this computer's own board.
     */
    public boolean place(Battleships ship)
    {
        return place(ship, board);
    }


    public boolean place(Battleships ship, Grid board) {
        Random r = new Random();
        int size = ship.size();
        Coordinate[] testCoords = new Coordinate[size];
        boolean isPlaced = false;

        while (!isPlaced) {
            // Generate ONE starting position and ONE rotation per attempt
            int startX = r.nextInt(10); 
            int startY = r.nextInt(10);
            int rotation = r.nextInt(4) + 1; 

            for (int i = 0; i < size; i++) {
                switch(rotation) {
                    case 1:
                        testCoords[i] = new Coordinate(startX + i, startY);
                        break;
                    case 2:
                        testCoords[i] = new Coordinate(startX, startY + i);
                        break;
                    case 3:
                        testCoords[i] = new Coordinate(startX - i, startY);
                        break;
                    case 4:
                        testCoords[i] = new Coordinate(startX, startY - i);
                        break;
                }
            }
            
            
            if (canPlace(testCoords, board)) {
                isPlaced = true;
                
                Coordinate[] shipCoords = ship.getCoords();
                for (int i = 0; i < size; i++) {
                    shipCoords[i].setX(testCoords[i].getX());
                    shipCoords[i].setY(testCoords[i].getY());
                }
                board.place(ship);
            }
        }
        return true;
    }

    
    public int getShipsLeft() {
        return shipsLeft;
    }
    private boolean canPlace(Coordinate[] coordinates, Grid board) {
        for (int i = 0; i < coordinates.length; i++) {
            int x = coordinates[i].getX();
            int y = coordinates[i].getY();

            // 1. Check Out of Bounds
            if (x < 0 || x > 9 || y < 0 || y > 9) {
                return false;
            }

            if (!board.isFree(x, y)) {
                return false;
            }
        }
        return true;
    }
    
    public void popShip() {
        this.shipsLeft --;
    }
    
    public Battleships getShip() {
        return ships[shipsLeft];
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