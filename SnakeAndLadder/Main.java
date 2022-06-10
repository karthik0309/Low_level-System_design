package SnakeAndLadder;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import SnakeAndLadder.models.Ladder;
import SnakeAndLadder.models.Snake;
import SnakeAndLadder.models.Player;
import SnakeAndLadder.services.SnakeAndLadderService;

public class Main{
    public static void main(String args[]){
        int noOfSnakes=0;
        int noOfLadders=0;
        int noOfPlayers=0;
        Scanner scan = new Scanner(System.in);
        Map<Integer,Snake> snakes = new HashMap<>();
        Map<Integer,Ladder> ladders = new HashMap<>();
        List<Player> players = new ArrayList<>();
        SnakeAndLadderService game = new SnakeAndLadderService();        

        System.out.println("Enter no of snakes: ");
        noOfSnakes=scan.nextInt();

        System.out.println("Enter start and end pos of each snake: ");
        for(int i=0;i<noOfSnakes;i++){
            int start = scan.nextInt();
            int end = scan.nextInt();
            snakes.put(start,new Snake(start,end));
        }

        System.out.println("Enter no of Ladders: ");
        noOfLadders=scan.nextInt();

        System.out.println("Enter start and end pos of each ladder: ");
        for(int i=0;i<noOfLadders;i++){
            int start = scan.nextInt();
            int end = scan.nextInt();

            ladders.put(start,new Ladder(start,end));
        }

        System.out.println("Enter no of Players: ");
        noOfPlayers=scan.nextInt();

        System.out.println("Enter player name: ");
        for(int i=0;i<noOfPlayers;i++){
            players.add(new Player(scan.next()));
        }

        scan.close();
        
        game.setPlayers(players);
        game.setLadders(ladders);
        game.setSnakes(snakes);
        
        game.startGame();
    }
}