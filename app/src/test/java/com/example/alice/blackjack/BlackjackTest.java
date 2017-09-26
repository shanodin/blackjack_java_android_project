package com.example.alice.blackjack;

import org.junit.Assert;
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
    public void testGameHas42Cards() {
        // when initialized blackjack deals out 2 cards per participant
        assertEquals(48, blackjack.getDeck().size());
    }

    @Test
    public void testPlayerHasTwoCards() {
        assertEquals(2, player1.getCards().size());
    }
}
