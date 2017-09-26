package com.example.alice.blackjack;

import java.util.ArrayList;

/**
 * Created by alice on 26/09/2017.
 */

public class Dealer implements Playable {
    private ArrayList<Card> dealerCards;
//    private Card[] cards;

    public Dealer() {
        this.dealerCards = new ArrayList<>();
    }

    public ArrayList<Card> getCards() {
        return dealerCards;
    }

    public void addCards(Card... cards) {
        for (Card card: cards) {
            dealerCards.add(card);
        }
    }

//    public void addCards (Card...cards) {
//        this.cards.
//    }

    public int checkTotal() {
        int totalCardValue = 0;
        for (Card card : getCards()) {
            totalCardValue += card.getFace().getValue();
        }
        return totalCardValue;
    }

    public String getName() {
        return "Dealer";
    }


}
