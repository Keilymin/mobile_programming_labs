package com.example.lab5_1;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;


        import java.util.List;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

public class ImageAdapter  extends RecyclerView.Adapter<ImageViewHolder> {

    private List<Integer> list;

    public ImageAdapter(List<Integer> list, Context context) {
        this.list = list;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter, viewGroup, false);
        ImageViewHolder holder = new ImageViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder animalViewHolder, int i) {
        //создаем рандомный цвет
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        ColorDrawable cd = new ColorDrawable(color);
        //устанавливаем задний фон
        animalViewHolder.image.setImageDrawable(cd);
        //устанавливаем рандомную цифу из list
        String txt = String.valueOf(list.get(i));
        animalViewHolder.number.setText(txt);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
