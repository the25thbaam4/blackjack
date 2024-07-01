package com.berlin.htw.blackjack.gui;

import static android.app.Activity.RESULT_OK;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.berlin.htw.blackjack.R;

import java.util.Set;

public class BluetoothJoinFragment extends Fragment {

    private ActivityResultLauncher<Intent> enableBluetoothLauncher;
    private ActivityResultLauncher<Intent> discoverBluetoothLauncher;
    private ActivityResultLauncher<String> requestPermissionLauncher;


    private static final int REQUEST_ENABLE_BT = 0;
    private static final int REQUEST_DISCOVER_BT = 1;

    private TextView mStatusBleTv, mPairedTv;
    private ImageView mBlueIV;
    private Button mOnBtn, mOffBtn, mDiscoverBtn, mPairedBtn;
    private BluetoothAdapter bluetoothAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bluetooth_join, container, false);

        mStatusBleTv = view.findViewById(R.id.statusBluetoothTv);
        mPairedTv = view.findViewById(R.id.pairTv);
        mBlueIV = view.findViewById(R.id.bluetoothIv);
        mOnBtn = view.findViewById(R.id.onButn);
        mOffBtn = view.findViewById(R.id.offButn);
        mDiscoverBtn = view.findViewById(R.id.discoverableBtn);
        mPairedBtn = view.findViewById(R.id.PairedBtn);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (bluetoothAdapter == null) {
            mStatusBleTv.setText("Bluetooth is not available");
        } else {
            mStatusBleTv.setText("Bluetooth is available");

            if (bluetoothAdapter.isEnabled()) {
                mBlueIV.setImageResource(R.drawable.bluetooth_on);
            } else {
                mBlueIV.setImageResource(R.drawable.bluetooth_off);
            }

            mOnBtn.setOnClickListener(v -> {
                if (!bluetoothAdapter.isEnabled()) {
                    showToast("Turning on Bluetooth..");
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    enableBluetoothLauncher.launch(intent);
                } else {
                    showToast("Bluetooth is already on");
                }
            });

            mDiscoverBtn.setOnClickListener(v -> {
                if (!bluetoothAdapter.isDiscovering()) {
                    showToast("Making Your Device Discoverable");
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    intent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);  // Make discoverable for 300 seconds
                    discoverBluetoothLauncher.launch(intent);
                }
            });

            mOffBtn.setOnClickListener(v -> {
                if (bluetoothAdapter.isEnabled()) {
                    bluetoothAdapter.disable();
                    showToast("Turning Bluetooth off");
                    mBlueIV.setImageResource(R.drawable.bluetooth_off);
                } else {
                    showToast("Bluetooth is already off");
                }
            });

            mPairedBtn.setOnClickListener(v -> {
                if (bluetoothAdapter.isEnabled()) {
                    mPairedTv.setText("Paired Devices");
                    Set<BluetoothDevice> devices = bluetoothAdapter.getBondedDevices();
                    for (BluetoothDevice device : devices) {
                        mPairedTv.append("\nDevice: " + device.getName() + " , " + device);
                    }
                } else {
                    showToast("Turn on Bluetooth to get paired devices");
                }
            });
        }

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_ENABLE_BT) {
            if (resultCode == RESULT_OK) {
                mBlueIV.setImageResource(R.drawable.bluetooth_on);
                showToast("Bluetooth is on");
            } else {
                showToast("Bluetooth is off");
            }
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        enableBluetoothLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        mBlueIV.setImageResource(R.drawable.bluetooth_on);
                        showToast("Bluetooth is On");
                    } else {
                        showToast("Bluetooth is Off");
                    }
                });

        discoverBluetoothLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    showToast("Device is discoverable for 300 seconds");
                });
    }

    private void showToast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
