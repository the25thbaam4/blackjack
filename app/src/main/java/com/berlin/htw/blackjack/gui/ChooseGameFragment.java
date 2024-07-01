package com.berlin.htw.blackjack.gui;


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
        String username = getArguments().getString("USERNAME");
        welcomeMessage.setText("Welcome, " + username + "!");

        btnConfirmSelection.setOnClickListener(v -> {
            int selectedId = radioGroupGameOptions.getCheckedRadioButtonId();
            if (selectedId == R.id.radioStartSoloGame) {
                SoloGameActivity soloGameActivity = new SoloGameActivity();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, soloGameActivity);
                transaction.addToBackStack(null);
                transaction.commit();
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

