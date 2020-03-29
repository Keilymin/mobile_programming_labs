package com.example.lab4_3;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity  extends AppCompatActivity {

    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
    //ищем элемент устанавливаем адаптер
        ViewPager pager = findViewById(R.id.pager);
        pager.setAdapter(new MyAdapter(manager));
        //добавляем пейджер
        TabLayout tab = findViewById(R.id.tab);
        tab.setupWithViewPager(pager);
    }


    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            //название вкладок
            return "Page " + (position+1);
        }

        @Override
        public Fragment getItem(int i) {
            //отображение определенной картинки в зависимости от вкладки
            int image = 0;
            switch (i){
                case 0:
                    image = R.drawable.nichesi;
                    break;
                case 1:
                    image = R.drawable.donut;
                    break;
                case 2:
                    image = R.drawable.dino;
                    break;
            }
            //отправляем картинку в первый фрагмент
            return FirstFragment.newInstance(image);
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}