package com.example.lab2;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class CatActivity extends AppCompatActivity implements View.OnClickListener {
    //Кнопки управления
    private Button back = null;
    private Button model = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cat_activity);

        back = findViewById(R.id.back);
        model = findViewById(R.id.model);
        //добавляем листенером этот класс
        back.setOnClickListener(this);
        model.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.back:
                //при нажатии кнопки назад возвращаемся в мейн
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.model:
                Intent i = new Intent(Intent.ACTION_SEND);
                //открываем ссылку
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://arvr.google.com/scene-viewer?file=https://storage.googleapis.com/ar-answers-in-search-models/static/ShortHairedCat/model.glb&title=%D0%9A%D0%BE%D1%88%D0%BA%D0%B0"));

                PackageManager manager = this.getPackageManager();
                // Получаем список обработчиков намерения
                List<ResolveInfo> list = manager.queryIntentActivities(i, 0);

                if (list.size() > 0) {
                    startActivity(i);
                } else {
                    Toast.makeText(this, "Невозможно обработать намерение!", Toast.LENGTH_LONG).show();
                }
                break;
        }

    }

}
