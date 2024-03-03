package com.example.intent;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.intent.databinding.ActivityQuestion11Binding;

public class Question11 extends AppCompatActivity {
    final static int REQUESTCODEss = 1423;
    String question, ans1, ans2, ans3, chooseAns="10", value1, value2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question11);
        ActivityQuestion11Binding binding = ActivityQuestion11Binding.inflate(getLayoutInflater());
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
                    chooseAns="10";
                }
            }
        });
        binding.V2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.V2.isChecked()) {
                    chooseAns="5";
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
                Intent intent = new Intent(Question11.this, question22.class);
                intent.putExtra("answer1", chooseAns);
                if (chooseAns!=null){
                    //Toast.makeText(Question11.this, "answer1!=null", Toast.LENGTH_SHORT).show();
                }
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
            if (value2.equals("work1")){
                question="Если бы вам пришлось выбрать между тем, чтобы все сотрудники вашего отдела носили пижамы на работу или все время говорили на обратном языке, что бы вы выбрали и почему?";
                ans1="Предпочел бы, чтобы все носили пижамы на работу – так мы могли бы проводить корпоративные собрания в уютной обстановке и делать пижамные вечеринки после рабочего дня.";
                ans2="Если все будут говорить на обратном языке, то это будет отличным способом защиты информации от посторонних. Никакие шпионы не смогут понять, что мы говорим! ";
                ans3="Говорить на обратном языке – это отличный способ улучшить коммуникацию в коллективе. Ведь когда ты не понимаешь друг друга, начинаешь ценить каждое слово!";
            }
            else {
                question="Если бы Java была бы едой, то какой бы она была и почему?";
                ans1="Java была бы как пельмени - универсальная и всегда готова к употреблению";
                ans2="Java была бы как многослойный торт - сложная, но вкусная, с разнообразными 'слоями' функциональности и возможностей";
                ans3="Java была бы как салат Цезарь - классическая, стабильная и всегда находится в центре внимания программистов!";

            }
        }
    }
}