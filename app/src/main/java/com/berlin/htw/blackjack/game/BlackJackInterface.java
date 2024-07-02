package com.berlin.htw.blackjack.game;

import com.berlin.htw.blackjack.game.model.DealerInterface;
import com.berlin.htw.blackjack.game.model.DeckInterface;
import com.berlin.htw.blackjack.game.model.HandInterface;
import com.berlin.htw.blackjack.game.model.PlayerInterface;

/**
 * The Black jack interface.
 */
public interface BlackJackInterface {
    /**
     * Start game.
     */
    void startGame();

    /**
     * Place bet.
     *
     * @param bet the bet
     */
    void placeBet(int bet);

    /**
     * Resolve bet.
     */
    void resolveBet();

    /**
     * Is game over boolean.
     *
     * @return the boolean
     */
    boolean isGameOver();

    /**
     * Start next round.
     */
    void startNextRound();

    /**
     * Player hit.
     */
    void playerHit();

    /**
     * Player stand.
     */
    void playerStand();

    /**
     * Is player bust boolean.
     *
     * @return the boolean
     */
    boolean isPlayerBust();

    /**
     * Is dealer bust boolean.
     *
     * @return the boolean
     */
    boolean isDealerBust();

    /**
     * Gets result.
     *
     * @return the result
     */
    String getResult();

    /**
     * Gets dealer hand.
     *
     * @return the dealer hand
     */
    HandInterface getDealerHand();

    /**
     * Gets player hand.
     *
     * @return the player hand
     */
    HandInterface getPlayerHand();

    /**
     * Gets deck.
     *
     * @return the deck
     */
    DeckInterface getDeck();

    /**
     * Gets dealer.
     *
     * @return the dealer
     */
    DealerInterface getDealer();

    /**
     * Gets player.
     *
     * @return the player
     */
    PlayerInterface getPlayer();

    /**
     * Reset player hand.
     */
    void resetPlayerHand();

    /**
     * Reset dealer hand.
     */
    void resetDealerHand();

    /**
     * Sets player name.
     *
     * @param name the name
     */
    void setPlayerName(String name);
}
