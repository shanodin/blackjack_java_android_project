package com.example.alice.blackjack;

import java.io.Serializable;

/**
 * Created by alice on 22/09/2017.
 */

public class Player implements Serializable {
    private String name;
    private Card[] cards;

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card... cards) {
        this.cards = cards;
    }
}
