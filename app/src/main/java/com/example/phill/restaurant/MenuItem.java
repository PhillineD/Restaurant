package com.example.phill.restaurant;

public class MenuItem {

    private final String name, description, category, image;
    private final int price;

    public String getImage() {
        return image;
    }

    public MenuItem(String name, String description, int price, String category , String image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.image = image;
      
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }
}
