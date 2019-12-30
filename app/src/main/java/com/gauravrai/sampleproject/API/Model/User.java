package com.gauravrai.sampleproject.API.Model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("userId")
    String userId;

    @SerializedName("id")
    String id;

    @SerializedName("title")
    String title;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
