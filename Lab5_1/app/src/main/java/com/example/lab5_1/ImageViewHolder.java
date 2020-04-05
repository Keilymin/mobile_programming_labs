package com.example.lab5_1;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ImageViewHolder extends RecyclerView.ViewHolder {

    public CircleImageView image;
    public TextView number;

    public ImageViewHolder(@NonNull View itemView) {
        super(itemView);

        image = itemView.findViewById(R.id.image);
        number = itemView.findViewById(R.id.number);

    }
}