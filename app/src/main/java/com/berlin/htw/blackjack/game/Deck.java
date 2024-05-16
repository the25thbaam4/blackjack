package com.berlin.htw.blackjack.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards;
    private Random random;

    public Deck() {
        buildDeck();
        random = new Random();
    }

    private void buildDeck() {
        cards = new ArrayList<>();
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] types = {"C", "D", "H", "S"};

        for (String type : types) {
            for (String value : values) {
                Card card = new Card(value, type);
                cards.add(card);
            }
        }
    }

    public void shuffle() {
        for (int i = 0; i < cards.size(); i++) {
            int j = random.nextInt(cards.size());
            Card currCard = cards.get(i);
            Card randomCard = cards.get(j);
            cards.set(i, randomCard);
            cards.set(j, currCard);
        }
    }

    public Card dealCard() {
        if (!cards.isEmpty()) {
            return cards.remove(cards.size() - 1);
        }
        return null;
    }
}
