package com.example.amblogin.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignupResp {

    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("pk")
    @Expose
    private int pk;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("mobile_number")
    @Expose
    private String mobileNumber;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("token")
    @Expose
    private String token;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}