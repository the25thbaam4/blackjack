package com.berlin.htw.blackjack.game;

public class Player implements PlayerInterface {
    private Hand hand;

    public Player() {
        hand = new Hand();
    }
    @Override

    public HandInterface getHand() {
        return hand;
    }

}
