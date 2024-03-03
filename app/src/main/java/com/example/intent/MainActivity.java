package com.example.intent;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.intent.databinding.ActivityMainBinding;
import com.example.intent.databinding.ActivitySecondBinding;

public class MainActivity extends AppCompatActivity {
    final static int REQUESTCODE = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.START.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentt = new Intent(MainActivity.this, secondActivity.class);
                startActivityForResult(intentt, REQUESTCODE); //Запускает активность secondActivity с возможностью получения результата обратно в активность MainActivity
            }
        });
    }

    /*//вызывается, когда одна активность завершает свою работу и передает результат обратно другой активности
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Проверяет, что результат получен для того же запроса, который был отправлен из текущей активности, и что результат успешен
        if (requestCode == REQUESTCODE && resultCode == RESULT_OK) {
            String str = data.getStringExtra("number1"); // Извлекает строку, которая была помещена в объект Intent с ключом "key2" из возвращенных данны
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }
    }*/
}