package com.example.tablelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String mr = "mr",mrsoft="mrsoft";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText usernameET = findViewById(R.id.qq);
        final EditText passwordET = findViewById(R.id.pwd);
        final Button login = findViewById(R.id.login);
        final SharedPreferences sp = getSharedPreferences("mrsoft", MODE_PRIVATE);

        String username = sp.getString("username", null);
        String password = sp.getString("password", null);

        if (username != null && password != null) {
            if (usernameET.equals(username) && passwordET.equals(password)) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            } else {
                login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String in_username = usernameET.getText().toString();
                        String in_password = passwordET.getText().toString();
                        SharedPreferences.Editor editor = sp.edit();
                        if (in_username.equals(mr) && in_password.equals(mrsoft)) {
                            editor.putString("username", in_username);
                            editor.putString("password", in_password);
                            editor.commit();
                            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                            startActivity(intent);
                            Toast.makeText(MainActivity.this, "已经保存账号和密码", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "账号或则和密码错误", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }else{
            Toast.makeText(MainActivity.this, "账号或则和密码错误", Toast.LENGTH_SHORT).show();
        }

    }
}
