package com.example.intent;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.intent.databinding.ActivityQuestion22Binding;

public class question22 extends AppCompatActivity {
    final static int REQUESTCODEss = 1423;
    String question, ans1, ans2, ans3, chooseAns="3", value1, value2, answer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question22);
        ActivityQuestion22Binding binding = ActivityQuestion22Binding.inflate(getLayoutInflater());
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
                    chooseAns="3";
                }
            }
        });
        binding.V2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.V2.isChecked()) {
                    chooseAns="6";
                }
            }
        });
        binding.V3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.V3.isChecked()) {
                    chooseAns="10";
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
                Intent intent = new Intent(question22.this, question33.class);
                intent.putExtra("answer1", answer1);
                intent.putExtra("answer2", chooseAns);
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
            if (value2.equals("work1")){
                question="Как вы будете решать проблему, если один из сотрудников начнет утверждать, что он является наследником престола и требует королевские привилегии на работе? ";
                ans1="Пока он не предоставит документы о своем родословном древе и праве на престол, давайте продолжим работать как обычно. Но если у него есть дракон, то это уже серьезный разговор!";
                ans2="Ну конечно, конечно, ваше величество! Давайте сразу же организуем королевский бал вместо обеденного перерыва!";
                ans3="Уволю его, никто не смеет претендовать на мое место";
            }
            else {
                question="Как вы объясните своей бабушке, что такое \"интерфейс\" в Java? ";
                ans1="Бабушка, интерфейс в Java - это как магический пульт управления, который говорит классам, какие кнопки им нажимать для правильной работы.";
                ans2="Бабушка, представьте себе, что интерфейс в Java - это как рамка для картины: он определяет форму и структуру, которую должны соблюдать классы при создании своего произведения искусства";
                ans3="Бабушка, интерфейс в Java - это как рецепт для приготовления блюда: если класс следует всем шагам, то получится вкусный и работающий код";
            }
        }
    }
}