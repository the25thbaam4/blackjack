package com.berlin.htw.blackjack.game;

import static android.content.ContentValues.TAG;

import android.util.Log;

public class BlackJackGame implements BlackJackInterface {


    private DeckInterface deck;
    private DealerInterface dealer;
    private PlayerInterface player;
    private CardInterface hiddenCard;

    public BlackJackGame() {
        dealer = new Dealer();
        player = new Player();
    }


    @Override
    public void startGame() {
        deck = new Deck();
        deck.shuffle();



        // Deal initial cards to dealer and player
        dealer.addHiddenCard(deck.dealCard());
        dealer.getHand().addCard(deck.dealCard());

        player.getHand().addCard(deck.dealCard());
        player.getHand().addCard(deck.dealCard());

    }

    public void playerHit() {
        if (deck != null && player != null) {
            player.getHand().addCard(deck.dealCard());
        } else {
            Log.e(TAG, "deck or player is null, ensure they are properly initialized");
        }
    }
    public void playerStand() {
        while (dealer.getHand().calculateSum() < 17) {
            dealer.getHand().addCard(deck.dealCard());
        }
    }

    public boolean isPlayerBust() {
        return player.getHand().calculateSum() > 21;
    }

    public boolean isDealerBust() {
        return dealer.getHand().calculateSum() > 21;
    }

    public String getResult() {
        int playerSum = player.getHand().calculateSum();
        int dealerSum = dealer.getHand().calculateSum();

        if (playerSum > 21) {
            return "Player bust! Dealer wins.";
        } else if (dealerSum > 21) {
            return "Dealer bust! Player wins.";
        } else if (playerSum > dealerSum) {
            return "Player wins!";
        } else if (dealerSum > playerSum) {
            return "Dealer wins!";
        } else {
            return "It's a tie!";
        }
    }
    public HandInterface getDealerHand(){
        return dealer.getHand();
    }

    public HandInterface getPlayerHand(){
        return player.getHand();
    }
    public DeckInterface getDeck() {
        return deck;
    }

    public DealerInterface getDealer() {
        return dealer;
    }

    public PlayerInterface getPlayer() {
        return player;
    }
}
