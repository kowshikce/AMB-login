package com.example.amblogin.UserPostRequest;

import com.google.gson.annotations.SerializedName;

public class AmbulanceResponseModel {

    @SerializedName("response")
    public String response;

    @SerializedName("pk")
    public String pk;

    @SerializedName("message")
    public String message;

    @SerializedName("userlocation")
    public String userLocation;

    @SerializedName("status")
    public String status;

    @SerializedName("hospitallocation")
    public String hospitalLocation;

    @SerializedName("arealocation")
    public String areaLocation;

    public AmbulanceResponseModel(String response, String pk, String message, String userLocation, String status, String hospitalLocation, String areaLocation) {
        this.response = response;
        this.pk = pk;
        this.message = message;
        this.userLocation = userLocation;
        this.status = status;
        this.hospitalLocation = hospitalLocation;
        this.areaLocation = areaLocation;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHospitalLocation() {
        return hospitalLocation;
    }

    public void setHospitalLocation(String hospitalLocation) {
        this.hospitalLocation = hospitalLocation;
    }

    public String getAreaLocation() {
        return areaLocation;
    }

    public void setAreaLocation(String areaLocation) {
        this.areaLocation = areaLocation;
    }
}
