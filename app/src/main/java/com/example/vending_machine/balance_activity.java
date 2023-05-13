package com.example.vending_machine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class balance_activity extends AppCompatActivity {
    EditText cash;
    Button enterBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);
        initComponents();
        settingUpListeners();
    }

    private void settingUpListeners() {
        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int balance = Integer.parseInt(cash.getText().toString());
                if(balance > 0 && (balance == 10 || balance == 20 || balance == 50|| balance == 100|| balance == 500|| balance == 1000)) {
                    Intent i = new Intent(balance_activity.this, HomeActivity.class);
                    i.putExtra("key", balance);
                    startActivity(i);
                }else{
                    Toast.makeText(balance_activity.this, "Enter in the given format", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initComponents() {
        cash = findViewById(R.id.balance_amount_input);
        enterBtn = findViewById(R.id.amount_enter);
    }
}