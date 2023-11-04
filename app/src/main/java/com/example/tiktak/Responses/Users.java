package com.example.tiktak.Responses;

import com.example.tiktak.Models.MediaObject;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Users {
    @SerializedName("ALL_FILES")
    private List<MediaObject> AllPosts;

    public List<MediaObject> getAllPosts() {
        return AllPosts;
    }
}
