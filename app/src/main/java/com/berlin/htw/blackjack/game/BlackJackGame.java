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

        if (result.contains(getPlayer().getUsername() + " wins")) {
            player.increaseChips(currentBet * 2);
        } else if (result.contains("It's a tie")) {
            player.increaseChips(currentBet);
        } else if (result.contains("Dealer bust! "+ getPlayer().getUsername() + " wins.")) {
            player.increaseChips(currentBet * 2);
        }

        currentBet = 0;
    }

    @Override
    public void startNextRound() {
        dealer.getHand().clear();
        player.getHand().clear();
        currentBet = 0;

        dealer.addHiddenCard(deck.dealCard());
        dealer.getHand().addCard(deck.dealCard());

        player.getHand().addCard(deck.dealCard());
        player.getHand().addCard(deck.dealCard());
        resolveBet();

    }

    @Override
    public boolean isGameOver() {
        return player.getChips() <= 0;
    }

    @Override
    public void playerHit() {
        if (deck != null && player != null) {
            player.getHand().addCard(deck.dealCard());
        } else {
            Log.e(TAG, "deck or player is null");
        }
        resolveBet();
    }

    @Override
    public void playerStand() {
        while (dealer.getHand().calculateSum() < 17) {
            dealer.getHand().addCard(deck.dealCard());
        }
        resolveBet();
    }

    @Override
    public boolean isPlayerBust() {
        return player.getHand().calculateSum() > 21;
    }

    @Override
    public boolean isDealerBust() {
        return dealer.getHand().calculateSum() > 21;
    }

    @Override
    public String getResult() {
        int playerSum = player.getHand().calculateSum();
        int dealerSum = dealer.getHand().calculateSum();

        if (playerSum > 21) {
            return getPlayer().getUsername() + " bust! Dealer wins.";
        } else if (dealerSum > 21) {
            return "Dealer bust! " + getPlayer().getUsername() + " wins.";
        } else if (playerSum > dealerSum) {
            return getPlayer().getUsername() + " wins!";
        } else if (dealerSum > playerSum) {
            return "Dealer wins!";
        } else {
            return "It's a tie!";
        }
    }

    @Override
    public HandInterface getDealerHand() {
        return dealer.getHand();
    }

    @Override
    public HandInterface getPlayerHand() {
        return player.getHand();
    }

    @Override
    public DeckInterface getDeck() {
        return deck;
    }

    @Override
    public DealerInterface getDealer() {
        return dealer;
    }

    @Override
    public PlayerInterface getPlayer() {
        return player;
    }


}
