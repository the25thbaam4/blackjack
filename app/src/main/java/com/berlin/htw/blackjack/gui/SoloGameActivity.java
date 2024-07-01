package com.berlin.htw.blackjack.gui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.berlin.htw.blackjack.R;
import com.berlin.htw.blackjack.game.BlackJackGame;
import com.berlin.htw.blackjack.game.model.Card;
import com.berlin.htw.blackjack.game.model.HandInterface;

public class SoloGameActivity extends Fragment {

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
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_solo_game, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dealerHandContainer = view.findViewById(R.id.dealerHandContainer);
        playerHandContainer = view.findViewById(R.id.playerHandContainer);
        btnHit = view.findViewById(R.id.btnHit);
        btnStand = view.findViewById(R.id.btnStand);
        btnReset = view.findViewById(R.id.btnReset);
        btnPlaceBet = view.findViewById(R.id.btnPlaceBet);
        etBetAmount = view.findViewById(R.id.etBetAmount);
        tvChips = view.findViewById(R.id.tvChips);
        btnNextRound = view.findViewById(R.id.btnNextRound);
        game = new BlackJackGame();
        game.startGame();


        btnPlaceBet.setOnClickListener(v -> placeBet());

        btnHit.setOnClickListener(v -> {
            game.playerHit();
            updateHandUI(game.getPlayerHand(), playerHandContainer, false);

            if (game.isPlayerBust()) {
                showResult("Player bust! Dealer wins.");
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
            ImageView cardImageView = new ImageView(requireContext());
            int cardResId = CardUtils.getCardResourceId(requireContext(), card);
            if (firstCard && hideFirstCard) {
                cardImageView.setImageResource(R.drawable.card_back); // Assuming you have a card back image
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
       if (game.isGameOver()){
           Toast.makeText(requireContext(), "Game Over! Your chips are 0.", Toast.LENGTH_LONG).show();
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
            Toast.makeText(requireContext(), "Game Over! Your chips are 0.", Toast.LENGTH_LONG).show();
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
        btnPlaceBet.setEnabled(true); // Enable place bet button for new round
    }

    private int dpToPx(int dp) {
        float density = requireContext().getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }

    private void showResult(String result) {
        Toast.makeText(requireContext(), result, Toast.LENGTH_LONG).show();
    }

    private void placeBet() {
        String betAmountStr = etBetAmount.getText().toString();
        if (betAmountStr.isEmpty()) {
            Toast.makeText(requireContext(), "Please enter a bet amount", Toast.LENGTH_SHORT).show();
            return;
        }
        int betAmount = Integer.parseInt(betAmountStr);
        if (betAmount <= 0 || betAmount > game.getPlayer().getChips()) {
            Toast.makeText(requireContext(), "Invalid bet amount", Toast.LENGTH_SHORT).show();
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
    }
}
