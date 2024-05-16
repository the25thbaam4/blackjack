package com.berlin.htw.blackjack.game.dealer;

import com.berlin.htw.blackjack.game.Card;
import com.berlin.htw.blackjack.game.Hand;

public class Dealer {
    private Hand hand;

    public Dealer() {
        hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public void addHiddenCard(Card card) {
        hand.addCard(card);
    }
}
