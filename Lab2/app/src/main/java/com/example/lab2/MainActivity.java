package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //статическая переменная отправки для камеры
    private static final int CAMERA_REQUEST = 0;
    //кнопки управления
    private Button cat = null;
    private Button dog = null;
    private Button my = null;
    //картинка в которую мы загружаем
    private ImageView imageView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView4);
        cat = findViewById(R.id.cat);
        dog = findViewById(R.id.dog);
        cat.setOnClickListener(this);
        dog.setOnClickListener(this);
        my = findViewById(R.id.my);
        my.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.my:
                try {
                    // Намерение для запуска камеры
                    Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(captureIntent, CAMERA_REQUEST);
                } catch (ActivityNotFoundException e) {
                    // Выводим сообщение об ошибке
                    String errorMessage = "Ваше устройство не поддерживает съемку";
                    Toast toast = Toast
                            .makeText(this, errorMessage, Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;
            case R.id.cat:
                Intent intent = new Intent(this, CatActivity.class);
                startActivity(intent);
                break;
            case R.id.dog:
                Intent intent2 = new Intent(this, DogActivity.class);
                startActivity(intent2);
                break;
        }
    }
    @Override
    //обрабатываем результат от камеры, заменяем картинку
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            // Фотка сделана, извлекаем картинку
            Bitmap thumbnailBitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(thumbnailBitmap);
        }
    }
}
