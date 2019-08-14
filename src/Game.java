import enums.BattleShipType;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter area boundaries: ");
        int column = input.nextInt();
        String row = input.next();

        BattleShipGrid shipGrid1 = new BattleShipGrid(
                Integer.parseInt(String.valueOf(row.charAt(0) - 'A')) + 1, column);
        BattleShipGrid shipGrid2 = new BattleShipGrid(
                Integer.parseInt(String.valueOf(row.charAt(0) - 'A')) + 1, column);

        Player player1 = new Player(shipGrid1);
        Player player2 = new Player(shipGrid2);

        // TODO: number of ships - change n if number of ships has to be changed
        int n = 2;
        int i = 0;
        while (++i <= n) {
            System.out.println("Type for battleship " + i + ": ");
            String battleShipType = input.next();

            System.out.println("Dimension for battleship " + i + ": ");
            int shipWidth = input.nextInt();
            int shipHeight = input.nextInt();

            System.out.println("Location of battleship " + i + " for player A: ");
            String shipOneLocation = input.next();

            System.out.println("Location of battleship " + i + " for player B: ");
            String shipTwoLocation = input.next();

            BattleShip battleShip1 = new BattleShip(BattleShipType.valueOf(battleShipType),
                    Integer.parseInt(String.valueOf(shipOneLocation.charAt(0) - 'A')),
                    Integer.parseInt(String.valueOf(shipOneLocation.charAt(1))),
                    shipWidth, shipHeight);
            player1.addBattleShips(battleShip1);

            BattleShip battleShip2 = new BattleShip(BattleShipType.valueOf(battleShipType),
                    Integer.parseInt(String.valueOf(shipTwoLocation.charAt(0) - 'A')),
                    Integer.parseInt(String.valueOf(shipTwoLocation.charAt(1))),
                    shipWidth, shipHeight);
            player2.addBattleShips(battleShip2);
        }

        input.nextLine();
        System.out.println("Missile targets for player A: ");
        String playerOneMissile = input.nextLine();
        String[] playerOneMissiles = playerOneMissile.split(" ");

        System.out.println("Missile targets for player B: ");
        String playerTwoMissile = input.nextLine();
        String[] playerTwoMissiles = playerTwoMissile.split(" ");

        System.out.println();

//        Start the game
        startGame(player1, playerOneMissiles, player2, playerTwoMissiles);
    }

    private static void startGame(Player player1, String[] playerOneMissiles, Player player2, String[] playerTwoMissiles) {
        int playerOneMissilesLength = playerOneMissiles.length;
        int playerTwoMissilesLength = playerTwoMissiles.length;
        int x = 0, y = 0;
        boolean areShipsPresent;
        while (true) {
            areShipsPresent = false;

//            Start with Player 1
            if (x >= playerOneMissilesLength) {
                System.out.println("Player-1 has no more missiles left");
            } else {
                while (x < playerOneMissilesLength) {
                    if (!player1.fireMissile(player2.getShipGrid(),
                            Integer.parseInt(String.valueOf(playerOneMissiles[x].charAt(0) - 'A')),
                            Integer.parseInt(String.valueOf(playerOneMissiles[x].charAt(1) - '0')) - 1)) {
                        System.out.println("Player-1 fires a missile with target " + playerOneMissiles[x] + " which missed");
                        ++x;
                        break;
                    }
                    System.out.println("Player-1 fires a missile with target " + playerOneMissiles[x] + " which hit");
                    ++x;

                    areShipsPresent = player1.checkForWinner(player2.getShipGrid());
                    if (!areShipsPresent) {
                        break;
                    }
                }
            }

            areShipsPresent = player1.checkForWinner(player2.getShipGrid());

            if (!areShipsPresent) {
                System.out.println("Player-1 won the battle");
                break;
            }

//            Player 2 turn
            if (y >= playerTwoMissilesLength) {
                System.out.println("Player-2 has no more missiles left");
            } else {
                while (y < playerTwoMissilesLength) {
                    if (!player2.fireMissile(player1.getShipGrid(),
                            Integer.parseInt(String.valueOf(playerTwoMissiles[y].charAt(0) - 'A')),
                            Integer.parseInt(String.valueOf(playerTwoMissiles[y].charAt(1) - '0')) - 1)) {
                        System.out.println("Player-2 fires a missile with target " + playerTwoMissiles[y] + " which missed");
                        ++y;
                        break;
                    }

                    System.out.println("Player-2 fires a missile with target " + playerTwoMissiles[y] + " which hit");
                    ++y;

                    areShipsPresent = player2.checkForWinner(player1.getShipGrid());
                    if (!areShipsPresent) {
                        break;
                    }
                }
            }

            areShipsPresent = player2.checkForWinner(player1.getShipGrid());

            if (!areShipsPresent) {
                System.out.println("Player-2 won the battle");
                break;
            }

//            If both players missiles have been used, match is drawn
            if (x >= playerOneMissilesLength && y >= playerTwoMissilesLength) {
                System.out.println("Match is drawn. Players declare peace");
                break;
            }
        }
    }
}
