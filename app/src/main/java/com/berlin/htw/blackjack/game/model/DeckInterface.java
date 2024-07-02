package com.berlin.htw.blackjack.game.model;

/**
 * The interface Deck interface.
 */
public interface DeckInterface {
    /**
     * Build deck.
     */
    void buildDeck();

    /**
     * Shuffle.
     */
    void shuffle();

    /**
     * Deal card card.
     *
     * @return the card
     */
    Card dealCard();

    /**
     * Is shuffled boolean.
     *
     * @return the boolean
     */
    boolean isShuffled();
}
