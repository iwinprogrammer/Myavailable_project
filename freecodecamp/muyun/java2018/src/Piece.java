import java.util.Objects;

public interface Piece {

//    private int value = 0;
//
//    private boolean isNew = true;
//
//
//    public int getValue() {
//        return value;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Piece piece = (Piece) o;
//        return value == piece.value;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(value);
//    }
//
//    public void setValue(int value) {
//        this.value = value;
//    }
//
//    @Override
//    public String toString() {
//        if (value == 0) return "_";
//        if (isNew) {
//            isNew = false;
//            return "*" + value;
//        } else {
//            return String.valueOf(value);
//        }
//    }



    @Override
    public boolean equals(Object o);


    @Override
    public String toString();

    int expend();

    boolean isBank();

    void setBank();

    void init();

}
