package com.example.foodies;


public class ModelFastFood {

    private  String price;
    private String name;
    private String description;

    ModelFastFood(String item_name, String item_description, String item_price) {

        name = item_name;
        price= item_price;
        description = item_description;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getPrice() {
        return price;
    }


    public void setPrice(String price) {
        this.price = price;
    }
}







