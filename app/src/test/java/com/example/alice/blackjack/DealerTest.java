package com.example.alice.blackjack;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by alice on 26/09/2017.
 */

public class DealerTest {
    Dealer dealer;
    Card card;
    Card card2;

    @Before
    public void before() {
        dealer = new Dealer();
        card = new Card(CardSuit.DIAMONDS, CardFace.TWO);
        card2 = new Card(CardSuit.CLUBS, CardFace.FIVE);
    }

    @Test
    public void testGetAndSetCards() {
        dealer.setCards(card, card2);
        assertEquals(2, dealer.getCards().length);
        assertEquals(card, dealer.getCards()[0]);
    }

    @Test
    public void testGetTotalValue() {
        dealer.setCards(card, card2);
        assertEquals(7, dealer.checkTotal());
    }
}
