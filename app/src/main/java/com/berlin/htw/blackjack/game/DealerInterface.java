package com.berlin.htw.blackjack.game;

public interface DealerInterface {
    HandInterface getHand();
    void addHiddenCard(Card card);

}
