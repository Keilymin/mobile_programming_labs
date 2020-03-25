package com.example.lab3_b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnimalViewHolder extends RecyclerView.ViewHolder {

    public ImageView image;
    public TextView name;
    public TextView species;

    public AnimalViewHolder(@NonNull View itemView) {
        super(itemView);

        image = itemView.findViewById(R.id.image_animal);
        name = itemView.findViewById(R.id.animal_name);
        species = itemView.findViewById(R.id.animal_species);
    }
}
