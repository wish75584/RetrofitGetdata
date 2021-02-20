package com.felixtechlabs.retrofitgetdata.model;

public class Posts {

    int userId, id;
    String title, body, mImages;

    public Posts(int userId, int id, String title, String body, String mImages) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
        this.mImages = mImages;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getmImages() {
        return mImages;
    }

    public void setmImages(String mImages) {
        this.mImages = mImages;
    }
}