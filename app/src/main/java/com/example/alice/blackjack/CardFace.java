package com.example.alice.blackjack;

/**
 * Created by alice on 22/09/2017.
 */

public enum CardFace {
    ACE(11),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10);

    private int value;

    CardFace(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
