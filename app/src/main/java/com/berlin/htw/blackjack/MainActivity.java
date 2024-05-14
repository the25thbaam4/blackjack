package com.berlin.htw.blackjack;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    private EditText username;

    @Override
    public void onClick(View v) {
    if (v.getId() == R.id.btnStart){
        Toast.makeText(this,  username.getText().toString() +" clicked this", Toast.LENGTH_LONG).show();
    }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

           username  = findViewById(R.id.textInputEditText);
            Button btnStart = findViewById(R.id.btnStart);
            btnStart.setOnClickListener(this);
 /*
            startBt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, ChooseAGame.class);
                    startActivity(intent);
                }
            });

          */
            return insets;
        });
    }



}