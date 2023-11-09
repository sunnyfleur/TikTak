package com.example.tiktak.SearchRecyclerView;

import com.example.tiktak.Models.MediaObject;

import java.util.ArrayList;

public class ItemData {
    public static ArrayList<Item> generateItemData(){
        ArrayList<Item> items = new ArrayList<>();
        items.add( new Item("Love","https://drive.google.com/uc?id=1DcFjrG5GxP3ZqPtI4NG7SsfHNj2cuyhf"));
        items.add( new Item("Love so stupid","https://drive.google.com/uc?id=1InwUFgjJe1vxh3GePX_dcyH8RyU8xepL"));
        items.add( new Item("Hate","https://drive.google.com/uc?id=1LGwSWX-ogslMqPLAwDti5UeVe4jfOEyi"));
        items.add( new Item("Hate so good","https://drive.google.com/uc?id=1fkqNoK_rGz2D_kFiOpeK43l-ZpkjZFuh"));
        items.add( new Item("Dumb and Broke","https://drive.google.com/uc?id=1LGwSWX-ogslMqPLAwDti5UeVe4jfOEyi"));
        items.add( new Item("Dumb qwe","https://drive.google.com/uc?id=1LGwSWX-ogslMqPLAwDti5UeVe4jfOEyi"));

        return items;
    }
}
