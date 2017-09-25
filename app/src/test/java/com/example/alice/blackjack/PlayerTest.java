package com.example.alice.blackjack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by alice on 22/09/2017.
 */

public class PlayerTest {
    Player player;
    Card card;

    @Before
    public void before(){
        player = new Player("Marty");
        card = new Card(CardSuit.DIAMONDS, CardFace.TWO);
    }

    @Test
    public void testPlayerName(){
        assertEquals("Marty", player.getName());
    }

    @Test
    public void testSetAndGetCard() {
        player.setCards(card);
        assertEquals(card, player.getCards()[0]);
    }

}
