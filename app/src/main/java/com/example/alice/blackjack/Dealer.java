package com.example.alice.blackjack;

/**
 * Created by alice on 26/09/2017.
 */

public class Dealer {
    private Card[] cards;

    public Dealer() {
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card... cards) {
        this.cards = cards;
    }

    public int checkTotal() {
        int totalCardValue = 0;
        for (Card card : getCards()) {
            totalCardValue += card.getFace().getValue();
        }
        return totalCardValue;
    }

}
