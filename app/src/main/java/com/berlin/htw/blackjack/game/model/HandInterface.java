package com.berlin.htw.blackjack.game.model;

import java.util.List;

/**
 * The interface Hand interface.
 */
public interface HandInterface {
    /**
     * Add card.
     *
     * @param card the card
     */
    void addCard(Card card);

    /**
     * Gets cards.
     *
     * @return the cards
     */
    List<Card> getCards();

    /**
     * Calculate sum int.
     *
     * @return the int
     */
    int calculateSum();

    /**
     * Clear cards from hand.
     */
    void clear();
}
