package com.example.amblogin.ui.response.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DriverCommentModel {

    @SerializedName("pk")
    @Expose
    public String pk;

    @SerializedName("message")
    @Expose
    public String message;

    @SerializedName("userlocation")
    @Expose
    public String userlocation;

    @SerializedName("hospitalocation")
    @Expose
    public String hospitalocation;

    @SerializedName("arealocation")
    @Expose
    public String arealocation;

    @SerializedName("status")
    @Expose
    public String status;

    @SerializedName("receverid")
    @Expose
    public String receverid;

    @SerializedName("senderid")
    @Expose
    public String senderid;

    @SerializedName("recever_user")
    @Expose
    public ReceverUser[] receverUsers;

    public DriverCommentModel(String pk, String message, String userlocation, String hospitalocation, String arealocation, String status, String receverid, String senderid, ReceverUser[] receverUsers) {
        this.pk = pk;
        this.message = message;
        this.userlocation = userlocation;
        this.hospitalocation = hospitalocation;
        this.arealocation = arealocation;
        this.status = status;
        this.receverid = receverid;
        this.senderid = senderid;
        this.receverUsers = receverUsers;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReceverid() {
        return receverid;
    }

    public void setReceverid(String receverid) {
        this.receverid = receverid;
    }

    public String getSenderid() {
        return senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid;
    }

    public ReceverUser[] getReceverUsers() {
        return receverUsers;
    }

    public void setReceverUsers(ReceverUser[] receverUsers) {
        this.receverUsers = receverUsers;
    }
}
