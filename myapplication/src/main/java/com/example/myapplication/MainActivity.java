package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    byte[] buffer = null;
    File file;
    private DBOpenHelper DBOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBOpenHelper  = new DBOpenHelper(MainActivity.this,"db_dict",null,1);

        final EditText eText = findViewById(R.id.tv1);
        Button save = (Button) findViewById(R.id.save);
        Button cancel = findViewById(R.id.cancel);

        file = new File(Environment.getDataDirectory(),"text.txt");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//保存文件操作
                FileOutputStream fos = null;
                String text = eText.getText().toString();
                try {
                    fos = new FileOutputStream(file);
                    fos.write(text.getBytes());
                    fos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(fos!=null){
                        try {
                            fos.close();
                            Toast.makeText(MainActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            buffer = new byte[fis.available()];
            fis.read(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis!=null){
                try {
                    fis.close();
                    String data = new String(buffer);
                    eText.setText(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                finish();
            }
        });
    }
}
