
package battleship;

public class Battleships
{
    private int x = 0;
    private int y = 0;
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


    public boolean setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
        updateCoordinate();
        return checkOOB();
    }


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
     * @param the
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
// }
        switch (input)
        {
            case 'w':
                y++;
                break;
            case 'a':
                x--;
                break;
            case 's':
                y--;
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
        checkOOB();
        return this.coordinates;
    }


    /**
     * checks out of bound status (OOB)
     * 
     * @return true if IN bound false if OUT OF bound
     */
    private boolean checkOOB()
    {
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
