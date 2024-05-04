package com.berlin.htw.blackjack.game;

import java.util.Collections;

public class BlackJackGame {

    private Deck deck = new Deck();

    public BlackJackGame() {

    }

    public void startGame() {
        buildDeck();
        //shuffleDeck();
        printDeck();
    }

    public void buildDeck() {

        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] types = {"C", "D", "H", "S"};

        for (int i = 0; i < types.length; i++) {
            for (int j = 0; j < values.length; j++) {
                Card card = new Card(values[j], types[i]);
                deck.addCard(card);
            }
        }

    }

    public void printDeck() {
        int count = 0;
        System.out.println("Deck:");

        for (Card card : deck.getDeck()) {
            System.out.print(card);
            count++;
            if (count % 13 == 0) {
                System.out.println();
            }
        }
    }
    public void shuffleDeck(){
        Collections.shuffle(deck.getDeck());
        System.out.println(deck);
    }
}
