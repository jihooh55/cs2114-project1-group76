package battleship;
public class Coordinate {
    //~ Fields ................................................................
    private int x = 0;
    private int y = 0;
    //~ Constructors ..........................................................
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //~Public  Methods ........................................................
    
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y ) {
        this.y = y;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    
    
}
