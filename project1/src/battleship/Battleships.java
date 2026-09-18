
package battleship;
public class Battleships {
    //~ Fields ................................................................
    private int x = 0;
    private int y = 0;
    private int rotate = 1; //1 flat and right dominant and rotates CC to 4
    private int size = 0;
    private char[] acceptedInputs = {'w','a','s','d','r'}; //might not need
    private Coordinate[] coordinates;
    
    //~ Constructors ..........................................................
    /**
     * creates new battleship object
     * @param
     *          size of the battleship
     */
    public Battleships(int size) {
        this.size = size;
        this.x = 0;
        this.y = 0;
        this.rotate = 0;
        coordinates = new Coordinate[size];
        for (int i = 0; i < size; i++) {
            coordinates[i] = new Coordinate(x+i,y);
        }
    }
    
    //~Public  Methods ........................................................
    /**
     * moves the battleship
     * 
     * @param
     *          the user keyboard input in char will determine the action
     * @return
     *          returns false if input key is not one of the accepted inputs
     */
    public boolean move(char input) {
//        boolean accepted = false; //sets 
//        for (int i = 0; i < acceptedInputs.length; i++) {
//            if (input == acceptedInputs[i]) {
//                accepted = true;
//            }
//        }
//        if (accepted == false) {
//            return false;
//        }
        
        switch (input) {
            case 'w':
                y ++;
                break;
            case 'a':
                x --;
                break;
            case 's':
                y --;
                break;
            case 'd':
                x ++;
                break;
            case 'r':
                if (rotate >= 4) {
                    rotate = 1;
                }
                else {
                    rotate ++;
                }
                break;
            default:
                return false;
        }
        return true;
    }
    public Coordinate[] updateCoordinate() {
        if (size % 2 == 0) { //if size is even, meaning there's no center point
            switch (rotate) {
                case 1:
                    for (int i = 0; i < size; i++) {
                        coordinates[i].setX(x+i);
                    }
                case 2:
                    for (int i = 0; i < size; i++) {
                        coordinates[i].setY(y+i);
                    }       
                case 3:
                    for (int i = 0; i < size; i++) {
                        coordinates[i].setX(x-i);
                    }
                case 4:
                    for (int i = 0; i < size; i++) {
                        coordinates[i].setY(y-i);
                    }   
            }
        }
        checkOOB();
        return this.coordinates;
    }
    
    /**
     * checks out of bound status (OOB)
     * 
     * @return 
     *          true if IN bound
     *          false if OUT OF bound
     */
    private boolean checkOOB() {
        for (int i = 0; i < size; i++) {
            if (coordinates[i].getX() < 0 || coordinates[i].getX() > 10) {
                return false;
            }
            if (coordinates[i].getY() < 0 || coordinates[i].getY() > 10) {
                return false;
            }
        }
        return true;
    }

}
