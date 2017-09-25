package com.example.alice.blackjack;

import java.io.Serializable;

/**
 * Created by alice on 22/09/2017.
 */

public class Card implements Serializable {
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
