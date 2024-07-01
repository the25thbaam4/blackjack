package com.berlin.htw.blackjack.game.model;

public interface DeckInterface {
    void buildDeck();

    void shuffle();

    Card dealCard();

    boolean isShuffled();
}
