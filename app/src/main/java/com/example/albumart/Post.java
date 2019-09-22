package com.example.albumart;

import com.google.gson.annotations.SerializedName;

public class Post {

    public Post(String title, String artist, String url, String imageUrl, String thumbnilImageUrl) {
        this.title = title;
        this.artist = artist;
        this.url = url;
        this.imageUrl = imageUrl;
        this.thumbnilImageUrl = thumbnilImageUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setThumbnilImageUrl(String thumbnilImageUrl) {
        this.thumbnilImageUrl = thumbnilImageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getUrl() {
        return url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getThumbnilImageUrl() {
        return thumbnilImageUrl;
    }

    private String title;
   private String artist;
   private String url;

   @SerializedName("image")
   private String imageUrl;

   @SerializedName("thumbnail_image")
   private String thumbnilImageUrl;
}
