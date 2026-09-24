package battleship;

public class Bomb
{
    private int x = 0;
    private int y = 0;

    public Bomb()
    {
    }


    public void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
    }


    public int getX()
    {
        return x;
    }


    public int getY()
    {
        return y;
    }


//    public boolean move(char input)
//    {
//        switch (input)
//        {
//            case 'w':
//                y++;
//                break;
//            case 'a':
//                x--;
//                break;
//            case 's':
//                y--;
//                break;
//            case 'd':
//                x++;
//                break;
//            default:
//                return false;
//        }
//        return true;
//    }
    
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
            default:
                return false;
        }
        if (checkOOB() == false) {
            System.out.println("You can't bomb out of bounds");
            x = tempx;
            y = tempy;
            return false;
        }
        
        
        return true;
    }


//    public Coordinate[] updateCoordinate()
//    {
//        switch (rotate)
//        {
//            case 1:
//                for (int i = 0; i < size; i++)
//                {
//                    coordinates[i].setX(x + i);
//                    coordinates[i].setY(y);
//                }
//                break;
//            case 2:
//                for (int i = 0; i < size; i++)
//                {
//                    coordinates[i].setX(x);
//                    coordinates[i].setY(y + i);
//                }
//                break;
//            case 3:
//                for (int i = 0; i < size; i++)
//                {
//                    coordinates[i].setX(x - i);
//                    coordinates[i].setY(y);
//                }
//                break;
//            case 4:
//                for (int i = 0; i < size; i++)
//                {
//                    coordinates[i].setX(x);
//                    coordinates[i].setY(y - i);
//                }
//        }
//        return this.coordinates;
//    }


    /**
     * checks out of bound status (OOB)
     * 
     * @return true if IN bound false if OUT OF bound
     */
    private boolean checkOOB()
    {        
        if (this.x < 0 || this.x > 9 || this.y < 0 || this.y > 9) {
            return false;
        }
        return true;
    }
}
