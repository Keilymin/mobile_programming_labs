package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//view кнопки,поля для ввода и текста

    //первое и второе число
    EditText firstNum = null;
    EditText secondNum = null;
    //ответ
    TextView decision = null;
    //кнопки деления и умножения
    Button buttonMultiply = null;
    Button buttonDivided = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //текущее активити
        setContentView(R.layout.activity_main);
        //поиск елементов по айди
        firstNum = findViewById(R.id.first_num);
        secondNum = findViewById(R.id.second_num);
        decision = findViewById(R.id.decision);
        buttonMultiply = findViewById(R.id.button3);
        buttonDivided = findViewById(R.id.button4);
        //установка обработчика клика
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate(3);
            }
        });
        buttonDivided.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate(4);
            }
        });
    }
    //установка метода , для обработчика клика
    public void clickMinus(View view){
        calculate(1);
    }
    public void clickPlus(View view){
        calculate(2);
    }

    //метод решения
    public void calculate(int operation){
        //получение введенных цифр
        double a = Double.parseDouble(firstNum.getText().toString());
        double b = Double.parseDouble(secondNum.getText().toString());
        double rez = 0;
        //деление на ноль
        boolean n = false;
        //выбор операции
        switch (operation){
            case 1:
                rez=a-b;
                break;
            case 2:
                rez=a+b;
                break;
            case 3:
                rez=a*b;
                break;
            case 4:
                if(b==0){
                    //вывод уведомления
                    Toast toast = Toast.makeText(getApplicationContext(),"Деление на 0",Toast.LENGTH_SHORT);
                    toast.show();
                    n = true;
                }else
                    rez=a/b;
                break;
        }
        //результат в поле результата
        if (n){
            decision.setText("Деление на 0");
        }else {
            String dec = String.valueOf(rez);
            decision.setText(dec);
        }
    }
}