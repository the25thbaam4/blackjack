package com.berlin.htw.blackjack.game.model;

/**
 * The interface Player.
 */
public interface PlayerInterface {
    /**
     * Gets hand.
     *
     * @return the hand
     */
    HandInterface getHand();

    /**
     * Gets chips.
     *
     * @return the chips
     */
    int getChips();

    /**
     * Increase chips.
     *
     * @param amount the amount
     */
    void increaseChips(int amount);

    /**
     * Decrease chips.
     *
     * @param amount the amount
     */
    void decreaseChips(int amount);

    /**
     * Gets username.
     *
     * @return the username
     */
    String getUsername();

    /**
     * Sets username.
     *
     * @param username the username
     */
    void setUsername(String username);

}
