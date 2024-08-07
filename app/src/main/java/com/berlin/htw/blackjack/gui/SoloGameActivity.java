package com.berlin.htw.blackjack.gui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.berlin.htw.blackjack.R;
import com.berlin.htw.blackjack.game.BlackJackGame;
import com.berlin.htw.blackjack.game.model.Card;
import com.berlin.htw.blackjack.game.model.HandInterface;

/**
 * The type Solo game activity.
 */
public class SoloGameActivity extends AppCompatActivity {

    private BlackJackGame game;
    private LinearLayout dealerHandContainer;
    private LinearLayout playerHandContainer;
    private Button btnHit;
    private Button btnStand;
    private Button btnReset;
    private Button btnPlaceBet;
    private EditText etBetAmount;
    private TextView tvChips;
    private Button btnNextRound;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solo_game);
        dealerHandContainer = findViewById(R.id.dealerHandContainer);
        playerHandContainer = findViewById(R.id.playerHandContainer);
        btnHit = findViewById(R.id.btnHit);
        btnStand = findViewById(R.id.btnStand);
        btnReset = findViewById(R.id.btnReset);
        btnPlaceBet = findViewById(R.id.btnPlaceBet);
        etBetAmount = findViewById(R.id.etBetAmount);
        tvChips = findViewById(R.id.tvChips);
        btnNextRound = findViewById(R.id.btnNextRound);


        game = new BlackJackGame();

        game.startGame();


        Intent intent = getIntent();
        if (intent != null) {
            String username = intent.getStringExtra("USERNAME");
            if (username != null) {
                game.getPlayer().setUsername(username);
            }
        }


        btnPlaceBet.setOnClickListener(v -> placeBet());

        btnHit.setOnClickListener(v -> {
            game.playerHit();
            updateHandUI(game.getPlayerHand(), playerHandContainer, false);

            if (game.isPlayerBust()) {
                showResult(game.getPlayer().getUsername() + " bust! Dealer wins.");
                endGame();
            }
        });

        btnStand.setOnClickListener(v -> {
            game.playerStand();
            updateHandUI(game.getDealerHand(), dealerHandContainer, false);
            showResult(game.getResult());
            endGame();
        });

        btnNextRound.setOnClickListener(v -> startNextRound());

        btnReset.setOnClickListener(v -> resetGame());

        updateUI();

    }

    private void updateHandUI(HandInterface hand, LinearLayout handContainer, boolean hideFirstCard) {
        handContainer.removeAllViews();
        boolean firstCard = true;
        for (Card card : hand.getCards()) {
            ImageView cardImageView = new ImageView(this);
            int cardResId = CardUtils.getCardResourceId(this, card);
            if (firstCard && hideFirstCard) {
                cardImageView.setImageResource(R.drawable.card_back);
            } else {
                cardImageView.setImageResource(cardResId);
            }

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1f
            );
            layoutParams.setMargins(dpToPx(4), dpToPx(4), dpToPx(4), dpToPx(4)); // Adjust margins as needed
            cardImageView.setLayoutParams(layoutParams);

            handContainer.addView(cardImageView);
            firstCard = false;
        }
    }

    private void resetGame() {
        if (game.isGameOver()) {
            Toast.makeText(this, "Game Over! Your chips are 0.", Toast.LENGTH_LONG).show();
        }

        dealerHandContainer.removeAllViews();
        playerHandContainer.removeAllViews();
        game.startGame();

        btnHit.setEnabled(true);
        btnStand.setEnabled(true);
        btnPlaceBet.setEnabled(true);
        btnNextRound.setEnabled(false);
        updateUI();
    }

    private void endGame() {

        btnHit.setEnabled(false);
        btnStand.setEnabled(false);
        resolveBet();
        updateChipsUI();
        if (game.isGameOver()) {
            btnNextRound.setEnabled(false);
            btnPlaceBet.setEnabled(false);
            Toast.makeText(this, "Game Over! Your chips are 0.", Toast.LENGTH_LONG).show();
        } else {
            btnNextRound.setEnabled(true);
            btnPlaceBet.setEnabled(false);
        }
    }

    private void resetGameState() {
        dealerHandContainer.removeAllViews();
        playerHandContainer.removeAllViews();

        game.startGame();

        btnHit.setEnabled(true);
        btnStand.setEnabled(true);
        btnPlaceBet.setEnabled(true);
    }

    private int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }

    private void showResult(String result) {
        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
    }

    private void placeBet() {
        String betAmountStr = etBetAmount.getText().toString();
        if (betAmountStr.isEmpty()) {
            Toast.makeText(this, "Please enter a bet amount", Toast.LENGTH_SHORT).show();
            return;
        }
        int betAmount = Integer.parseInt(betAmountStr);
        if (betAmount <= 0 || betAmount > game.getPlayer().getChips()) {
            Toast.makeText(this, "Invalid bet amount", Toast.LENGTH_SHORT).show();
            return;
        }

        game.placeBet(betAmount);
        updateChipsUI();


        btnHit.setEnabled(true);
        btnStand.setEnabled(true);
        btnPlaceBet.setEnabled(false);
    }

    private void resolveBet() {
        game.resolveBet();
        updateChipsUI();
    }

    private void updateChipsUI() {
        tvChips.setText("Chips: " + game.getPlayer().getChips());
    }

    private void updateUI() {
        updateHandUI(game.getDealerHand(), dealerHandContainer, true); // Hide dealer's first card
        updateHandUI(game.getPlayerHand(), playerHandContainer, false);
        updateChipsUI();
    }

    private void startNextRound() {
        game.startNextRound();
        updateUI();

        btnHit.setEnabled(true);
        btnStand.setEnabled(true);
        btnPlaceBet.setEnabled(true);
        btnNextRound.setEnabled(false);
        etBetAmount.setText("");
    }
}
