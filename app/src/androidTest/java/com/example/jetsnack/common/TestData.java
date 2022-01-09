package com.example.jetsnack.common;

import java.util.ArrayList;
import java.util.HashMap;

public class TestData {
    ArrayList<ListOnPage> homePageData;
    ArrayList<ListOnPage> detailsPageData;
    CartPageData cartPageData;
    ArrayList<Snack_1> snacks;

    public TestData() {
    }

    public TestData(ArrayList<ListOnPage> homePageData, ArrayList<ListOnPage> detailsPageData, CartPageData cartPageData, ArrayList<Snack_1> snacks) {
        this.homePageData = homePageData;
        this.detailsPageData = detailsPageData;
        this.cartPageData = cartPageData;
        this.snacks = snacks;
    }

    public ArrayList<Snack_1> getSnacks() {
        return snacks;
    }

    public void setSnacks(ArrayList<Snack_1> snacks) {
        this.snacks = snacks;
    }

    public ArrayList<ListOnPage> getHomePageData() {
        return homePageData;
    }

    public void setHomePageData(ArrayList<ListOnPage> homePageData) {
        this.homePageData = homePageData;
    }

    public ArrayList<ListOnPage> getDetailsPageData() {
        return detailsPageData;
    }

    public void setDetailsPageData(ArrayList<ListOnPage> detailsPageData) {
        this.detailsPageData = detailsPageData;
    }

    public CartPageData getCartPageData() {
        return cartPageData;
    }

    public void setCartPageData(CartPageData cartPageData) {
        this.cartPageData = cartPageData;
    }
}

