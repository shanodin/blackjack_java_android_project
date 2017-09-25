package com.example.alice.blackjack;

/**
 * Created by alice on 22/09/2017.
 */

public class Card {
    private CardSuit suit;
    private CardFace face;

    public Card(CardSuit suit, CardFace face) {
        this.suit = suit;
        this.face = face;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public CardFace getFace() {
        return face;
    }
}
