package com.example.alice.blackjack;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alice on 26/09/2017.
 */

public class Blackjack implements Game, Serializable {
    Dealer dealer;
    ArrayList<Playable> participants;
    Player[] players;
    ArrayList<Card> deck;
    HashMap<Playable, Integer> cardValues;
    ArrayList<Playable> outParticipants;
    ArrayList<Playable> blackjackParticipants;

    public Blackjack (Dealer dealer, Player... players) {
        this.dealer = dealer;
        this.participants = new ArrayList<>();
        // add dealer to participants
        this.participants.add(dealer);
        this.players = players;
        // add player to participants
        this.addPlayers();
        // make the deck
        deck = new ArrayList<>();
        this.generateDeck();
        // can't deal in the initialize because the deck needs shuffling
//        this.dealInitial(participants);
    }

    // dealer getter
    public Dealer getDealer() {
        return dealer;
    }

    // participant getter
    public ArrayList<Playable> getParticipants() {
        return participants;
    }

    // player getter
    public Player[] getPlayers() {
        return players;
    }

    // deck getter
    public ArrayList<Card> getDeck() {
        return deck;
    }

    // generate the deck
    public void generateDeck() {
        for (CardSuit suit: CardSuit.values()) {
            for (CardFace face : CardFace.values()) {
                deck.add(new Card(suit, face));
            }
        }
    }

    // shuffle the deck
    public void shuffleDeck(){
        Collections.shuffle( this.deck );
    }

    // make the players into participants
    public void addPlayers() {
        //
        for (Player player : this.players) {
            this.participants.add(player);
        }
    }

//    // defunct - made single deal method
//    // deals out in order unless you shuffle first
//    public void dealInitial (ArrayList<Playable> participants) {
////        Random random = new Random();
//        for (Playable player : participants) {
//            Card[] cards = new Card[2];
//            for (int i = 0; i < 2; i++) {
////                int choice = random.nextInt(deck.size());
//                Card card = deck.remove(0);
//                cards[i] = card;
//            }
//            player.addCards(cards);
//        }
//    }

    // make a hashmap of participants and their card values
    public HashMap cardsCount () {
        HashMap cardValues = new HashMap<>();
        for (Playable player : this.participants) {
            Integer total = player.checkTotal();
            cardValues.put(player, total);
        }
        return cardValues;
    }

    // separate players with a blackjack or who are bust
    // refactored into separate methods which are brought together here
    public void checkForBlackjackOrBust () {
        this.checkForBlackjack();
        this.checkForBust();
    }

    public void checkForBlackjack() {
        this.blackjackParticipants = new ArrayList<>();
        HashMap<Playable, Integer> cardValues =  this.cardsCount();
        for (Map.Entry<Playable, Integer> entry : cardValues.entrySet()) {
            if (entry.getValue() == 21) {
                Playable player = entry.getKey();
                if (player.getCards().size() == 2) {
                    player.setBlackjack(true);
                }
                blackjackParticipants.add(entry.getKey());
                int index = this.participants.indexOf(entry.getKey());
                this.participants.remove(index);
            }
        }
    }

    public void checkForBust() {
        this.outParticipants = new ArrayList<>();
        HashMap<Playable, Integer> cardValues =  this.cardsCount();
        for (Map.Entry<Playable, Integer> entry : cardValues.entrySet()) {
            if (entry.getValue() > 21) {
                Playable player = entry.getKey();
                int aces = 0;
                for (Card card : player.getCards() ){
                    if (card.getFace() .equals(CardFace.ACE)) {
                        aces++;
                    }
                }
                int adjustedScore = entry.getValue() - (aces * 10);
                if(adjustedScore > 21) {
                    outParticipants.add(entry.getKey());
                    int index = this.participants.indexOf(entry.getKey());
                    this.participants.remove(index);
                }
            }
        }
    }

    // deal cards from the 'top' of the deck - not random unless shuffled
    public void dealCards(int cardsToDeal) {
        for (Playable player : this.participants) {
            Card[] cards = new Card[cardsToDeal];
            for (int i = 0; i < cardsToDeal; i++) {
                Card card = deck.remove(0);
                cards[i] = card;
            }
            player.addCards(cards);
        }
    }

    public void dealToOne(Playable participant){
        Card card = deck.remove(0);
        participant.addCards(card);
    }


    // get a winner by hook or by crook
//    public ArrayList<Playable> getWinner () {
//        ArrayList<Playable> winners = new ArrayList<>();
//        if (this.blackjackParticipants.size() > 0 ) {
//            for (Playable player : this.blackjackParticipants) {
//                if (player.getBlackjack() == true) {
//                    winners.add(player);
//                }
//            }
//        }
////            if (winners.size() > 0) {
////                return winners;
////            }
//        else {
//            int highScore = 0;
//            Playable winner = null;
//            for (Playable player : this.participants) {
//                Integer score = new Integer(player.checkTotal());
//                if (score > highScore) {
//                    highScore = score;
////                    winner = player;
//                }
////              winners.add(winner)
//            }
//            for (Playable player : this.participants) {
//                if (player.checkTotal() >= highScore) {
//                    winners.add(player);
//                }
//            }
//                if (winners.size() > 0 ) {
////                return winners;
//            }
//        }
//        return winners;
//    }


    public void setupGame () {
        // shuffle
        this.shuffleDeck();
        // deal 2 start cards
        this.dealCards(2);
    }

//    public ArrayList<Playable> gameRound() {
//        // check scores
//        this.cardsCount();
//        // sort out bust/blackjack
//        this.checkForBlackjackOrBust();
//        // check any players remain
//        if (this.getParticipants().size() == 0) {
//            getWinner();
//        }
//        // something something pass
////        if (String "someCondition" .equals(false);{
////            return getWinner();
////        }
//        // deal cards to in players
//        this.dealCards(1);
//        return null;
//    }

    public ArrayList<Playable> getWinner() {
        int dealerScore = this.dealer.checkTotal();
        ArrayList<Playable> winners = new ArrayList<>();
        if (this.dealer.getBlackjack() == true) {
            winners.add(dealer);
            return winners;
        }
        if (outParticipants.contains(dealer)){
            winners.addAll(blackjackParticipants);
            winners.addAll(participants);
            return winners;
        }
        for (Playable player : participants) {
            int playerScore = player.checkTotal();
            if (playerScore > dealerScore) {
                winners.add(player);
            }
            if (winners.size() == 0){
                winners.add(dealer);
            }
            return winners;
        }
        return winners;
    }


}
