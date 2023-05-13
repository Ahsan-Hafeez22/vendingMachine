package com.example.vending_machine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email, pass;
    Button login, signup;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        settingUpListeners();
        Boolean check = pref.getBoolean("flag", false);
        Intent iNext;
        if (check) {//already logged in
            iNext = new Intent(MainActivity.this, balance_activity.class);
            startActivity(iNext);
        }
    }
    private void initComponents() {
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        signup = findViewById(R.id.signup_btn);
        login = findViewById(R.id.login_btn);
        pref = getSharedPreferences("user_info", 0);

    }
    private void settingUpListeners() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String user_email = email.getText().toString();
                String user_password = pass.getText().toString();

                String registerEmail = pref.getString("userEmail", "");
                String registerPassword = pref.getString("password","");

                if(user_email.equals(registerEmail) && user_password.equals(registerPassword)){
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putBoolean("flag", true);
                    editor.apply();
                    Intent i_register = new Intent(MainActivity.this, balance_activity.class);
                    startActivity(i_register);
                }
                else {
                    Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_home = new Intent(MainActivity.this, signupActivity.class);
                startActivity(i_home);
            }
        });
    }
}