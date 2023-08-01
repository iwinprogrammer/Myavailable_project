public class NumPiece implements Piece {

    private int value = 0;
    private boolean isNew = true;

    @Override
    public String toString() {
        if (value == 0) return "_";
        if (isNew) {
            isNew = false;
            return "*" + value;
        } else {
            return String.valueOf(value);
        }
    }

    @Override
    public int expend() {
        value = value * 2;
        return value;
    }

    @Override
    public boolean isBank() {
        return value == 0;
    }

    @Override
    public void setBank() {
        this.value = 0;
    }

    @Override
    public void init() {
        this.value = 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumPiece piece = (NumPiece) o;
        return value == piece.value;
    }
}
