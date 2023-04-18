package com.example.vending_machine;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomBaseAdaptor extends ArrayAdapter<String> {

    private final Context context;
    private final ArrayList<String> items;
    private final ArrayList<Integer> images;
    private final ArrayList<Integer> price;
    private final ArrayList<Integer> quantity;
    LayoutInflater inflater;

    public CustomBaseAdaptor(Activity ctx, ArrayList<String> items, ArrayList<Integer> images, ArrayList<Integer> price, ArrayList<Integer> quantity){
        super(ctx, R.layout.custom_list_view, items);
        this.context = ctx;
        this.items = items;
        this.images = images;
        this.price = price;
        this.quantity = quantity;
        inflater = LayoutInflater.from(ctx);
    }


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
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
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
