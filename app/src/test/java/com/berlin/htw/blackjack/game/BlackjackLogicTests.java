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

/**
 * The type Blackjack logic tests.
 */
public class BlackjackLogicTests {

    private BlackJackInterface game;
    private DeckInterface deck;
    private DealerInterface dealer;
    private PlayerInterface player;

    /**
     * Sets .
     */
    @Before
    public void setup() {
        game = new BlackJackGame();
        deck = new Deck();
        dealer = new Dealer();
        player = new Player();
    }

    /**
     * Test start game should shuffle deck.
     */
    @Test
    public void testStartGame_ShouldShuffleDeck() {
        game.startGame();

        assertNotNull("Deck should not be null after game start", game.getDeck());
        assertTrue("Deck should be shuffled after game start", game.getDeck().isShuffled());

    }

    /**
     * Test player hit.
     */
    @Test
    public void testPlayerHit() {
        game.startGame();

        int initialPlayerHandSize = game.getPlayerHand().getCards().size();

        game.playerHit();

        assertEquals("Player's hand size should increase by 1 after hit", initialPlayerHandSize + 1, game.getPlayerHand().getCards().size());
    }

    /**
     * Test player stand.
     */
    @Test
    public void testPlayerStand() {
        game.startGame();

        game.playerHit();
        game.playerHit();

        game.playerStand();

        assertTrue("Dealer's hand sum should be 17 or more after standing", game.getDealerHand().calculateSum() >= 17);
    }

    /**
     * Test get dealer hand.
     */
    @Test
        public void testPlayerNotBust() {
            game.startGame();

            game.getPlayerHand().addCard(new Card("A", "A"));
            game.getPlayerHand().addCard(new Card("7", "D"));

            game.getDealerHand().addCard(new Card("A", "A"));
            game.getDealerHand().addCard(new Card("Q", "D"));

            assertFalse("Player should not be bust with hand sum of 17", game.isPlayerBust());
        }

    /**
     * Test player bust.
     */
    @Test
    public void testPlayerBust() {
        game.startGame();
        game.resetPlayerHand();
        game.getPlayerHand().addCard(new Card("9","H"));
        game.getPlayerHand().addCard(new Card("7","D"));
        game.getPlayerHand().addCard(new Card("8","C"));
      //  System.out.println( game.getPlayerHand().calculateSum());
        assertTrue("Player should be bust with hand sum of 24", game.isPlayerBust());
    }


    /**
     * Test get result player wins.
     */
    @Test
        public void testGetResult_PlayerWins() {
            game.startGame();
            game.resetPlayerHand();
            game.resetDealerHand();
            game.setPlayerName("Player");
            game.getPlayerHand().addCard(new Card("10","C"));
            game.getPlayerHand().addCard(new Card("8", "H"));

            game.getDealerHand().addCard(new Card("7", "D"));
            game.getDealerHand().addCard(new Card("10","S"));

            assertEquals("Player wins!", game.getResult());
        }

    /**
     * Test get result dealer wins.
     */
    @Test
        public void testGetResult_DealerWins() {
            game.startGame();
            game.resetPlayerHand();
            game.resetDealerHand();
            game.getPlayerHand().addCard(new Card("8","C"));
            game.getPlayerHand().addCard(new Card("9","D"));

            game.getDealerHand().addCard(new Card("10","H"));
            game.getDealerHand().addCard(new Card("Q","S"));

            assertEquals("Dealer wins!", game.getResult());
        }

    /**
     * Test get result player bust.
     */
    @Test
        public void testGetResult_PlayerBust() {
            game.startGame();
            game.resetDealerHand();
            game.resetPlayerHand();
            game.setPlayerName("Player");
            game.getPlayerHand().addCard(new Card("10","C"));
            game.getPlayerHand().addCard(new Card("K","D"));
            game.getPlayerHand().addCard(new Card("3","H"));

            assertEquals("Player bust! Dealer wins.", game.getResult());
        }

    /**
     * Test get result dealer bust.
     */
    @Test
            public void testGetResult_DealerBust() {
            game.startGame();
            game.resetDealerHand();
            game.resetPlayerHand();
            game.setPlayerName("Player");
            game.getPlayerHand().addCard(new Card("8","C"));
            game.getPlayerHand().addCard(new Card("9","D"));

            game.getDealerHand().addCard(new Card("10","H"));
            game.getDealerHand().addCard(new Card("K","D"));
            game.getDealerHand().addCard(new Card("J","D"));

            assertEquals("Dealer bust! Player wins.", game.getResult());
        }

    /**
     * Test get result tie.
     */
    @Test
            public void testGetResult_Tie() {
            game.startGame();
            game.resetDealerHand();
            game.resetPlayerHand();
            game.setPlayerName("Player");
            game.getPlayerHand().addCard(new Card("A", "S"));
            game.getPlayerHand().addCard(new Card("10", "C"));

            game.getDealerHand().addCard(new Card("A", "H"));
            game.getDealerHand().addCard(new Card("10", "D"));

            assertEquals("It's a tie!", game.getResult());
        }

    /**
     * Test get dealer hand.
     */
    @Test
    public void testGetDealerHand() {
        game.startGame();

        assertNotNull(game.getDealerHand());
    }

    /**
     * Test get player hand.
     */
    @Test
    public void testGetPlayerHand() {
        game.startGame();

        assertNotNull(game.getPlayerHand());
    }
}