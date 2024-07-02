package com.berlin.htw.blackjack.gui;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.berlin.htw.blackjack.R;

/**
 * The type Choose game fragment.
 */
public class ChooseGameFragment extends Fragment {

    private RadioGroup radioGroupGameOptions;
    private Button btnConfirmSelection;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choose_game, container, false);

        TextView welcomeMessage = view.findViewById(R.id.welcomeMessage);
        radioGroupGameOptions = view.findViewById(R.id.radioGroupGameOptions);
        btnConfirmSelection = view.findViewById(R.id.btnConfirmSelection);

        // Get the username from the arguments
        Bundle bundle = getArguments();
        String username;
        if (bundle != null) {
            username = bundle.getString("USERNAME");
            welcomeMessage.setText("Welcome, " + username + "!");
        } else {
            username = "Player";
        }

        btnConfirmSelection.setOnClickListener(v -> {
            int selectedId = radioGroupGameOptions.getCheckedRadioButtonId();
            if (selectedId == R.id.radioStartSoloGame) {

                Intent intent = new Intent(getActivity(), SoloGameActivity.class);
                assert username != null;
                intent.putExtra("USERNAME", username.toUpperCase());
                startActivity(intent);
            } else if (selectedId == R.id.radioJoinBluetoothGame) {
                BluetoothJoinFragment bluetoothJoinFragment = new BluetoothJoinFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, bluetoothJoinFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        return view;
    }


}

