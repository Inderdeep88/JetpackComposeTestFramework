package com.example.jetsnack.common;

public class Snack_1 {
    Long id;
    String name;
    String imageUrl;
    Long price;
    String tagline;

    public Snack_1() {
    }

    public Snack_1(Long id, String name, String imageUrl, Long price, String tagline) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.tagline = tagline;
    }

    public Snack_1(Snack_1 s) {
        this.id = s.id;
        this.name = s.name;
        this.imageUrl = s.imageUrl;
        this.price = s.price;
        this.tagline = s.tagline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }
}
