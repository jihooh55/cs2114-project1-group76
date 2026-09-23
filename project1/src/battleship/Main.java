package battleship;

import java.util.Scanner;

/**
 * // -------------------------------------------------------------------------
/**
 *  Where everything will happen
 *  @author Jiho Oh (jihooh)
 *  @version Sep 23, 2026
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grid grid = new Grid();
        boolean placed = false;
        char input;
        
        Player p = new Player();
        while (placed == false) {
            grid.updateGrid(p.ships());
            grid.printGrid();
            System.out.println("Control the ship using w,a,s,d and rotate using r. To change to other ship, press n");
            System.out.println("");
            System.out.print("Current ship is: " );
            switch (p.getCurrentShip())
            {
                case(0):
                    System.out.println("Carrier");
                    break;
                case(1):
                    System.out.println("Battleship");
                    break;
                case(2):
                    System.out.println("Submarine");
                    break;
                case(3):
                    System.out.println("Destroyer");
                    break;
                case(4):
                    System.out.println("Patrol");
                    break;
                default:
                    System.out.println("UNKNOWN SHIP");
                    break;
            }
            input = scanner.next().charAt(0);
            if (!p.ships().move(input)) {
                if (!p.otherShip(input)) {
                    if (input == 'p') {
                        grid.place(p.ships());
                        placed = true;
                    }
                    else {
                        System.out.println("Please input a valid key");
                        System.out.println("Control the ship using w,a,s,d and rotate using r. To change to other ship, press n");
                    }
                }
            } 
        }
        
        
        
    }
    //~ Fields ................................................................

    //~ Constructors ..........................................................

    //~Public  Methods ........................................................

}
