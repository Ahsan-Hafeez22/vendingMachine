package com.example.vending_machine;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Product{
    public String name;
    public int price;
    public int ImageID;
    public int quantity;

    public Product(String name, int price, int ImageID, int quantity){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.ImageID = ImageID;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setImageID(int imageID) {
        ImageID = imageID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getImageID() {
        return ImageID;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }
}