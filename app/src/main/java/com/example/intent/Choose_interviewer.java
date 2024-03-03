package com.example.intent;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.intent.databinding.ActivityChooseInterviewerBinding;
import com.example.intent.databinding.ActivityStartInterviewBinding;

public class Choose_interviewer extends AppCompatActivity {

    final static int REQUESTCODEss = 1423;
    String value1, value2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_interviewer);
        ActivityChooseInterviewerBinding binding = ActivityChooseInterviewerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.BT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handOverInformation(); //????????????????????????????????????????????????????????????????????????????????????????
                Intent intent = new Intent(Choose_interviewer.this, StartDilogWithInterviewer.class);
                intent.putExtra("key3", "interviewer1");
                intent.putExtra("key2", value2);
                intent.putExtra("key1", value1);
                startActivityForResult(intent, REQUESTCODEss);
            }
        });
        binding.BT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handOverInformation();
                Intent intent = new Intent(Choose_interviewer.this, StartDilogWithInterviewer.class);
                intent.putExtra("key3", "interviewer2");
                intent.putExtra("key2", value2);
                intent.putExtra("key1", value1);
                startActivityForResult(intent, REQUESTCODEss);
            }
        });
        binding.BACK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intentt = getIntent();
                int number = intentt.getIntExtra("number", 0);
                number++;
                Intent intent = new Intent(Choose_interviewer.this, StartInterview.class);
                startActivityForResult(intent, REQUESTCODEss);*/
                finish();
            }
        });
    }

    protected void handOverInformation() {
        Intent intent = getIntent();
        if(intent != null) {
            value1 = intent.getStringExtra("key1");
            value2 = intent.getStringExtra("key2");
        }
    }
}