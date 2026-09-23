
package battleship;

public class Battleships
{
    private int x = 4; //initial position of boats are near the center 4
    private int y = 4;
    private int rotate = 1; // 1 flat and right dominant and rotates CC to 4
    private int size;
    private Coordinate[] coordinates;

    /**
     * creates new battleship object
     * 
     * @param size
     *            of the battleship
     */
    public Battleships(int size)
    {
        this.size = size;
        coordinates = new Coordinate[size];
        for (int i = 0; i < size; i++)
        {
            coordinates[i] = new Coordinate(x + i, y);
        }
    }


//    public boolean setPosition(int x, int y)
//    {
//        this.x = x;
//        this.y = y;
//        updateCoordinate();
//        return checkOOB();
//    }


    public Coordinate[] getCoords()
    {
        return coordinates;
    }


    public int size()
    {
        return size;
    }


    /**
     * moves the battleship
     * 
     * @param
     *            user keyboard input in char will determine the action
     * @return returns false if input key is not one of the accepted inputs
     */
    public boolean move(char input)
    {
// boolean accepted = false; //sets
// for (int i = 0; i < acceptedInputs.length; i++) {
// if (input == acceptedInputs[i]) {
// accepted = true;
// }
// }
// if (accepted == false) {
// return false;
// 
        int tempx = x;
        int tempy = y;
        int tempr = rotate;
        
        switch (input)
        {
            case 'w':
                y--;
                break;
            case 'a':
                x--;
                break;
            case 's':
                y++;
                break;
            case 'd':
                x++;
                break;
            case 'r':
                if (rotate >= 4)
                {
                    rotate = 1;
                }
                else
                {
                    rotate++;
                }
                break;
            default:
//                System.out.println("Please input a valid key");
                return false;
        }
        if (checkOOB() == false) {
            System.out.println("You can't place out of bounds");
            x = tempx;
            y = tempy;
            rotate = tempr;
            return false;
        }
        
        
        return true;
    }


    public Coordinate[] updateCoordinate()
    {
        switch (rotate)
        {
            case 1:
                for (int i = 0; i < size; i++)
                {
                    coordinates[i].setX(x + i);
                    coordinates[i].setY(y);
                }
                break;
            case 2:
                for (int i = 0; i < size; i++)
                {
                    coordinates[i].setX(x);
                    coordinates[i].setY(y + i);
                }
                break;
            case 3:
                for (int i = 0; i < size; i++)
                {
                    coordinates[i].setX(x - i);
                    coordinates[i].setY(y);
                }
                break;
            case 4:
                for (int i = 0; i < size; i++)
                {
                    coordinates[i].setX(x);
                    coordinates[i].setY(y - i);
                }
        }
        return this.coordinates;
    }


    /**
     * checks out of bound status (OOB)
     * 
     * @return true if IN bound false if OUT OF bound
     */
    private boolean checkOOB()
    {
        updateCoordinate();
        
        for (Coordinate coord : getCoords()) {
            if (coord.getX() < 0 || coord.getX() > 9 || coord.getY() < 0 || coord.getY() > 9) {
                return false;
            }
        }
        for (int i = 0; i < size; i++)
        {
            if (coordinates[i].getX() < 0 || coordinates[i].getX() > 9)
            {
                return false;
            }
            if (coordinates[i].getY() < 0 || coordinates[i].getY() > 9)
            {
                return false;
            }
        }
        return true;
    }

}
