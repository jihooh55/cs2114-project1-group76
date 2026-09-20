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


    public boolean move(char input)
    {
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
            default:
                return false;
        }
        return true;
    }
}
