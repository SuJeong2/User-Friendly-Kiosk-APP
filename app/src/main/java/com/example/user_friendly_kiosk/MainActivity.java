package com.example.user_friendly_kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button in_store;
    Button take_out;

    //gender 값이 0 => 남자
    //            1 => 여자
    //일단 초기값은 gender 0, age 10,
    //10살의 남자라고 설정
    int gender=0, age=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        in_store=(Button)findViewById(R.id.in_store);
        take_out=(Button)findViewById(R.id.take_out);

        in_store.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Menu.class);
                intent.putExtra("gender", gender);
                intent.putExtra("age", age);
                startActivity(intent);
            }
        });

        take_out.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Menu.class);
                intent.putExtra("gender", gender);
                intent.putExtra("age", age);
                startActivity(intent);
            }
        });

    }

}
