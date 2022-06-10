package TicTacToe.services;

import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;
import TicTacToe.models.Board;
import TicTacToe.models.Player;

public class BoardService {
    private int noOfMoves;
    private int boardSize;
    private Board board;
    private Queue<Player> nextTurn;
    Scanner scan;

    public BoardService(int boardSize,Player players[]){
        noOfMoves=0;
        this.boardSize=boardSize;
        board = new Board(boardSize);
        scan=new Scanner(System.in);
        
        initializeBoard();

        nextTurn = new LinkedList<>();

        for(Player player : players){
            nextTurn.add(player);
        }
    }

    private void initializeBoard(){
        int size = board.getBoardSize();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(i%2==0 && j%2!=0){
                    board.setCharAt(i,j,'|');
                }else if(i%2!=0 && j%2==0){
                    board.setCharAt(i,j,'-');
                }else if(i%2!=0 && j%2!=0){
                    board.setCharAt(i,j,'+');
                }else{
                    board.setCharAt(i,j,' ');
                }
            }
        }

        printBoard();
    }

    private void printBoard(){
        System.out.println();
        int size = board.getBoardSize();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(board.getCharAt(i,j));
            }
            System.out.println();
        }
    }

    private boolean isGameFinished(){
        if(noOfMoves == boardSize*boardSize ){
            System.out.println("Game Drawn");
            return true;
        }
        return false;
    }

    private int[] getInput(Player player){
        System.out.println("Its "+player.getPlayerSymbol()+"'s turn: ");
        int row=scan.nextInt();
        int col=scan.nextInt();
        
        while(true){
            int rowInBoard=row*2;
            int colInBoard=col*2;
            
            if(board.getCharAt(rowInBoard, colInBoard)!=' '){
                System.out.println("Invalid input, cell already taken");
                row = scan.nextInt();
                col = scan.nextInt();
            }else{
                board.setCharAt(rowInBoard,colInBoard,player.getPlayerSymbol());
                printBoard();
                return new int[]{rowInBoard,colInBoard};
            }
        }
    }

    private boolean hasPlayerWon(int row,int col,Player player){
        int noCol=0;
        int noRow=0;
        int diag=0;
        int revDig=0;
        int size = board.getBoardSize();
        char currSymbol = player.getPlayerSymbol();

        for(int i=0;i<size;i+=2){
            if(board.getCharAt(row,i)==currSymbol){
                noRow++;
            }
            if(board.getCharAt(i,col)==currSymbol){
                noCol++;
            }
            if(row==col && board.getCharAt(i,i)==currSymbol){
                diag++;
            }
            if( row+col==boardSize-1 && 
                board.getCharAt(size-1-i,i)==currSymbol){
                noCol++;
            }
        }

        if( noRow==boardSize || 
            noCol==boardSize || 
            diag== boardSize || 
            revDig==boardSize){
                return true;
        }

        return false;
    }

    public void startGame(){
        while(!isGameFinished()){
            Player curr = nextTurn.poll();
            int pos[] = getInput(curr);

            if(hasPlayerWon(pos[0],pos[1],curr)){
                System.out.println("Player "+curr.getName()+" has won");
                break;
            }else{
                nextTurn.add(curr);
                noOfMoves++;
            }
        }
    }
}
