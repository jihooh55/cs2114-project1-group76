package battleship;

import java.util.Scanner;

/**
 * Where everything will happen
 * @author Jiho Oh (jihooh)
 * @version Sep 25, 2026
 */
public class Main {

    /**
     * the main method
     * @param args
     *          args
     */
    public static void main(String[] args) {
        Computer cpu = new Computer();
        Score score = new Score();
        Grid playerGrid = new Grid();       // player's own ships here. computer bombs this
        Grid computerGrid = cpu.board();    // computer's ships here. player bombs this
        Bomb playerBomb = new Bomb();
        Player p = new Player();
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        char input;

        // ----- SET UP player places ships ----------------------------------------
        while (p.getShipsLeft() > 0) {
            playerGrid.updateGrid(p.ships());
            playerGrid.printGrid();
            System.out.println("Control the ship using w,a,s,d and rotate using r.");
            System.out.println("Press p to place it, or n to switch to the next ship.");
            System.out.println("Current ship: " + shipName(p.getCurrentShip())
                + " (size " + p.ships().size() + ")");

            input = scanner.next().charAt(0);
            if (!p.ships().move(input)) {
                if (!p.otherShip(input)) {
                    if (input == 'p') {
                        if (playerGrid.place(p.ships())) {
                            p.pop(p.getCurrentShip());
                        }
                        else {
                            System.out.println("You can't place ships on top of each other");
                        }
                    }
                    else {
                        System.out.println("Please input a valid key");
                    }
                }
            }
        }
        playerGrid.printGrid();
        System.out.println("Your ships are set!");

        // ----- SET UP computer places ships ------------------------------------------------
        while (cpu.getShipsLeft() > 0) {
            cpu.popShip();
            cpu.place(cpu.getShip());
        }
        System.out.println("Computer has placed its ships. Game start!");

        // ----- MAIN LOOP ----------------------------------------------------------------
        score.setTurn(1);
        while (computerGrid.totalHits() < 17 && playerGrid.totalHits() < 17) {
            if (score.getTurn() == 1) {
                computerGrid.updateGrid(playerBomb);
                computerGrid.printGridMasked();
                System.out.println("Your turn! Move the crosshair with w,a,s,d, fire with p.");

                input = scanner.next().charAt(0);
                if (!playerBomb.move(input)) {
                    if (input == 'p') {
                        if (!computerGrid.canHit(playerBomb.getX(), playerBomb.getY())) {
                            System.out.println("You've already bombed that spot. Pick another.");
                        }
                        else {
                            boolean hit = computerGrid.checkHit(
                                playerBomb.getX(), playerBomb.getY());
                            System.out.println(hit ? "Hit!" : "Miss!");
                            if (hit) {
                                score.recordHit(true);
                            }
                            score.setTurn(2);
                        }
                    }
                    else {
                        System.out.println("Please input a valid key");
                    }
                }
            }
            else {
                Bomb computerBomb = new Bomb();
                cpu.drop(computerBomb);
                boolean hit = playerGrid.checkHit(computerBomb.getX(), computerBomb.getY());
                System.out.println("Computer bombed (" + computerBomb.getX() + ", "
                    + computerBomb.getY() + ") - " + (hit ? "Hit!" : "Miss!"));
                if (hit) {
                    score.recordHit(false);
                }
                playerGrid.printGrid();
                score.setTurn(1);
            }
        }

        if (computerGrid.totalHits() >= 17) {
            System.out.println("You win!");
        }
        else {
            System.out.println("Computer wins!");
        }
        System.out.println("Final tally - your hits: " + score.getPlayerHits()
            + ", computer's hits: " + score.getComputerHits());
    }


    private static String shipName(int index) {
        switch (index) {
            case 0:
                return "Carrier";
            case 1:
                return "Battleship";
            case 2:
                return "Submarine";
            case 3:
                return "Destroyer";
            case 4:
                return "Patrol";
            default:
                return "Unknown ship";
        }
    }
}