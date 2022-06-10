package SnakeAndLadder.services;

import java.util.Map;
import java.util.List;
import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;
import SnakeAndLadder.models.Snake;
import SnakeAndLadder.models.Ladder;
import SnakeAndLadder.models.Player;
import SnakeAndLadder.models.SnakeAndLadderBoard;


public class SnakeAndLadderService {
    private int boardSize;
    private int noOfDice;
    private int noOfPlayers;
    private SnakeAndLadderBoard board;
    private Queue<Player> players;

    private static final int DEFAULT_DICES = 1;
    private static final int DEFAULT_NO_PLAYERS = 2;
    private static final int DEFAULT_BOARD_SIZE = 100;

    public SnakeAndLadderService(){
        this.noOfDice=DEFAULT_DICES;
        this.boardSize=DEFAULT_BOARD_SIZE;
        this.noOfPlayers=DEFAULT_NO_PLAYERS;
        this.board = new SnakeAndLadderBoard(DEFAULT_BOARD_SIZE);
    }

    public SnakeAndLadderService(int boardSize,int dices,int noOfPlayers){
        this.noOfDice=dices;
        this.boardSize= boardSize;
        this.noOfPlayers=noOfPlayers;
        this.board = new SnakeAndLadderBoard(boardSize);
    }

    public void setSnakes(Map<Integer,Snake> snakes){
        board.setSnakes(snakes);
    }

    public void setLadders(Map<Integer,Ladder> ladders){
        board.setLadders(ladders);
    }

    public void setPlayers(List<Player> players){
        this.players = new LinkedList<>();
        Map<String,Integer> playerPeices = new HashMap<>();

        for(Player player : players){
            this.players.add(player);
            playerPeices.put(player.getId(),0);
        }

        board.setPlayerPecies(playerPeices);
    }

    private int getDiceRollValue(){
        Dice dice = new Dice(noOfDice);
        return dice.roll();
    }

    private void movePlayer(Player player,int position){
        int oldPosition = board.getPlayerCurrPos(player);
        int newPosition = oldPosition+position;

        if(newPosition>boardSize){
            newPosition=oldPosition;
        }else{
            newPosition = getNewPostion(newPosition);
        }

        board.setPalyerPosition(player, newPosition);
        System.out.println("Player "+player.getName()+" Moved from "+oldPosition+" to "+newPosition);
    }

    private int getNewPostion(int position){
        Map<Integer,Ladder> ladders = board.getLadders();
        Map<Integer,Snake> snakes = board.getSnakes();

        if(ladders.containsKey(position)){
            return ladders.get(position).getEndPost();
        }        

        if(snakes.containsKey(position)){
            return snakes.get(position).getEndPost();
        }

        return position;
    }

    private boolean hasPlayerWon(Player player){
        int currPos = board.getPlayerCurrPos(player);
        return currPos == boardSize;
    }

    private boolean isGameCompleted(){
        int currPlayer = players.size();
        return currPlayer < noOfPlayers;
    }

    public void startGame(){
        while(!isGameCompleted()){
            int diceValue = getDiceRollValue();
            Player curr = players.poll();

            movePlayer(curr,diceValue);

            if(hasPlayerWon(curr)){
                System.out.println("Player "+curr.getName()+" has won");
                board.removePlayer(curr);
            }else{
                players.add(curr);
            }
        }
    }    
}
