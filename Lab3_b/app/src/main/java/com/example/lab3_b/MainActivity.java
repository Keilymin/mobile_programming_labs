package com.example.lab3_b;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab3_b.entity.Animal;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    private List<Animal> data;
    private RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         data = createList();

        // Создаем объект адаптера
        rv = findViewById(R.id.list);
        rv.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layoutManager);

        rv.setAdapter(new AnimalAdapter(data, this));
        rv.addOnItemTouchListener(
                new RecyclerItemClickListener(this, rv ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getLayoutInflater().getContext(),AnimalActivity.class);
                        intent.putExtra("Animal",data.get(position));
                        startActivity(intent);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
    }

    private List<Animal>  createList(){
        List<Animal> list = new ArrayList<>();

        Animal elephant = new Animal(R.drawable.elephant,"Слон","Млекопитающие",R.string.elephant);
        Animal hippopotamus = new Animal(R.drawable.hippopotamus,"Бегемот","Млекопитающие",R.string.hippopotamus);
        Animal eagle = new Animal(R.drawable.eagle,"Орел","Птица",R.string.eagle);
        Animal ladybug = new Animal(R.drawable.ladybug,"Божья коровка","Насекомые",R.string.ladybug);
        Animal shark = new Animal(R.drawable.shark,"Акула","Хрящевые рыбы",R.string.shark);
        Animal sturgeon = new Animal(R.drawable.sturgeon,"Осетр","Лучепёрые рыбы",R.string.sturgeon);

        list.add(sturgeon);
        list.add(shark);
        list.add(ladybug);
        list.add(elephant);
        list.add(eagle);
        list.add(hippopotamus);

        return list;
    }

}
