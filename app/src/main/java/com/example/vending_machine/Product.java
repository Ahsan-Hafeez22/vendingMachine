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
/*public class Product implements Parcelable {

    private int price;
    private String name;
    private int ImageID;
    private int quantity;

    public Product() {
        super();
    }

    public Product(int price, String name, int imageID, int quantity) {
        this.price = price;
        this.name = name;
        ImageID = imageID;
        this.quantity = quantity;
    }

    protected Product(Parcel in) {
        price = in.readInt();
        name = in.readString();
        ImageID = in.readInt();
        quantity = in.readInt();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageID() {
        return ImageID;
    }

    public void setImageID(int imageID) {
        ImageID = imageID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {

           }
}*/
