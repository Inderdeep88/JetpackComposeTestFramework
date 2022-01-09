package com.example.jetsnack.common;

import java.util.ArrayList;
import java.util.HashMap;

public class CartPageData {
    String address;
    HashMap<String, Integer> cartItems;
    ArrayList<ListOnPage> bottomList;

    public CartPageData() {
    }

    public CartPageData(String address, HashMap<String, Integer> cartItems, ArrayList<ListOnPage> bottomList) {
        this.address = address;
        this.cartItems = cartItems;
        this.bottomList = bottomList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public HashMap<String, Integer> getCartItems() {
        return cartItems;
    }

    public void setCartItems(HashMap<String, Integer> cartItems) {
        this.cartItems = cartItems;
    }

    public ArrayList<ListOnPage> getBottomList() {
        return bottomList;
    }

    public void setBottomList(ArrayList<ListOnPage> bottomList) {
        this.bottomList = bottomList;
    }
}
