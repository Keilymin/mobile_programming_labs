package com.example.lab5_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements MyDialog.MyDialogListener  {
    //Массив элементов
 List<Integer> data;
 RecyclerView recycler;
 //кол-во элементов
 int N = 18;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Создаем ранломные числа
        data = new ArrayList<Integer>(N);
        for (int i=0;i<N;i++){
            int a = (int) (Math.random()*(100));
            data.add(a);
        }

        recycler = findViewById(R.id.list);
        recycler.setHasFixedSize(true);
        //Делаем отображение элементов в виде сетки
        recycler.setLayoutManager(new GridLayoutManager(this, 3));
        //подключили адаптер
        recycler.setAdapter(new ImageAdapter(data, this));
        //действие при клике на элемент
        recycler.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recycler ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        //Отправить диалогу цифру и открыть диалог
                       String txt = data.get(position).toString();
                        MyDialog dialog = MyDialog.newInstance(txt);
                        dialog.show(getSupportFragmentManager(), "dlg");
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
    }

    @Override
    public void onMyDialogResult(String choice) {

    }
}
