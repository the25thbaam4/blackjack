package com.berlin.htw.blackjack.game.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck implements DeckInterface {
    private List<Card> cards;
    private boolean shuffled;

    public Deck() {
        buildDeck();
    }
    @Override

    public void buildDeck() {
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
    @Override
    public void shuffle() {
        Collections.shuffle(cards);
        shuffled = true;
    }
    @Override
    public Card dealCard() {
        if (!cards.isEmpty()) {
            return cards.remove(cards.size() - 1);
        }
        throw new IllegalStateException("No cards left in the deck");
    }
    @Override
    public boolean isShuffled() {
        return shuffled;
    }

}
