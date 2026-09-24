package battleship;

/**
 * // -------------------------------------------------------------------------
/**
 *  Player class that controls the set up in Main class. User controls this to place ships.
 * 
 *  @author Group 76
 *  @version Sep 23, 2026
 */
public class Player {
//    private Grid board = new Grid();
    private Battleships[] ships = new Battleships[5];
    private int currentShip = 0;
    private int shipsLeft = 5;

    /**
     * default constructor of Player object. Occupies all indexes of ships array with all 5 kinds of Battleships
     */
    public Player() {
        ships[0] = new Carrier();
        ships[1] = new Battleship();
        ships[2] = new Submarine();
        ships[3] = new Destroyer();
        ships[4] = new Patrol();
    }

    /**
     * cycles through the list of possible Battleships the user can place
     * @param input
     *          the input user sends via scanner in Main class
     * @return
     *          return true if char of 'n' is inputted, false if input is anything else
     */
    public boolean otherShip(char input) {
        if (input == 'n') {
            currentShip++;
            if (currentShip > 4) {
                currentShip = 0;
            }
            return true;
        }
        return false;
    }


//    public Grid board() {
//        return board;
//    }

    /**
     * call Battleship methods on the ship the user is trying to place
     * @return
     *          the Battleship object the user is trying to place
     */
    public Battleships ships() {
        return ships[currentShip];
    }

    /**
     * returns the index value in the ships array
     * @return
     *          index of the ship user is trying to place
     */
    public int getCurrentShip() {
        return currentShip;
    }


    /**
     * refreshes the ships array with all the remaining ships by popping the
     * placed ship's index off of ships array.
     * @param currentShipIndex 
     *          the index of the placed ship
     */
    public void pop(int currentShipIndex) {
        Battleships[] newShip = new Battleships[ships.length - 1];
        int newShipIndex = 0;
        for (int i = 0; i < ships.length; i++) {
            if (i != currentShipIndex) {
                newShip[newShipIndex] = ships[i];
                newShipIndex++;
            }
        }
        newShipIndex = 0;
        currentShip = 0;
        shipsLeft --;
        ships = newShip;
    }
    
    /**
     * returns the number of ships left in the array
     * @return
     *          number of ships left
     */
    public int getShipsLeft() {
        return shipsLeft;
    }

//
// abstract boolean place(Battleships ship);
//
//
// abstract boolean drop(Bomb bomb);
}
