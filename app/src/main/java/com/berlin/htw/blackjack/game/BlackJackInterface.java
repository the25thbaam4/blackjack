package com.berlin.htw.blackjack.game;

public interface BlackJackInterface {
    void startGame();
    void placeBet(int bet);
    void resolveBet();
    boolean isGameOver();
}
