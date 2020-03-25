package com.example.lab3_b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab3_b.entity.Animal;

import java.util.List;

public class AnimalAdapter  extends RecyclerView.Adapter<AnimalViewHolder> {

    private List<Animal> list;

    public AnimalAdapter(List<Animal> list, Context context) {
        this.list = list;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item, viewGroup, false);
        AnimalViewHolder holder = new AnimalViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder animalViewHolder, int i) {
        animalViewHolder.image.setImageResource(list.get(i).getImage());
        animalViewHolder.name.setText(list.get(i).getName());
        animalViewHolder.species.setText(list.get(i).getSpecies());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

