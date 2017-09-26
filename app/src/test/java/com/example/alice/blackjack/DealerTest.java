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
        dealer.addCards(card, card2);
        assertEquals(2, dealer.getCards().size());
    }

    @Test
    public void testGetTotalValue() {
        dealer.addCards(card, card2);
        assertEquals(7, dealer.checkTotal());
    }

    @Test
    public void addCardsOneAtATime() {
        dealer.addCards(card);
        assertEquals(2, dealer.checkTotal());
        dealer.addCards(card2);
        assertEquals(7, dealer.checkTotal());
    }
}
