package com.example.alice.blackjack;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by alice on 22/09/2017.
 */

public class Player implements Serializable, Playable {
    private String name;
//    private Card[] cards;
    private ArrayList<Card> playerCards;

    public Player(String name){
        this.name = name;
        this.playerCards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getCards() {
        return playerCards;
    }

    public void addCards(Card... cards) {
        for (Card card: cards) {
            playerCards.add(card);
        }
    }

    public int checkTotal() {
        int totalCardValue = 0;
        for (Card card : getCards()) {
            totalCardValue += card.getFace().getValue();
        }
        return totalCardValue;
    }

}
