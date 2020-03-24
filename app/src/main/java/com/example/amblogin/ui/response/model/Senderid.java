package com.example.amblogin.ui.response.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Senderid {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("title")
    @Expose
    private Object title;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("userlocation")
    @Expose
    private String userlocation;
    @SerializedName("hospitalocation")
    @Expose
    private String hospitalocation;
    @SerializedName("arealocation")
    @Expose
    private String arealocation;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("receverid")
    @Expose
    private int receverid;
    @SerializedName("senderid")
    @Expose
    private Object senderid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getTitle() {
        return title;
    }

    public void setTitle(Object title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserlocation() {
        return userlocation;
    }

    public void setUserlocation(String userlocation) {
        this.userlocation = userlocation;
    }

    public String getHospitalocation() {
        return hospitalocation;
    }

    public void setHospitalocation(String hospitalocation) {
        this.hospitalocation = hospitalocation;
    }

    public String getArealocation() {
        return arealocation;
    }

    public void setArealocation(String arealocation) {
        this.arealocation = arealocation;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getReceverid() {
        return receverid;
    }

    public void setReceverid(int receverid) {
        this.receverid = receverid;
    }

    public Object getSenderid() {
        return senderid;
    }

    public void setSenderid(Object senderid) {
        this.senderid = senderid;
    }

}
