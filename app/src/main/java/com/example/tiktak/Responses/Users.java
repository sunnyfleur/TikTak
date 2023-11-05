package com.example.tiktak.Responses;

import com.example.tiktak.Models.MediaObject;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Users {
    @SerializedName("ALL_POSTS")
    private ArrayList<MediaObject> AllPosts;

    public ArrayList<MediaObject> getAllPosts() {
        return AllPosts;
    }
}
