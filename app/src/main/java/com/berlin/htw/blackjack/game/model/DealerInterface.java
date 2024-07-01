package com.berlin.htw.blackjack.game.model;

public interface DealerInterface {
    HandInterface getHand();

    void addHiddenCard(Card card);

}
