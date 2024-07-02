package com.berlin.htw.blackjack.game.model;


/**
 * The type Dealer.
 */
public class Dealer implements DealerInterface {
    private HandInterface hand;

    /**
     * Instantiates a new Dealer.
     */
    public Dealer() {
        hand = new Hand();
    }

    @Override
    public HandInterface getHand() {
        return hand;
    }

    @Override
    public void addHiddenCard(Card card) {
        hand.addCard(card);
    }
}
