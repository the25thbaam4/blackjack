package com.berlin.htw.blackjack.game;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> deck;

    public Deck (){
        deck = new ArrayList<>();
    }
    public void addCard(Card card) {
        deck.add(card);
    }

    public List<Card> getDeck() {
        return deck;
    }
}
