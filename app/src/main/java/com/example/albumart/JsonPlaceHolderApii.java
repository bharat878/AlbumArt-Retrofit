package com.example.albumart;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApii {

    @GET("music_albums")
    Call<List<Post>> getPosts();
}
