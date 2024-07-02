package com.berlin.htw.blackjack.game.model;

/**
 * The type Player.
 * with Card in hand and 10 starter chips
 */
public class Player implements PlayerInterface {
    private Hand hand;
    private int chips;
    private String username;

    /**
     * Instantiates a new Player with 10 chips.
     */
    public Player() {
        hand = new Hand();
        chips = 10;
    }

    @Override
    public HandInterface getHand() {
        return hand;
    }

    @Override
    public int getChips() {
        return chips;
    }

    @Override
    public void increaseChips(int amount) {
        this.chips += amount;
    }

    @Override
    public void decreaseChips(int amount) {
        this.chips -= amount;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

}
