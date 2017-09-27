package com.example.alice.blackjack;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by alice on 26/09/2017.
 */

public class BlackjackTest {
    Dealer dealer;
    Player player1;
    Blackjack blackjack;

    @Before
    public void before() {
        dealer = new Dealer();
        player1 = new Player("Alice");
        blackjack = new Blackjack(dealer, player1);
    }

    @Test
    public void testParticipants () {
        assertEquals(2, blackjack.getParticipants().size());
    }

    @Test
    public void testGameHas48Cards() {
        assertEquals(52, blackjack.getDeck().size());
    }

    @Test
    public void testPlayerHasTwoCards() {
        blackjack.dealInitial(blackjack.getParticipants());
        assertEquals(2, player1.getCards().size());
        assertEquals(2, dealer.getCards().size());
    }

    @Test
    public void testDealsCardsToPlayers() {
        blackjack.dealInitial(blackjack.getParticipants());
        assertEquals(CardFace.ACE, dealer.getCards().get(0).getFace());
        assertEquals(CardSuit.HEARTS, dealer.getCards().get(0).getSuit());
    }

    @Test
    public void testDealer() {
        assertEquals(dealer, blackjack.getDealer());
    }

    @Test
    public void testPlayers() {
        assertEquals(1, blackjack.getPlayers().length);
    }

    @Test
    public void testCardValues() {
        blackjack.dealInitial(blackjack.getParticipants());
        assertEquals(3, blackjack.cardsCount().get(dealer));
    }


}
