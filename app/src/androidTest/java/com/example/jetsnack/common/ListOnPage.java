package com.example.jetsnack.common;

import java.util.ArrayList;

public class ListOnPage {
    String name;
    ListOnPageType type;
    ArrayList<String> snacks;

    public ListOnPage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ListOnPageType getType() {
        return type;
    }

    public void setType(ListOnPageType type) {
        this.type = type;
    }

    public ArrayList<String> getSnacks() {
        return snacks;
    }

    public void setSnacks(ArrayList<String> snacks) {
        this.snacks = snacks;
    }

    public ListOnPage() {
    }
}
