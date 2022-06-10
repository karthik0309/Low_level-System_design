package SnakeAndLadder.models;

public class Position {
    private int start;
    private int end;

    Position(int start,int end){
        this.start=start;
        this.end=end;
    }

    public int getStartPost(){
        return start;
    }

    public int getEndPost(){
        return end;
    }
}
