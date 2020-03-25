package com.example.lab3_a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.lab3_a.entity.Animal;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private List<Animal> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         data = createList();
        ListView list = findViewById(R.id.list);

        // Создаем объект адаптера
        AnimalAdapter adapter = new AnimalAdapter(this, data);

        // Передаем его виджету списка
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this,AnimalActivity.class);
        intent.putExtra("Animal",data.get(position));
        startActivity(intent);
    }
}
