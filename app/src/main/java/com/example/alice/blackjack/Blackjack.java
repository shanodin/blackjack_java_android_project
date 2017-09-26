package com.example.alice.blackjack;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by alice on 26/09/2017.
 */

public class Blackjack implements Game, Serializable {
    Dealer dealer;
    ArrayList<Playable> participants;
    Player[] players;
    ArrayList<Card> deck;

    public Blackjack (Dealer dealer, Player... players) {
        this.participants = new ArrayList<>();
        this.participants.add(dealer);
        this.players = players;
//        this.participants.add(players);
        deck = new ArrayList<>();
        this.generateDeck();
        this.addPlayers();
        this.dealInitial(participants);
    }

    public Dealer getDealer() {
        return dealer;
    }

    public ArrayList<Playable> getParticipants() {
        return participants;
    }

    public Player[] getPlayers() {
        return players;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void generateDeck() {
        for (CardSuit suit: CardSuit.values()) {
            for (CardFace face : CardFace.values()) {
                deck.add(new Card(suit, face));
            }
        }
    }

    public void addPlayers() {
        for (Player player : this.players) {
            this.participants.add(player);
        }
    }

    public void dealInitial (ArrayList<Playable> participants) {
        Random random = new Random();
        for (Playable player : participants) {
            Card[] cards = new Card[2];
            for (int i = 0; i < 2; i++) {
                int choice = random.nextInt(deck.size());
                Card card = deck.remove(choice);
                cards[i] = card;
            }
            player.addCards(cards);
        }
    }

//    public void dealInitial(ArrayList<Playable> participants) {
//        Random random = new Random();
//        ArrayList<Card> cards = new ArrayList<>();
//        for (Playable participant : participants) {
//            int choice = random.nextInt(deck.size());
//
//        }
//    }






    public Playable getWinner () {
        return participants.get(0);
    }





}
