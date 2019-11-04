package com.example.clickbtn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btna = findViewById(R.id.btn1);
        final RadioGroup rdga = findViewById(R.id.rdg);

        rdga.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.nan){
                    Toast.makeText(MainActivity.this, "nan", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "vn", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DetialActivity.class);
                ComponentName componentName = new ComponentName("com.example.clickbtn","com.example.clickbtn.DetialActivity");
                intent.setComponent(componentName);
                startActivity(intent);
            }
        });
    }
}
