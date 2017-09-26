package com.example.alice.blackjack;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by alice on 22/09/2017.
 */

public class HiLo implements Game, Serializable {
    Player[] players;
    ArrayList<Card> deck;
    int level;

    public HiLo(int level, Player ...players) {
        this.players = players;
        Log.d("players[] -HiLo cons", this.players.toString());
        deck = new ArrayList<>();
        this.generateDeck();
        this.level = level;
    }

    public void generateDeck() {
        for (CardSuit suit: CardSuit.values()) {
            for (CardFace face : CardFace.values()) {
                deck.add(new Card(suit, face));
            }
        }
    }

    public void deal(Player player) {
        Random random = new Random();
        Card[] cards = new Card[level];
        for (int i = 0; i < level; i++) {
            int choice = random.nextInt(deck.size());
            cards[i] = deck.remove(choice);
        }
        player.setCards(cards);
    }

    public void play(){
        for (Player player : players) {
            deal(player);
        }
    }

    public Player getWinner() {
        int maximum = 0;
        Player winner = null;
        for (int i = 0; i < players.length; i++) {
            int totalCardValue = 0;
            for (Card card : players[i].getCards()) {
                totalCardValue += card.getFace().getValue();
            }
            if (totalCardValue > maximum) {
                maximum = totalCardValue;
                winner = players[i];
            }
        }
        return winner;
    }

    public Player[] getPlayers() {
        return players;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }
}