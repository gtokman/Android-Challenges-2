package com.garytokman.tokmangary_ce02.Model;

// Gary Guerman Tokman
// JAVA 2 1609
// BasketballPlayer

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

}
