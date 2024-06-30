package com.berlin.htw.blackjack.game;

public interface DeckInterface {
    void buildDeck();
    void shuffle();
    Card dealCard();
    boolean isShuffled();
}
