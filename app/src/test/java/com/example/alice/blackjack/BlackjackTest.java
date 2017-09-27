package com.example.alice.blackjack;

import android.util.Log;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by alice on 26/09/2017.
 */

public class BlackjackTest {
    Dealer dealer;
    Player player1;
    Player player2;
    Player player3;
    Blackjack blackjack;
    Blackjack blackjack2;

    @Before
    public void before() {
        dealer = new Dealer();
        player1 = new Player("Alice");
        player2 = new Player("Marty");
        player3 = new Player("Dan");
        blackjack = new Blackjack(dealer, player1);
        blackjack2 = new Blackjack(dealer, player1, player2, player3);
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
        blackjack.dealCards(2);
        assertEquals(2, player1.getCards().size());
        assertEquals(2, dealer.getCards().size());
    }

    @Test
    public void testDealsCardsToPlayers() {
        blackjack.dealCards(2);
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
        blackjack.dealCards(2);
        assertEquals(13, blackjack.cardsCount().get(dealer));
    }

    @Test
    public void testBlackjackOrBust() {
        player1.addCards(
                new Card(CardSuit.CLUBS, CardFace.ACE),
                new Card(CardSuit.CLUBS, CardFace.KING) );
        dealer.addCards(
                new Card(CardSuit.HEARTS, CardFace.KING),
                new Card(CardSuit.DIAMONDS, CardFace.KING),
                new Card(CardSuit.DIAMONDS, CardFace.EIGHT));
        blackjack.checkForBlackjackOrBust();
        assertEquals(1, blackjack.blackjackParticipants.size());
        assertEquals(1, blackjack.outParticipants.size());
        assertEquals(0, blackjack.getParticipants().size());
    }

    @Test
    public void testMorePlayers() {
        player1.addCards(
                new Card(CardSuit.CLUBS, CardFace.ACE),
                new Card(CardSuit.CLUBS, CardFace.KING) );
        dealer.addCards(
                new Card(CardSuit.HEARTS, CardFace.KING),
                new Card(CardSuit.DIAMONDS, CardFace.KING),
                new Card(CardSuit.DIAMONDS, CardFace.EIGHT));
        player2.addCards(
                new Card(CardSuit.SPADES, CardFace.EIGHT),
                new Card(CardSuit.CLUBS, CardFace.FOUR) );
        player3.addCards(
                new Card(CardSuit.SPADES, CardFace.TWO),
                new Card(CardSuit.DIAMONDS, CardFace.THREE));
        blackjack2.checkForBlackjackOrBust();
        assertEquals(1, blackjack2.blackjackParticipants.size());
        assertEquals(1, blackjack2.outParticipants.size());
        assertEquals(2, blackjack2.getParticipants().size());
    }

    @Test
    public void testPlayerWithAces() {
        player1.addCards(
                new Card(CardSuit.CLUBS, CardFace.ACE),
                new Card(CardSuit.CLUBS, CardFace.KING) );
        dealer.addCards(
                new Card(CardSuit.HEARTS, CardFace.ACE),
                new Card(CardSuit.DIAMONDS, CardFace.KING),
                new Card(CardSuit.DIAMONDS, CardFace.EIGHT));
        blackjack.checkForBlackjackOrBust();
        assertEquals(1, blackjack.getParticipants().size());
    }

    @Test
    public void testTrueBlackjack() {
        player1.addCards(
                new Card(CardSuit.CLUBS, CardFace.ACE),
                new Card(CardSuit.CLUBS, CardFace.KING) );
        dealer.addCards(
                new Card(CardSuit.HEARTS, CardFace.ACE),
                new Card(CardSuit.DIAMONDS, CardFace.FIVE),
                new Card(CardSuit.SPADES, CardFace.FIVE) );
        blackjack.checkForBlackjackOrBust();
        assertTrue(player1.getBlackjack());
        assertFalse(dealer.getBlackjack());
    }

    @Test
    public void testGetWinner() {
        dealer.addCards(
                new Card(CardSuit.HEARTS, CardFace.KING),
                new Card(CardSuit.DIAMONDS, CardFace.KING),
                new Card(CardSuit.DIAMONDS, CardFace.EIGHT));
        player1.addCards(
                new Card(CardSuit.CLUBS, CardFace.ACE),
                new Card(CardSuit.CLUBS, CardFace.KING) );
        player2.addCards(
                new Card(CardSuit.SPADES, CardFace.EIGHT),
                new Card(CardSuit.CLUBS, CardFace.FOUR) );
        player3.addCards(
                new Card(CardSuit.SPADES, CardFace.TWO),
                new Card(CardSuit.DIAMONDS, CardFace.THREE));
        blackjack2.checkForBlackjackOrBust();
        assertEquals(player1, blackjack2.getWinner().get(0));
    }

    @Test
    public void testDifferentWinner() {
        dealer.addCards(
                new Card(CardSuit.HEARTS, CardFace.KING),
                new Card(CardSuit.DIAMONDS, CardFace.KING),
                new Card(CardSuit.DIAMONDS, CardFace.EIGHT));
        player1.addCards(
                new Card(CardSuit.CLUBS, CardFace.ACE),
                new Card(CardSuit.CLUBS, CardFace.TWO) );
        player2.addCards(
                new Card(CardSuit.SPADES, CardFace.EIGHT),
                new Card(CardSuit.CLUBS, CardFace.SEVEN) );
        player3.addCards(
                new Card(CardSuit.SPADES, CardFace.TWO),
                new Card(CardSuit.DIAMONDS, CardFace.THREE));
        blackjack2.checkForBlackjackOrBust();
        assertEquals(player2, blackjack2.getWinner().get(0));
    }

    @Test
    public void testEveryoneBust() {
        dealer.addCards(
                new Card(CardSuit.HEARTS, CardFace.KING),
                new Card(CardSuit.DIAMONDS, CardFace.KING),
                new Card(CardSuit.DIAMONDS, CardFace.EIGHT));
        player1.addCards(
                new Card(CardSuit.CLUBS, CardFace.TEN),
                new Card(CardSuit.HEARTS, CardFace.TEN),
                new Card(CardSuit.CLUBS, CardFace.TWO) );
        player2.addCards(
                new Card(CardSuit.SPADES, CardFace.EIGHT),
                new Card(CardSuit.SPADES, CardFace.EIGHT),
                new Card(CardSuit.CLUBS, CardFace.SEVEN) );
        player3.addCards(
                new Card(CardSuit.SPADES, CardFace.TWO),
                new Card(CardSuit.SPADES, CardFace.EIGHT),
                new Card(CardSuit.SPADES, CardFace.EIGHT),
                new Card(CardSuit.DIAMONDS, CardFace.THREE));
        blackjack2.checkForBlackjackOrBust();
        assertEquals(0, blackjack2.getWinner().size());
    }
}
