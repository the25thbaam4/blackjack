package com.berlin.htw.blackjack.gui;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.berlin.htw.blackjack.R;
import com.berlin.htw.blackjack.game.BlackJackGame;
import com.berlin.htw.blackjack.game.BlackJackInterface;

public class GameActivity extends AppCompatActivity {
    private BlackJackInterface blackJackGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        blackJackGame = new BlackJackGame();
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_game);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}