package com.example.lab3_b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab3_b.entity.Animal;

public class AnimalActivity extends AppCompatActivity implements View.OnClickListener {

    private Button back;
    private TextView name;
    private TextView species;
    private TextView description;
    private ImageView image;
    //животное что только что было выбрано
    private Animal animal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_description_layout);

        back = findViewById(R.id.back);
        name = findViewById(R.id.animal_name);
        species = findViewById(R.id.animal_species);
        description = findViewById(R.id.animal_description);
        image = findViewById(R.id.animal_image);

        back.setOnClickListener(this);
        //получаем животное с интент
        animal = (Animal) getIntent().getSerializableExtra("Animal");
        name.setText(animal.getName());
        species.setText(animal.getSpecies());
        description.setText(animal.getDescription());
        image.setImageResource(animal.getImage());
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}