package com.berlin.htw.blackjack.game;

import com.berlin.htw.blackjack.game.model.DealerInterface;
import com.berlin.htw.blackjack.game.model.DeckInterface;
import com.berlin.htw.blackjack.game.model.HandInterface;
import com.berlin.htw.blackjack.game.model.PlayerInterface;

public interface BlackJackInterface {
    void startGame();
    void placeBet(int bet);
    void resolveBet();
    boolean isGameOver();
    void startNextRound();
    void playerHit();
    void playerStand();
    boolean isPlayerBust();
    boolean isDealerBust();
    String getResult();
    HandInterface getDealerHand();
    HandInterface getPlayerHand();
    DeckInterface getDeck();
    DealerInterface getDealer();
    PlayerInterface getPlayer();
}
