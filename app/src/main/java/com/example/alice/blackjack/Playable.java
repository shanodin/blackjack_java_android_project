package com.example.alice.blackjack;

/**
 * Created by alice on 26/09/2017.
 */

public interface Playable {
    void addCards(Card...cards);
    int checkTotal();
}
