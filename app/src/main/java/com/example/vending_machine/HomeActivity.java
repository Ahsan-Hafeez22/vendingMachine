package com.example.vending_machine;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    int balance_value;
    TextView balance_amount;
    Button confirm, lgout;
    SharedPreferences pref;
    private final ArrayList<Product> productList = new ArrayList<>();
    ListView listview;
    CustomBaseAdaptor customBaseAdaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        listview = findViewById(R.id.custom_list_view);
        initComponents();
        settingUpListeners();
        initItems();

        customBaseAdaptor = new CustomBaseAdaptor(this, productList);
        listview.setAdapter(customBaseAdaptor);

    }
    private void initItems() {
        productList.add(new Product("Lays",30, R.drawable.lays, 5));
        productList.add(new Product("Cheetos",50, R.drawable.cheetos, 4));
        productList.add(new Product("Kurkure",30, R.drawable.kurkure, 5));
        productList.add(new Product("Pringles",90, R.drawable.pringles, 2));
        productList.add(new Product("Water",45, R.drawable.water, 0));
        productList.add(new Product("Coke",45, R.drawable.coke, 2));
        productList.add(new Product("Sprite",45, R.drawable.sprite, 2));
        productList.add(new Product("Fanta",45, R.drawable.fanta, 2));
        productList.add(new Product("Bounty",75, R.drawable.bounty, 2));
        productList.add(new Product("Kitkat",80, R.drawable.kitkat, 2));
        productList.add(new Product("Flakes",50, R.drawable.flakes, 2));
        productList.add(new Product("Snickers",100, R.drawable.snickers, 2));
    }

    @SuppressLint("SetTextI18n")
    private void settingUpListeners() {
        Intent intent = getIntent();
        balance_value = intent.getIntExtra("key", 0);
        String newText = String.valueOf(balance_value);
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
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Product itemIndex = productList.get(position);
                        int productPrice = itemIndex.getPrice();
                        int productQuantity = itemIndex.getQuantity();
                        if (productPrice > balance_value){
                            Toast.makeText(HomeActivity.this, "Insufficient balance", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            if (productQuantity > 0) {
                                int newValue = balance_value - itemIndex.getPrice();
                                String newText = String.valueOf(newValue);
                                itemIndex.setQuantity(productQuantity - 1);
                                balance_value -= productPrice;
                                balance_amount.setText(balance_value + "Rs");
                                customBaseAdaptor.notifyDataSetChanged();
                            }
                            else  {
                                Toast.makeText(HomeActivity.this, "Product out of Stock", Toast.LENGTH_SHORT).show();
                            }
                        }

                    }
                });
            }

        });
    }
    private void initComponents() {
        balance_amount = findViewById(R.id.amount);
        confirm = findViewById(R.id.item_confirm_button);
        lgout = findViewById(R.id.logout);
        pref = getSharedPreferences("user_info", 0);

    }
}