package com.berlin.htw.blackjack.game;

import java.util.List;

public interface HandInterface {
    void addCard(Card card);
    List<Card> getCards();
    int calculateSum();

}
