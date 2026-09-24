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
        Grid grid = new Grid();
        Player p = new Player();
        Scanner scanner = new Scanner(System.in);
        boolean setUp = true;
        char input;
        
        while (p.getShipsLeft() > 0) {
            grid.updateGrid(p.ships());
            grid.printGrid();
            System.out.println("Control the ship using w,a,s,d and rotate using r. To change to other ship, press n");
            System.out.println("");
            System.out.print("Current ship is: " );
//            switch (p.getCurrentShip())
//            {
//                case(0):
//                    System.out.println("Carrier");
//                    break;
//                case(1):
//                    System.out.println("Battleship");
//                    break;
//                case(2):
//                    System.out.println("Submarine");
//                    break;
//                case(3):
//                    System.out.println("Destroyer");
//                    break;
//                case(4):
//                    System.out.println("Patrol");
//                    break;
//                default:
//                    System.out.println("UNKNOWN SHIP");
//                    break;
//            }
            input = scanner.next().charAt(0);
            if (!p.ships().move(input)) {
                if (!p.otherShip(input)) {
                    if (input == 'p') {
                        if (grid.place(p.ships()) == true) {
                            p.pop(p.getCurrentShip());
                        }
                        else {
                            System.out.println("You can't place ships on top of each other");
                        }
                    }
                    else {
                        System.out.println("Please input a valid key");
                        System.out.println("Control the ship using w,a,s,d and rotate using r. To change to other ship, press n");
                    }
                }
            } 
        }
        grid.printGrid();
        System.out.println("set up done!");
        
        
        
    }
    //~ Fields ................................................................

    //~ Constructors ..........................................................

    //~Public  Methods ........................................................

}
