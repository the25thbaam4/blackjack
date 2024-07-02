package com.berlin.htw.blackjack.game.model;

/**
 * The interface Card interface.
 */
public interface CardInterface {
    /**
     * Gets value.
     *
     * @return the value
     */
    int getValue();

    /**
     * Gets type.
     *
     * @return the type
     */
    String getType();

    /**
     * Is ace boolean.
     *
     * @return the boolean
     */
    boolean isAce();

}
