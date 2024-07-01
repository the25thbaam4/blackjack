package com.berlin.htw.blackjack.game.model;

public class Player implements PlayerInterface {
    private Hand hand;
    private int chips;
    private String username;

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
