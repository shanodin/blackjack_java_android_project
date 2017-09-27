package com.example.alice.blackjack;

import java.util.ArrayList;

/**
 * Created by alice on 26/09/2017.
 */

public class Dealer implements Playable {
    private ArrayList<Card> dealerCards;
    private Boolean blackjack;

    public Dealer() {
        this.dealerCards = new ArrayList<>();
        this.blackjack = false;
    }

    public Boolean getBlackjack() {
        return blackjack;
    }

    public void setBlackjack(Boolean blackjack) {
        this.blackjack = blackjack;
    }

    public ArrayList<Card> getCards() {
        return dealerCards;
    }

    public void addCards(Card... cards) {
        for (Card card: cards) {
            dealerCards.add(card);
        }
    }

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
