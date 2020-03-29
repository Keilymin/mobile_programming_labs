package com.example.lab4_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.lab4_2.fragments.MenuFragment;
import com.example.lab4_2.fragments.WebFragment;

public class MainActivity extends AppCompatActivity implements  MenuFragment.OnFragmentInteractionListener {
    private FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //добавляем менеджер читаем транзакции с меню
        manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.fragment,new MenuFragment(),"frag1")
                .commit();
    }
    @Override
    public void onFragmentInteraction(String result) {
        //выбор ссылки в зависимости от пункта меню
        String r = result;
        switch (result){
            case "Google":
                r = "https://www.google.com/";
                break;
            case "Facebook":
                r = "https://www.facebook.com/";
                break;
            case "Twitter":
                r = "https://www.twitter.com/";
                break;
            case "Xda-developer":
                r = "https://www.xda-developers.com/";
                break;
        }
        //отсылаем в вебвью
        manager.beginTransaction()
                .add(R.id.fragment2, WebFragment.newInstance(r),"frag2")
                .commit();
    }
}
