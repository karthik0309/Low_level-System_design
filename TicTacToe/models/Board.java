package TicTacToe.models;

public class Board {
    int boardSize;
    char board[][];

    public Board(int boardSize){
        board = new char[(2*boardSize)-1][(2*boardSize)-1];
        this.boardSize=(2*boardSize)-1;
    }

    public int getBoardSize(){
        return boardSize;
    }
    public char getCharAt(int row,int col){
        return board[row][col];
    }

    public void setCharAt(int row,int col,char ch){
        board[row][col]=ch;
    }
}


/*
 * 00 01 02 03 04
 * o|o|o
 * -+-+-
 * x|x|x
 * -+-+-
 * o|o|o
 * 
 * 
 * 00-00
 * 01-02
 * 02-04
 * 10-20
 * 11-22
 * 12-24
 * 
 */
