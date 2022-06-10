package TicTacToe;

import java.util.Scanner;

import TicTacToe.models.Player;
import TicTacToe.services.BoardService;

public class Main {
    public static void main(String args[]){
        int boardSize;
        Player players[]=new Player[2];        
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter board size: ");
        boardSize = scan.nextInt();

        System.out.println("Enter players name: ");
        players[0]=new Player(0,scan.next(),'x');
        players[1]=new Player(1,scan.next(),'o');


        BoardService board = new BoardService(boardSize,players);
        board.startGame();
    }
}
