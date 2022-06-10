package TicTacToe.models;

public class Player {
    private int playerId;
    private String name;
    private char playerSymbol;

    public Player(int id,String name,char playerSymbol){
        this.playerId=id;
        this.name=name;
        this.playerSymbol=playerSymbol;
    }

    public int getId(){
        return playerId;
    }

    public String getName(){
        return name;
    }

    public char getPlayerSymbol(){
        return playerSymbol;
    }
}
