package com.berlin.htw.blackjack.game;

import static android.content.ContentValues.TAG;

import android.util.Log;

import com.berlin.htw.blackjack.game.model.CardInterface;
import com.berlin.htw.blackjack.game.model.Dealer;
import com.berlin.htw.blackjack.game.model.DealerInterface;
import com.berlin.htw.blackjack.game.model.Deck;
import com.berlin.htw.blackjack.game.model.DeckInterface;
import com.berlin.htw.blackjack.game.model.HandInterface;
import com.berlin.htw.blackjack.game.model.Player;
import com.berlin.htw.blackjack.game.model.PlayerInterface;

public class BlackJackGame implements BlackJackInterface {


    private DeckInterface deck;
    private DealerInterface dealer;
    private PlayerInterface player;
    private CardInterface hiddenCard;
    private int currentBet;

    public BlackJackGame() {

    }


    @Override
    public void startGame() {
        deck = new Deck();
        deck.shuffle();

        dealer = new Dealer();
        player = new Player();

        // Deal initial cards to dealer and player
        dealer.addHiddenCard(deck.dealCard());
        dealer.getHand().addCard(deck.dealCard());

        player.getHand().addCard(deck.dealCard());
        player.getHand().addCard(deck.dealCard());

    }

    @Override
    public void placeBet(int bet) {
        if (bet > player.getChips()) {
            throw new IllegalArgumentException("Bet exceeds available chips");
        }
        currentBet = bet;
        player.decreaseChips(bet);
    }

    @Override
    public void resolveBet() {
        String result = getResult();

        if (result.contains("Player wins")) {
            player.increaseChips(currentBet * 2);
        } else if (result.contains("It's a tie")) {
            player.increaseChips(currentBet);
        } else if(result.contains("Dealer bust! Player wins.")){
            player.increaseChips(currentBet * 2);
        }

        currentBet = 0;
    }

    @Override
    public boolean isGameOver() {
        return player.getChips() <= 0;
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
        resolveBet();
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
