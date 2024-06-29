package com.berlin.htw.blackjack.gui;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.berlin.htw.blackjack.R;
import com.berlin.htw.blackjack.game.BlackJackGame;
import com.berlin.htw.blackjack.game.Card;
import com.berlin.htw.blackjack.game.HandInterface;

public class SoloGameActivity extends Fragment {

    private BlackJackGame game;
    private LinearLayout dealerHandContainer;
    private LinearLayout playerHandContainer;
    private Button btnHit;
    private Button btnStand;
    private Button btnReset; // New button for resetting the game

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
        btnReset = view.findViewById(R.id.btnReset); // Initialize reset button

        // Set click listeners
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

        btnReset.setOnClickListener(v -> resetGame()); // Set reset button click listener

        // Initialize the game logic
        game = new BlackJackGame();
        game.startGame();

        // Update the UI with initial hands
        updateHandUI(game.getDealerHand(), dealerHandContainer, true); // Hide dealer's first card
        updateHandUI(game.getPlayerHand(), playerHandContainer, false);
    }

    private void updateHandUI(HandInterface hand, LinearLayout handContainer, boolean hideFirstCard) {
        handContainer.removeAllViews();
        boolean firstCard = true;
        for (Card card : hand.getCards()) {
            TextView cardTextView = new TextView(requireContext());
            cardTextView.setText(card.toString());
            cardTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16); // Adjust text size as needed
            cardTextView.setGravity(Gravity.CENTER); // Center text horizontally

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1f // Weight to evenly distribute space if multiple cards
            );
            layoutParams.setMargins(dpToPx(4), dpToPx(30), dpToPx(4), dpToPx(50)); // Adjust margins as needed
            cardTextView.setLayoutParams(layoutParams);

            handContainer.addView(cardTextView);

            if (firstCard && hideFirstCard) {
                cardTextView.setText("Hidden");
            }

            firstCard = false;
        }
    }

    private void resetGame() {
        // Reset game logic
        game.startGame();

        // Enable buttons if disabled
        btnHit.setEnabled(true);
        btnStand.setEnabled(true);

        // Clear result text if exists
        LinearLayout mainLayout = getView().findViewById(R.id.main);
        if (mainLayout != null) {
            mainLayout.removeAllViews();
        }

        // Update UI with initial hands
        updateHandUI(game.getDealerHand(), dealerHandContainer, true); // Hide dealer's first card
        updateHandUI(game.getPlayerHand(), playerHandContainer, false);
    }

    private void endGame() {
        btnHit.setEnabled(false);
        btnStand.setEnabled(false);


    }


    private int dpToPx(int dp) {
        float density = requireContext().getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }

    private void showResult(String result) {
        Toast.makeText(requireContext(), result, Toast.LENGTH_LONG).show();
    }
}
