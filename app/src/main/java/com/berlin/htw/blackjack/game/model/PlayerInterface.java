package com.berlin.htw.blackjack.game.model;

public interface PlayerInterface {
    HandInterface getHand ();
    int getChips();
    void increaseChips(int amount);
    void decreaseChips(int amount);


}
