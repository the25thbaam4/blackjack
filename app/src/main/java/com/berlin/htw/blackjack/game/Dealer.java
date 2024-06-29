package com.berlin.htw.blackjack.game;



public class Dealer implements DealerInterface{
    private HandInterface hand;

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
