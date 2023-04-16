package com.example.ca4;

public class Items {
    String  name,manu,cat;
    int price,stock;
    public Items() {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {return price; }

    public void setPrice(int price) {this.price = price; }

    public String getManu() {
        return manu;
    }

    public void setManu(String manu) {
        this.manu = manu;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public int getStock() {return stock; }

    public void setStock(int stock) {this.stock = stock; }

    public Items(String name, int price, String manu, String cat, int stock) {
        this.name = name;
        this.price = price;
        this.manu = manu;
        this.cat = cat;
        this.stock=stock;
    }
}
