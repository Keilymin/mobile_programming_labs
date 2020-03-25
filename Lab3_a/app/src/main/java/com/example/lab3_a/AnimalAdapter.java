package com.example.lab3_a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab3_a.entity.Animal;

import java.util.List;

public class AnimalAdapter  extends BaseAdapter {

    private List<Animal> data;
    private LayoutInflater inflater;

    public AnimalAdapter(Context context, List<Animal> data) {
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_item, parent, false);

        // 2. Получаем доступ к виджетам дерева объектов
        TextView name = convertView.findViewById(R.id.animal_name);
        TextView species = convertView.findViewById(R.id.animal_species);
        ImageView image = convertView.findViewById(R.id.image_animal);

        // 3. Меняем содержимое виджетов
        name.setText(data.get(position).getName());
        species.setText(data.get(position).getSpecies());
        image.setImageResource(data.get(position).getImage());
        // 4. Возвращаем модифицированное дерево объектов
        return convertView;
    }
}