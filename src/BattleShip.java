import enums.BattleShipType;

public class BattleShip {
    private int startRow;
    private int startColumn;
    private int shipWidth;
    private int shipHeight;
    private int length;
    private BattleShipType shipType;

    public BattleShip(BattleShipType shipType, int startRow, int startColumn,
                      int shipWidth, int shipHeight) {
        this.shipType = shipType;
        this.startRow = startRow;
        this.startColumn = startColumn - 1;
        this.shipWidth = shipWidth;
        this.shipHeight = shipHeight;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getStartColumn() {
        return startColumn;
    }

    public void setStartColumn(int startColumn) {
        this.startColumn = startColumn;
    }

    public int getShipWidth() {
        return shipWidth;
    }

    public void setShipWidth(int shipWidth) {
        this.shipWidth = shipWidth;
    }

    public int getShipHeight() {
        return shipHeight;
    }

    public void setShipHeight(int shipHeight) {
        this.shipHeight = shipHeight;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public BattleShipType getShipType() {
        return shipType;
    }

    public void setShipType(BattleShipType shipType) {
        this.shipType = shipType;
    }

    @Override
    public String toString() {
        return "BattleShip{" +
                "startRow=" + startRow +
                ", startColumn=" + startColumn +
                ", shipWidth=" + shipWidth +
                ", shipHeight=" + shipHeight +
                ", length=" + length +
                ", shipType=" + shipType +
                '}';
    }
}
