package com.example.aboutmr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button0 = findViewById(R.id.imageButton_phone);
        Button button1 = findViewById(R.id.imageButton_sms);

        button0.setOnClickListener(l);
        button1.setOnClickListener(l);
    }

    View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            switch(view.getId()){
                case R.id.imageButton_phone:
                    intent.setAction(intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:15874853313"));
                    startActivity(intent);
                    break;
                case R.id.imageButton_sms:
                    intent.setAction(intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("smsto:15874853313"));
                    intent.putExtra("sms_body","欢迎来到峡谷险峰");
                    startActivity(intent);
                    break;
            }
        }
    };

}
