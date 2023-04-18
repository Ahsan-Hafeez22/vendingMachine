package com.example.vending_machine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signupActivity extends AppCompatActivity {
    EditText name, email, pass, re_pass;
    Button register, cancel;
    SharedPreferences pref;
/*    SharedPreferences pref = getSharedPreferences("user_info", MODE_PRIVATE);*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initComponents();
        settingUpListeners();
    }
    private void initComponents() {
        name = findViewById(R.id.name);
        email = findViewById(R.id.signup_email);
        pass = findViewById(R.id.signup_password);
        re_pass = findViewById(R.id.re_password);
        register = findViewById(R.id.signup_register_btn);
        cancel = findViewById(R.id.signup_cancel_btn);
        pref = getSharedPreferences("user_info", 0);
    }
    private void settingUpListeners() {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String nameValue = name.getText().toString();
                    String emailValue = email.getText().toString();
                    String passwordValue = pass.getText().toString();
                    String re_passwordValue = re_pass.getText().toString();
                    if(passwordValue.equals(re_passwordValue)) {
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("username", nameValue);
                        editor.putString("userEmail", emailValue);
                        editor.putString("password", passwordValue);
                        editor.putString("re_password", re_passwordValue);
                        editor.apply();
                        Toast.makeText(signupActivity.this, "User Registered", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(signupActivity.this, "Password do not match", Toast.LENGTH_SHORT).show();
                    }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setText("");
                email.setText("");
                pass.setText("");
                re_pass.setText("");
                Intent i = new Intent(signupActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}