package com.berlin.htw.blackjack.game;

import java.util.ArrayList;
import java.util.List;

public class Hand implements HandInterface   {
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }
    @Override
    public void addCard(Card card) {
        cards.add(card);
    }
    @Override
    public List<Card> getCards() {
        return cards;
    }
    @Override
    public int calculateSum() {
        int sum = 0;
        int aceCount = 0;

        for (Card card : cards) {
            sum += card.getValue();
            if (card.isAce()) {
                aceCount++;
            }
        }

        while (sum > 21 && aceCount > 0) {
            sum -= 10;
            aceCount--;
        }

        return sum;
    }


}
