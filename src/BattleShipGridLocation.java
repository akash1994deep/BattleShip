import enums.BattleShipType;
import enums.ShipStatus;

public class BattleShipGridLocation {
    private boolean isShipPresent;
    private BattleShipType shipType;
    private ShipStatus status;

    public BattleShipGridLocation() {
        isShipPresent = false;
        status = ShipStatus.EMPTY;
    }

    public boolean isShipPresent() {
        return isShipPresent;
    }

    public void setShipPresent(boolean shipPresent) {
        isShipPresent = shipPresent;
    }

    public BattleShipType getShipType() {
        return shipType;
    }

    public void setShipType(BattleShipType shipType) {
        this.shipType = shipType;
    }

    public ShipStatus getStatus() {
        return status;
    }

    public void setStatus(ShipStatus status) {
        this.status = status;
    }
}
