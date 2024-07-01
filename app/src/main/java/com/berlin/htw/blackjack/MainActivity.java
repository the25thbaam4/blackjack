package com.berlin.htw.blackjack;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.berlin.htw.blackjack.gui.ChooseGameFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText username;
    private Button btnStart;
    private TextView welcomeText;
    private TextView promptText;
    private FrameLayout fragmentContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.textInputEditText);
        btnStart = findViewById(R.id.btnStart);
        welcomeText = findViewById(R.id.welcome);
        promptText = findViewById(R.id.textView);
        fragmentContainer = findViewById(R.id.fragment_container);

        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnStart) {
            String userNameInput = username.getText().toString();
            if (!userNameInput.isEmpty()) {


                Bundle bundle = new Bundle();
                bundle.putString("USERNAME", userNameInput);
                Log.d(TAG, "Username input: " + userNameInput);

                ChooseGameFragment chooseGameFragment = new ChooseGameFragment();
                chooseGameFragment.setArguments(bundle);


                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, chooseGameFragment);
                transaction.addToBackStack(null);
                transaction.commit();


                welcomeText.setVisibility(View.GONE);
                promptText.setVisibility(View.GONE);
                username.setVisibility(View.GONE);
                btnStart.setVisibility(View.GONE);


                fragmentContainer.setVisibility(View.VISIBLE);
            } else {
                Toast.makeText(this, "Please enter a username", Toast.LENGTH_SHORT).show();
            }
        }
    }


}