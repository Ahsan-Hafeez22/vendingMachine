package com.example.vending_machine;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ArrayList<String> items = new ArrayList<>();
    ArrayList<Integer> images = new ArrayList<>();
    ArrayList<Integer> price = new ArrayList<>();
    ArrayList<Integer> quantity = new ArrayList<>();
    ListView listview;
    TextView balance_amount, txt;
    Button confirm, lgout;
    SharedPreferences pref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initComponents();
        settingUpListeners();

        items.add("Lays");
        images.add(R.drawable.lays);
        price.add(30);
        quantity.add(5);

        items.add("Cheetos");
        images.add(R.drawable.cheetos);
        price.add(45);
        quantity.add(4);

        items.add("Kurkure");
        images.add(R.drawable.kurkure);
        price.add(30);
        quantity.add(2);

        items.add("Pringles");
        images.add(R.drawable.pringles);
        price.add(80);
        quantity.add(4);

        items.add("Water");
        images.add(R.drawable.water);
        price.add(35);
        quantity.add(4);

        items.add("Coke");
        images.add(R.drawable.coke);
        price.add(45);
        quantity.add(4);

        items.add("Sprite");
        images.add(R.drawable.sprite);
        price.add(45);
        quantity.add(2);

        items.add("Fanta");
        images.add(R.drawable.fanta);
        price.add(45);
        quantity.add(3);

        items.add("Kitkat");
        images.add(R.drawable.kitkat);
        price.add(70);
        quantity.add(4);

        items.add("Bounty");
        images.add(R.drawable.bounty);
        price.add(70);
        quantity.add(4);

        items.add("Flakes");
        images.add(R.drawable.flakes);
        price.add(80);
        quantity.add(3);

        items.add("Snickers");
        images.add(R.drawable.snickers);
        price.add(80);
        quantity.add(1);


        listview = (ListView) findViewById(R.id.custom_list_view);
        CustomBaseAdaptor customBaseAdaptor = new CustomBaseAdaptor(this, items, images, price, quantity);
        listview.setAdapter(customBaseAdaptor);

    }


    @SuppressLint("SetTextI18n")
    private void settingUpListeners() {
        Intent intent = getIntent();
        int value = intent.getIntExtra("key", 0);
        String newText = String.valueOf(value);
        balance_amount.setText(newText+"Rs" );
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        lgout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("flag", false);
                editor.apply();
                Intent Ilogout = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(Ilogout);
            }
        });
    }
    /*
int index = 1; // index of the element to decrement
int decrementBy = 3; // amount to decrement by

int oldValue = numbers.get(index); // get the current value
int newValue = oldValue - decrementBy; // calculate the new value

numbers.set(index, newValue); // set the new value at the specified index*/

    private void initComponents() {
        balance_amount = findViewById(R.id.amount);
        confirm = findViewById(R.id.item_confirm_button);
        txt = findViewById(R.id.itemText);
        lgout = findViewById(R.id.logout);
        pref = getSharedPreferences("user_info", 0);

    }
}