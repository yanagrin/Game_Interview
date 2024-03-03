package com.example.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.intent.databinding.ActivityStartDilogWithInterviewerBinding;
import com.example.intent.databinding.ActivityStartInterviewBinding;

public class StartDilogWithInterviewer extends AppCompatActivity {
    final static int REQUESTCODEss = 1423;
    String InterviewerName, value1,value2, playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_dilog_with_interviewer);

        ActivityStartDilogWithInterviewerBinding binding = ActivityStartDilogWithInterviewerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        checkInformation();
        binding.TV.setText("Добрый день, "+playerName+", меня зовут "+InterviewerName+". Давайте начнем собеседование");
        binding.START.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartDilogWithInterviewer.this, Question11.class);
                intent.putExtra("key1", value1);
                intent.putExtra("key2", value2);
                startActivityForResult(intent, REQUESTCODEss);
            }
        });
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUESTCODEss && resultCode == RESULT_OK) {
            String str = data.getStringExtra("key2");
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }
    }*/

    protected void checkInformation() {
        Intent intent = getIntent();
        if(intent != null) {
            value1 = intent.getStringExtra("key1");
            value2 = intent.getStringExtra("key2");
            playerName=value1;
            String value3 = intent.getStringExtra("key3");
            //Toast.makeText(this, "value2"+value2, Toast.LENGTH_SHORT).show();
            if (value3.equals("interviewer1")){InterviewerName="Анна";}
            else {InterviewerName="Валентина Афанасьевна";}
        }
    }
}