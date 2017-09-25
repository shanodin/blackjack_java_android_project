package com.example.alice.blackjack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by alice on 22/09/2017.
 */

public class HiLoTest {
    HiLo hiLo;
    HiLo bigHiLo;
    Player player1;
    Player player2;

    @Before
    public void before() {
        player1 = new Player("Alice");
        player2 = new Player("Marty");
        hiLo = new HiLo(1, player1, player2);
        bigHiLo = new HiLo(2, player1, player2);
    }

    @Test
    public void testPlayersHasCorrectLength() {
        assertEquals(2, hiLo.getPlayers().length);
    }

    @Test
    public void testGameHas52Cards() {
        assertEquals(52, hiLo.getDeck().size());
    }

    @Test
    public void testDealingRemovesCard() {
        hiLo.deal(player1);
        assertEquals(51, hiLo.getDeck().size());
    }

    @Test
    public void testDealingGivesPlayerCard() {
        hiLo.deal(player1);
        assertNotNull(player1.getCards()[0]);
    }

    @Test
    public void testPlayDealsCardsToPlayers() {
        hiLo.play();
        assertNotEquals(player1.getCards()[0], player2.getCards()[0]);
        assertEquals(50, hiLo.getDeck().size());
    }

    @Test
    public void testWinnerIsPlayerWithHighestCard() {
        player1.setCards(new Card(CardSuit.CLUBS, CardFace.FIVE));
        player2.setCards(new Card(CardSuit.HEARTS, CardFace.THREE));
        assertEquals(player1, hiLo.getWinner());
    }

    @Test
    public void testWinnerIsNotJustFirstPlayer() {
        player1.setCards(new Card(CardSuit.DIAMONDS, CardFace.SIX));
        player2.setCards(new Card(CardSuit.SPADES, CardFace.JACK));
        assertEquals(player2, hiLo.getWinner());
    }

    @Test
    public void testPlayDealsTwoCardsToPlayers() {
        bigHiLo.play();
        assertEquals(48, bigHiLo.getDeck().size());
    }

    @Test
    public void testWinnerIsPlayerWithHighestCards() {
        player1.setCards(
                new Card(CardSuit.CLUBS, CardFace.FIVE),
                new Card(CardSuit.HEARTS, CardFace.FOUR)
        );
        player2.setCards(
                new Card(CardSuit.HEARTS, CardFace.THREE),
                new Card(CardSuit.SPADES, CardFace.JACK)
        );
        assertEquals(player2, bigHiLo.getWinner());
    }
}
