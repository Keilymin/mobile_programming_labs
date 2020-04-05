package com.example.lab5_3;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class AirplaneModeDialog extends DialogFragment {
    boolean isAirplaneModeOn;

    public AirplaneModeDialog(boolean isAirplaneModeOn) {
        this.isAirplaneModeOn = isAirplaneModeOn;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("В самолете");
        if(isAirplaneModeOn) {
            builder.setMessage("Включен");
        }
        else {
            builder.setMessage("Выключен");
        }
        builder.setPositiveButton("OK", null);

        return builder.create();
    }
}
