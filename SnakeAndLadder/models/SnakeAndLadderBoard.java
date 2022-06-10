package SnakeAndLadder.models;

import java.util.Map;
import java.util.HashMap;

public class SnakeAndLadderBoard {
    private int size;
    private Map<Integer,Snake> snakes;
    private Map<Integer,Ladder> ladders;
    private Map<String,Integer> players;

    public SnakeAndLadderBoard(int size){
        this.size = size;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
        this.players = new HashMap<>();
    }

    public int getSize(){
        return size;
    }
    
    public Map<Integer,Snake> getSnakes(){
        return snakes;
    }

    public void setSnakes(Map<Integer,Snake> snakes){
        this.snakes=snakes;
    }

    public Map<Integer,Ladder> getLadders(){
        return ladders;
    }

    public void setLadders(Map<Integer,Ladder> ladders){
        this.ladders= ladders;
    }

    public Map<String,Integer> getPlayers(){
        return players;
    }

    public void setPlayerPecies(Map<String,Integer> players){
        this.players=players;
    }

    public void removePlayer(Player player){
        players.remove(player.getId());
    }

    public int getPlayerCurrPos(Player player){
        return players.get(player.getId());
    }

    public void setPalyerPosition(Player player,int position){
        players.put(player.getId(),position);
    }
}
