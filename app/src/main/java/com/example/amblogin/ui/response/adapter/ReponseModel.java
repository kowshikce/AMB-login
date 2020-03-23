package com.example.amblogin.ui.response.adapter;

public class ReponseModel {

    public String profileId;
    public String message;

    public ReponseModel(String profileId, String message) {
        this.profileId = profileId;
        this.message = message;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
