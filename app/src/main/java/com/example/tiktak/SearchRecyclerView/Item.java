package com.example.tiktak.SearchRecyclerView;

import android.graphics.drawable.Drawable;

public class Item {
    private String itemName, itemLink;

    public Item(String itemName, String itemLink) {
        this.itemName = itemName;
        this.itemLink = itemLink;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemLink() {
        return itemLink;
    }

    public void setItemLink(String itemLink) {
        this.itemLink = itemLink;
    }
}
