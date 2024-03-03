package com.example.intent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.intent.databinding.ActivityQuestion33Binding;

public class question33 extends AppCompatActivity {
    final static int REQUESTCODEss = 1423;
    String question, ans1, ans2, ans3, chooseAns="7", value1, value2, answer1, answer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question33);
        ActivityQuestion33Binding binding = ActivityQuestion33Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        checkInformation();
        binding.TV.setText(question);
        binding.V1.setText(ans1);
        binding.V2.setText(ans2);
        binding.V3.setText(ans3);
        binding.V1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.V1.isChecked()) {
                    chooseAns="7";
                }
            }
        });
        binding.V2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.V2.isChecked()) {
                    chooseAns="4";
                }
            }
        });
        binding.V3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.V3.isChecked()) {
                    chooseAns="0";
                }
            }
        });
        binding.BACK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intentt = getIntent();??????????????????????????
/*                int number = intentt.getIntExtra("number", 0);
                number--;*/
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        binding.NEXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.intent.question33.this, IntervieResult.class);
                intent.putExtra("answer1", answer1);
                intent.putExtra("answer2", answer2);
                intent.putExtra("answer3", chooseAns);
                intent.putExtra("key1", value1);
                intent.putExtra("key2", value2);
                startActivityForResult(intent, REQUESTCODEss);
            }
        });
    }
    protected void checkInformation() {
        Intent intent = getIntent();
        if(intent != null) {
            value1 = intent.getStringExtra("key1");
            value2 = intent.getStringExtra("key2");
            answer1 = intent.getStringExtra("answer1");
            answer2 = intent.getStringExtra("answer2");
            //Toast.makeText(this, answer1+answer2, Toast.LENGTH_SHORT).show();
            if (value2.equals("work1")){
                question="Продайте мне эту ручку";
                ans3="ну, ээээ";
                ans2="Каждое слово, написанное этой ручкой, становится частью истории и отзовется в вечности";
                ans1="Эта ручка - ваш личный переводчик мыслей в слова, который поможет вам выразить все, что у вас на сердце, даже если это звучит странно";
                }
            else {
                question="Как бы вы оценили свои навыки программирования на Java по шкале от \"программист-кофеман\" до \"программист-кофемашина\"? ";
                ans1="Я бы оценил свои навыки программирования на Java как программист-кофеман с потенциалом стать программистом-кофемолкой!";
                ans3="Если шкала от программиста-кофемана до программиста-кофемашины, то я бы оценил свои навыки как программист-кофемиксер - иногда получается вкусно, иногда не очень!";
                ans2="Моя оценка - программист-кофеаппарат: иногда работает автоматически и без сбоев, иногда нужно чуть-чуть подправить параметры!";
            }
        }
    }
}