package com.example.intent;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.intent.databinding.ActivityStartInterviewBinding;

public class StartInterview extends AppCompatActivity {
    final static int REQUESTCODEss = 1423;
    String value1, value2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_interview);

        ActivityStartInterviewBinding binding = ActivityStartInterviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.START.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handOverInformation();
                Intent intent = new Intent(StartInterview.this, Choose_interviewer.class);
                intent.putExtra("key1", value1);
                intent.putExtra("key2", value2);
                startActivityForResult(intent, REQUESTCODEss);
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

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUESTCODEss && resultCode == RESULT_OK) {
            String str = data.getStringExtra("key2");
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }
    }*/
}