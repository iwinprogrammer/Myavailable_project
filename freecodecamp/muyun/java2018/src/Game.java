import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    int size;
    Piece[][] board;
    long score;

    boolean isOver = false;

    Random random = new Random();



    public Game() {
    }

    public Game(int size) {
        this.size = size;
        board = new Piece[size][size];
    }

    public static Piece giveAPiece() {
//        return new NumPiece();
        return new ShengxiaoPiece();
    }

    public static void main(String[] args) {
        Game game = new Game(4);

        game.play();
        game.print();

//        game.test();
    }

//    public void test() {
//        Piece[] pieces = new Piece[4];
//        for (int i = 0; i < 4; i++) {
//            pieces[i] = giveAPiece();
//        }
//
//        pieces[0].setValue(2);
//        pieces[1].setValue(0);
//        pieces[2].setValue(2);
//        pieces[3].setValue(4);
//
//        printRow(pieces);
//
//        mergeRow(pieces);
//
//        printRow(pieces);
//
//        mergeRow(pieces);
//
//        printRow(pieces);
//    }

    public void printRow(Piece[] pieces) {
        for (int i = 0; i < 4; i++) {
            Piece piece = pieces[i];
            System.out.print(piece + "\t");
        }
        System.out.println();
    }

    public void mergeRow(Piece[] pieces) {
        compressRow(pieces);
        for (int i = 0; i < pieces.length; i++) {
            if ( i < 3) {
                Piece piece = pieces[i];
                Piece rightPiece = pieces[i + 1];

//                if (piece.equals(rightPiece)) {

                if (!piece.isBank() && piece.equals(rightPiece)) {
//                    piece.setValue(piece.getValue() * 2);

//                    score += piece.getValue();
                    score += piece.expend();;
                    rightPiece.setBank();
                    compressRow(pieces);
                }
            }
        }
    }

    public void compressRow(Piece[] pieces) {
        ArrayList<Piece> temp = new ArrayList<>();
        for (int i = 0; i < pieces.length; i++) {
            if (!pieces[i].isBank()) {
                temp.add(pieces[i]);
            }
        }

        for (int i = 0; i < pieces.length; i++) {
            if (temp.size() > i) {
                pieces[i] = temp.get(i);
            } else {
//                pieces[i] = new Piece();
                pieces[i] = giveAPiece();
            }
        }


    }



    /**
     * 开始游戏
     */
    public void play() {

        score = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
//                board[i][j] = new Piece();
                board[i][j] = giveAPiece();
            }
        }

//        for (int i = 0; i < 10; i++) {
//            int x = random.nextInt(10);
//            System.out.println(x);
//        }
        this.randomOnePiece();
        this.randomOnePiece();

        Scanner scanner = new Scanner(System.in);

        while (!isOver) {
            print();
            String key = scanner.next();
            System.out.println(key);
            if (this.directionMarge(key)) {
                this.randomOnePiece();
                System.out.println("当前得分为：" + score);
            } else {
                System.out.println("您只可以输入[a,s,d,w]中的一个字符：");
            }
        }


    }

    /**
     * 响应用户输入
     * @param key
     */
    public boolean directionMarge(String key) {

        //A S D W
        if (key.equals("a")) {// 向左
            for (int i = 0; i < size; i++) {
                Piece[] pieces = board[i];
                mergeRow(pieces);
            }
        } else if (key.equals("d")) {// 向右
            for (int i = 0; i < size; i++) {
                Piece[] pieces = board[i];
                Piece[] nPieces = new Piece[pieces.length];

                for (int j = 0; j < pieces.length; j++) {
                    nPieces[nPieces.length - 1 - j] = pieces[j];
                }
                mergeRow(nPieces);
                for (int j = 0; j < pieces.length; j++) {
                    pieces[j] = nPieces[nPieces.length - 1 - j];
                }
            }
        } else if (key.equals("w")) {// 向上
            for (int i = 0; i < size; i++) {
                Piece[] nPieces = new Piece[size];
                for (int j = 0; j < size; j++) {
                    nPieces[j] = board[j][i];
                }
                mergeRow(nPieces);
                for (int j = 0; j < size; j++) {
                    board[j][i] = nPieces[j];
                }
            }
        } else if (key.equals("s")) {
            for (int i = 0; i < size; i++) {
                Piece[] nPieces = new Piece[size];
                for (int j = 0; j < size; j++) {
                    nPieces[j] = board[size - 1 - j][i];
                }
                mergeRow(nPieces);
                for (int j = 0; j < size; j++) {
                    board[size - 1 - j][i] = nPieces[j];
                }
            }
        } else {
            return false;
        }

        return true;
    }

    public void randomOnePiece() {
        ArrayList<Piece> pieces = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].isBank()) {
                    pieces.add(board[i][j]);
                }
            }
        }

        if (pieces.size() == 0) {
            if (!canMarge()) {
                this.over();
            }
        } else {
            int i = random.nextInt(pieces.size());
            Piece piece = pieces.get(i);
            piece.init();
            int randomInt = random.nextInt(100) + 1;
            if (randomInt > 85) {
                piece.expend();
            }
            if (randomInt > 95) {
                piece.expend();
            }
            if (randomInt > 98) {
                piece.expend();
            }
        }
     }

     public boolean canMarge() {
         for (int i = 0; i < size - 1; i++) {
             for (int j = 0; j < size - 1; j++) {
                 if (board[i][j].equals(board[i][j + 1]) || board[i][j].equals(board[i + 1][j])) {
                     return true;
                 }
             }
         }
         return false;
     }

    /**
     * 游戏结束
     */
    public void over() {
        System.out.println("游戏结束！");
        isOver = true;
    }

    /**
     * 打印棋子
     */
    public void print() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
