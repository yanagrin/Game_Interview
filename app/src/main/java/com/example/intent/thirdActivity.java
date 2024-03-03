package com.example.intent;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.intent.databinding.ActivityThirdBinding;

public class thirdActivity extends AppCompatActivity {
    final static int REQUESTCODEss = 1423;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityThirdBinding binding = ActivityThirdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.BT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thirdActivity.this, StartInterview.class);
                intent.putExtra("key2", "work1");
                intent.putExtra("key1", handOverInformation());
                startActivityForResult(intent, REQUESTCODEss);
            }
        });
        binding.BT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thirdActivity.this, StartInterview.class);
                intent.putExtra("key2", "work2");
                intent.putExtra("key1", handOverInformation());
                startActivityForResult(intent, REQUESTCODEss);
            }
        });

        binding.BACK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    protected String handOverInformation() {
        Intent intent = getIntent();
        if(intent != null) {
            String value1 = intent.getStringExtra("key1");
            return value1;
        }
        return "Error";
    }

}