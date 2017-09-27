package com.example.alice.blackjack;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by alice on 26/09/2017.
 */

public interface Playable {
    void addCards(Card...cards);
    int checkTotal();
    ArrayList<Card> getCards();
}
