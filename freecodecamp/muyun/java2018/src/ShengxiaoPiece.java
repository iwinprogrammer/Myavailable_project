public class ShengxiaoPiece implements Piece {

    private int cycle = 0;
    private String[] shengXiao = new String[]{
        "鼠","牛","虎","兔","龙","蛇","马","羊","猴","鸡","狗","猪"
    };

    private int index = -1;
    private boolean isNew = true;

    @Override
    public String toString() {
        if (index == -1) return "_";
        if (isNew) {
            isNew = false;
            return "*" + shengXiao[index];
        } else {
            return shengXiao[index];
        }
    }

    @Override
    public int expend() {
        index ++;
        if (index > 11) {
            index = 0;
        }
        return cycle * 12 + index;
    }

    @Override
    public boolean isBank() {
        return index == -1;
    }

    @Override
    public void setBank() {
        this.index = -1;
    }

    @Override
    public void init() {
        this.index = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        ShengxiaoPiece b = (ShengxiaoPiece) o;
        return this.index == b.index;
    }
}
