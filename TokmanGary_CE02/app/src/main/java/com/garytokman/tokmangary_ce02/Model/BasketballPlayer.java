package com.garytokman.tokmangary_ce02.Model;

/**
 * Created by gtokman1 on 9/1/16.
 */
public class BasketballPlayer extends Athlete {

    private int mNumberOfThreePointers;

    public BasketballPlayer(String name, String position, int age, int numberOfThreePointers) {
        super(name, position, age);
        mNumberOfThreePointers = numberOfThreePointers;
    }

    @Override
    public String toString() {
        return super.toString() + " Three pointers: " + mNumberOfThreePointers;
    }

    public int getNumberOfThreePointers() {
        return mNumberOfThreePointers;
    }
}
