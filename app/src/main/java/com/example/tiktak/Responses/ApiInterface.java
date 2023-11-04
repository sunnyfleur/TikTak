package com.example.tiktak.Responses;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("tiktak.php")
    Call<Users> performAllPosts();
}
