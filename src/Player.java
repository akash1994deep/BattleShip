import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<BattleShip> battleShips;
    private BattleShipGrid shipGrid;

    public Player(BattleShipGrid shipGrid) {
        battleShips = new ArrayList<>();
        this.shipGrid = shipGrid;
    }

    public void addBattleShips(BattleShip ship) {
        battleShips.add(ship);
        shipGrid.addBattleShip(ship);
    }

    public List<BattleShip> getBattleShips() {
        return battleShips;
    }

    public void setBattleShips(List<BattleShip> battleShips) {
        this.battleShips = battleShips;
    }

    public BattleShipGrid getShipGrid() {
        return shipGrid;
    }

    public void setShipGrid(BattleShipGrid shipGrid) {
        this.shipGrid = shipGrid;
    }

    public boolean fireMissile(BattleShipGrid shipGrid, int xPos, int yPos) {
        boolean result = false;
        result = shipGrid.fireMissile(shipGrid, xPos, yPos);
        return result;
    }

    public boolean checkForWinner(BattleShipGrid shipGrid) {
        boolean result = false;
        result = shipGrid.checkIfShipsArePresent(shipGrid);
        return result;
    }
}
