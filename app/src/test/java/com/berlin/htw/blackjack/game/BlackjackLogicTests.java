package com.berlin.htw.blackjack.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.berlin.htw.blackjack.game.model.Card;
import com.berlin.htw.blackjack.game.model.Dealer;
import com.berlin.htw.blackjack.game.model.DealerInterface;
import com.berlin.htw.blackjack.game.model.Deck;
import com.berlin.htw.blackjack.game.model.DeckInterface;
import com.berlin.htw.blackjack.game.model.Player;
import com.berlin.htw.blackjack.game.model.PlayerInterface;

import org.junit.Before;
import org.junit.Test;

public class BlackjackLogicTests {

    private BlackJackGame game;
    private DeckInterface deck;
    private DealerInterface dealer;
    private PlayerInterface player;

    @Before
    public void setup() {
        game = new BlackJackGame();
        deck = new Deck();
        dealer = new Dealer();
        player = new Player();
    }

    @Test
    public void testStartGame_ShouldShuffleDeck() {
        game.startGame();

        assertNotNull("Deck should not be null after game start", game.getDeck());
        assertTrue("Deck should be shuffled after game start", game.getDeck().isShuffled());

    }

    @Test
    public void testPlayerHit() {
        game.startGame();

        int initialPlayerHandSize = game.getPlayerHand().getCards().size();

        game.playerHit();

        assertEquals("Player's hand size should increase by 1 after hit", initialPlayerHandSize + 1, game.getPlayerHand().getCards().size());
    }

    @Test
    public void testPlayerStand() {
        game.startGame();

        game.playerHit();
        game.playerHit();

        game.playerStand();

        assertTrue("Dealer's hand sum should be 17 or more after standing", game.getDealerHand().calculateSum() >= 17);
    }
/*
    @Test
    public void testIsPlayerBust_PlayerNotBust() {


        game.getPlayerHand().addCard(new Card("A", "A"));
        game.getPlayerHand().addCard(new Card("7", "D"));

        game.getDealerHand().addCard(new Card("A", "A"));
        game.getDealerHand().addCard(new Card("Q", "D"));

        assertFalse("Player should not be bust with hand sum of 17", game.isPlayerBust());
    }
    @Test
    public void testIsPlayerBust_PlayerBust() {
        game.startGame();
        game.getPlayerHand().addCard(new Card("A","H"));
        game.getPlayerHand().addCard(new Card("7","D"));
        game.getPlayerHand().addCard(new Card("8","C"));

        assertTrue("Player should be bust with hand sum of 25", game.isPlayerBust());
    }


    @Test
    public void testGetResult_PlayerWins() {

        // Set up player and dealer hands for win scenario
        game.getPlayerHand().addCard(new Card("10","C"));
        game.getPlayerHand().addCard(new Card("8", "H"));

        game.getDealerHand().addCard(new Card("7", "D"));
        game.getDealerHand().addCard(new Card("10","S"));

        assertEquals("Player wins!", game.getResult());
    }

    @Test
    public void testGetResult_DealerWins() {

        // Set up player and dealer hands for dealer win scenario
        game.getPlayerHand().addCard(new Card("8","C"));
        game.getPlayerHand().addCard(new Card("9","D"));

        game.getDealerHand().addCard(new Card("10","H"));
        game.getDealerHand().addCard(new Card("Q","S"));

        assertEquals("Dealer wins!", game.getResult());
    }

    @Test
    public void testGetResult_PlayerBust() {
        game.startGame();

        // Set up player hand for bust scenario
        game.getPlayerHand().addCard(new Card("10","C"));
        game.getPlayerHand().addCard(new Card("K","D"));
        game.getPlayerHand().addCard(new Card("3","H"));

        assertEquals("Player bust! Dealer wins.", game.getResult());
    }

    @Test
    public void testGetResult_DealerBust() {


        // Set up dealer hand for bust scenario
        game.getPlayerHand().addCard(new Card("8","C"));
        game.getPlayerHand().addCard(new Card("9","D"));

        game.getDealerHand().addCard(new Card("10","H"));
        game.getDealerHand().addCard(new Card("K","D"));
        game.getDealerHand().addCard(new Card("J","D"));

        assertEquals("Dealer bust! Player wins.", game.getResult());
    }

    @Test
    public void testGetResult_Tie() {
        game.getPlayerHand().addCard(new Card("A", "S"));
        game.getPlayerHand().addCard(new Card("10", "C"));

        game.getDealerHand().addCard(new Card("A", "H"));
        game.getDealerHand().addCard(new Card("10", "D"));

        assertEquals("It's a tie!", game.getResult());
    }
*/
    @Test
    public void testGetDealerHand() {
        game.startGame();

        assertNotNull(game.getDealerHand());
    }

    @Test
    public void testGetPlayerHand() {
        game.startGame();

        assertNotNull(game.getPlayerHand());
    }
}