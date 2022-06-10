package SnakeAndLadder.services;

import java.util.Random;

public class Dice {
    private int noOfDice;

    Dice(int noOfDice){
        this.noOfDice=noOfDice;
    }

    public int roll(){
        int bound=(int)Math.pow(6,noOfDice);
        return new Random().nextInt(bound)+1;
    }
}
