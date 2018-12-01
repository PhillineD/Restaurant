package com.example.phill.restaurant;

public class MenuItem {

    private final String name, description, category;
    private final int price;

    public MenuItem(String name, String description, int price, String category ) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
      
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
