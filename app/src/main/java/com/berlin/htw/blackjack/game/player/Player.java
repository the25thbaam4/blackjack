package com.berlin.htw.blackjack.game.player;

import com.berlin.htw.blackjack.game.Hand;

public class Player {
    private Hand hand;

    public Player() {
        hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }
}
