package com.berlin.htw.blackjack.game.model;

/**
 * The interface Dealer interface.
 */
public interface DealerInterface {
    /**
     * Gets hand.
     *
     * @return the hand
     */
    HandInterface getHand();

    /**
     * Add hidden card.
     *
     * @param card the card
     */
    void addHiddenCard(Card card);

}
