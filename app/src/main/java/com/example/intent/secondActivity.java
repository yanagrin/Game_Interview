package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.intent.databinding.ActivitySecondBinding;

public class secondActivity extends AppCompatActivity {
    final static int REQUESTCODEs = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivitySecondBinding binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.BT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(secondActivity.this, thirdActivity.class);
                intent.putExtra("key1", "Михаил");
                startActivityForResult(intent, REQUESTCODEs);
                /*Intent intent = new Intent(
                        RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        "en-US");
                try {
                    startActivityForResult(intent, REQUESTCODEs);
                } catch (ActivityNotFoundException a) {
                    Toast.makeText(getApplicationContext(),
                            "текст не распознан",
                            Toast.LENGTH_SHORT).show();
                }*/
            }
        });
        binding.BT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(secondActivity.this, thirdActivity.class);
                intent.putExtra("key1", "Диана");
                startActivityForResult(intent, REQUESTCODEs);
            }
        });

        binding.BACK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intentt = getIntent();
                int number = intentt.getIntExtra("number", 0);
                number--;*/
                /*Intent intent = new Intent();
                intent.putExtra("key2", "Вы вышли из ACTIVITY2");
                setResult(RESULT_OK, intent);*/
                finish();
            }
        });


    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUESTCODEs && resultCode == RESULT_OK) {
            String str = data.getStringExtra("key2");
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }
    }*/
}
