import enums.BattleShipType;
import enums.ShipStatus;

public class BattleShipGrid {
    BattleShipGridLocation[][] locations;

    private int rows;
    private int columns;

    public BattleShipGrid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        initializeLocations();
    }

    private void initializeLocations() {
        locations = new BattleShipGridLocation[this.rows][this.columns];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                locations[row][col] = new BattleShipGridLocation();
            }
        }
    }

    public void addBattleShip(BattleShip ship) {
        int row = ship.getStartRow();
        int column = ship.getStartColumn();
        int width = ship.getShipWidth();
        int height = ship.getShipHeight();

//        TODO: add boundary checks - if ship is greater than the battle ground
//        or ship some parts of the ship exceeds the battle ground
//        width will span across the columns
        for (int i = row; i < row + height; i++) {
            for (int j = column; j < column + width; j++) {
                locations[i][j].setShipPresent(true);
                locations[i][j].setShipType(ship.getShipType());

                if (ship.getShipType().equals(BattleShipType.P)) {
                    locations[i][j].setStatus(ShipStatus.WEAK);
                } else if (ship.getShipType().equals(BattleShipType.Q)){
                    locations[i][j].setStatus(ShipStatus.STRONG);
                }
            }
        }
    }

    public boolean fireMissile(BattleShipGrid shipGrid, int xPos, int yPos) {
        boolean result = false;
        if (shipGrid.locations[xPos][yPos].getStatus().equals(ShipStatus.EMPTY)) {
            result = false;
        } else if (shipGrid.locations[xPos][yPos].getStatus().equals(ShipStatus.WEAK)) {
            shipGrid.locations[xPos][yPos].setStatus(ShipStatus.EMPTY);
            result = true;
        } else if (shipGrid.locations[xPos][yPos].getStatus().equals(ShipStatus.STRONG)) {
            shipGrid.locations[xPos][yPos].setStatus(ShipStatus.WEAK);
            result = true;
        }

        return result;
    }

    public boolean checkIfShipsArePresent(BattleShipGrid shipGrid) {
        boolean result = false;
        int row = shipGrid.rows;
        int column = shipGrid.columns;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (!shipGrid.locations[i][j].getStatus().equals(ShipStatus.EMPTY)) {
                    result = true;
                    return result;
                }
            }
        }
        return result;
    }
}
