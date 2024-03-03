package com.example.intent;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.intent.databinding.ActivityIntervieResultBinding;
import com.example.intent.databinding.ActivityQuestion11Binding;

public class IntervieResult extends AppCompatActivity {
    final static int REQUESTCODEss = 1423;
    String value1, value2, answer1, answer2, answer3, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intervie_result);

        ActivityIntervieResultBinding binding = ActivityIntervieResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        checkResult();
        binding.TV.setText(result);
        binding.BACK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        binding.NEXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntervieResult.this, End.class);
                startActivityForResult(intent, REQUESTCODEss);
            }
        });
    }

    protected void checkResult() {
        Intent intent = getIntent();
        if(intent != null) {
            value1 = intent.getStringExtra("key1");
            value2 = intent.getStringExtra("key2");
            answer1 = intent.getStringExtra("answer1");
            answer2 = intent.getStringExtra("answer2");
            answer3 = intent.getStringExtra("answer3");
            int sum=0;
            sum+=Integer.parseInt(answer1)+Integer.parseInt(answer2)+Integer.parseInt(answer3);
            //Toast.makeText(IntervieResult.this, sum, Toast.LENGTH_SHORT).show();
            if (sum>15){
                result="Поздравляю, вы принты!";
            }
            else {
                result="Мы вам перезвоним ...";
            }
        }
    }
}