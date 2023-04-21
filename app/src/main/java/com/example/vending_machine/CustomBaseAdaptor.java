package com.example.vending_machine;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;


public class CustomBaseAdaptor extends BaseAdapter {

    private final ArrayList<Product> myList;
    LayoutInflater inflater;

    public CustomBaseAdaptor(Context ctx, ArrayList<Product> items){
        myList = items;
        inflater = LayoutInflater.from(ctx);
    }
    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int i) {
        return myList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("SetTextI18n")
    public View getView(int i, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = inflater.inflate(R.layout.custom_list_view, null );
        }
        Product currentItem = myList.get(i);
        ImageView images = convertView.findViewById(R.id.imageIcon);
        TextView items = convertView.findViewById(R.id.itemText);
        TextView quantity = convertView.findViewById(R.id.itemQuantity);
        TextView price = convertView.findViewById(R.id.itemPrice);

        items.setText(currentItem.getName());
        price.setText(String.valueOf(currentItem.getPrice()));
        quantity.setText(String.valueOf(currentItem.getQuantity()));
        images.setImageResource(currentItem.getImageID());
        return convertView;
    }
}
/*public class CustomBaseAdaptor extends BaseAdapter {
    private final Context context;
    private final ArrayList<String> items;
    private final ArrayList<Integer> images;
    private final ArrayList<Integer> price;
    private final ArrayList<Integer> quantity;
    LayoutInflater inflater;
    public CustomBaseAdaptor(Context ctx, ArrayList<String> items, ArrayList<Integer> images, ArrayList<Integer> price, ArrayList<Integer> quantity){
        this.context = ctx;
        this.items = items;
        this.images = images;
        this.price = price;
        this.quantity = quantity;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.custom_list_view, null );
        TextView txtView = (TextView) convertView.findViewById(R.id.itemText);
        ImageView imgView = (ImageView) convertView.findViewById(R.id.imageIcon);
        TextView quantityView = (TextView) convertView.findViewById(R.id.itemQuantity);
        TextView priceView = (TextView) convertView.findViewById(R.id.itemPrice);
        txtView.setText(items.get(i));
        imgView.setImageResource(images.get(i));
        quantityView.setText(String.valueOf(quantity.get(i)));
        priceView.setText(String.valueOf(price.get(i)));

        return convertView;
    }
}*/


/*package com.example.vendingmachine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdaptor extends BaseAdapter {
    private Context context;
    private ArrayList<Product> myList;
    private LayoutInflater inflater;

    public MyAdaptor(Context c ,ArrayList<Product> list){
        context = c;
        myList = list;
        inflater = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int i) {
        return myList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view = inflater.inflate(R.layout.my_layout,viewGroup,false);
        }
        ImageView p_img = view.findViewById(R.id.p_img);
        TextView p_name = view.findViewById(R.id.p_name);
        TextView p_quantity = view.findViewById(R.id.p_quantity);
        TextView p_price = view.findViewById(R.id.p_price);
        p_img.setImageResource(R.drawable.ic_launcher_background);
        p_name.setText("KITKAT");
        p_quantity.setText("Quantity:50");
        p_price.setText("Rs.150/-");
        return view;
    }
}

 */
/*
        items.setText("Lays");
        images.setImageResource(R.drawable.lays);
        price.setText("30");
        quantity.setText("5");

        items.setText("Cheetos");
        images.setImageResource(R.drawable.cheetos);
        price.setText("45");
        quantity.setText("4");

        items.setText("Kurkure");
        images.setImageResource(R.drawable.kurkure);
        price.setText("30");
        quantity.setText("2");

        items.setText("Pringles");
        images.setImageResource(R.drawable.pringles);
        price.setText("80");
        quantity.setText("4");

        items.setText("Water");
        images.setImageResource(R.drawable.water);
        price.setText("35");
        quantity.setText("4");

        items.setText("Coke");
        images.setImageResource(R.drawable.coke);
        price.setText("45");
        quantity.setText("4");

        items.setText("Sprite");
        images.setImageResource(R.drawable.sprite);
        price.setText("45");
        quantity.setText("2");

        items.setText("Fanta");
        images.setImageResource(R.drawable.fanta);
        price.setText("45");
        quantity.setText("3");

        items.setText("Kitkat");
        images.setImageResource(R.drawable.kitkat);
        price.setText("70");
        quantity.setText("4");

        items.setText("Bounty");
        images.setImageResource(R.drawable.bounty);
        price.setText("70");
        quantity.setText("4");

        items.setText("Flakes");
        images.setImageResource(R.drawable.flakes);
        price.setText("80");
        quantity.setText("3");

        items.setText("Snickers");
        images.setImageResource(R.drawable.snickers);
        price.setText("80");
        quantity.setText("1");*/


