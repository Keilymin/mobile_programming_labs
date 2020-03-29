package com.example.lab4_3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lab4_3.R;

public class FirstFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private int mParam1;

    public FirstFragment() {}

    public static FirstFragment newInstance(int param1) {
        //функция для приема картинки
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.first_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView imageView = view.findViewById(R.id.imageView2);
        //в зависимости от картинки красим задний фон
        switch (mParam1){
            case R.drawable.dino:
                view.setBackgroundColor(Color.BLUE);
                break;
            case R.drawable.donut:
                view.setBackgroundColor(Color.GREEN);
                break;
            case R.drawable.nichesi:
                view.setBackgroundColor(Color.MAGENTA);
                break;
        }
        //устанавливаем картинку
        imageView.setImageResource(mParam1);
    }
}