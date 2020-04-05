package com.example.lab5_1;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class MyDialog extends DialogFragment {
    // Слушатель и интерфейс для передачи данных в Activity
    private MyDialogListener mListener;
    public static interface MyDialogListener {
        void onMyDialogResult(String choice);
    }

    // Статический метод для передачи данных в диалог
    public static MyDialog newInstance(String param1) {
        MyDialog fragment = new MyDialog();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    // Получаем данные из Bundle
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mParam1 = getArguments() == null ? "null" : getArguments().getString(ARG_PARAM1);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Number");
        //устанавливаем цифру в мессейдж
        builder.setMessage(mParam1);
        builder.setPositiveButton("OK", null);

        return builder.create();
    }
    // Получаем объект слушателя
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (MyDialogListener) context;
        } catch (ClassCastException ex) {
            throw new ClassCastException(context.toString() + " must implement MyDialog.MyDialogListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mListener = null;
    }
}
