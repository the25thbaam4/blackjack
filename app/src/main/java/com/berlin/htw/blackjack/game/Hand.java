package com.berlin.htw.blackjack.game;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

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
