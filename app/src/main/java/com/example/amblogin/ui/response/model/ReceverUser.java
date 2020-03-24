
package com.example.amblogin.ui.response.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReceverUser {

    @SerializedName("pk")
    @Expose
    private int pk;
    @SerializedName("titel")
    @Expose
    private String titel;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("ammount")
    @Expose
    private String ammount;
    @SerializedName("receverid")
    @Expose
    private Receverid receverid;
    @SerializedName("senderid")
    @Expose
    private Object senderid;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAmmount() {
        return ammount;
    }

    public void setAmmount(String ammount) {
        this.ammount = ammount;
    }

    public Receverid getReceverid() {
        return receverid;
    }

    public void setReceverid(Receverid receverid) {
        this.receverid = receverid;
    }

    public Object getSenderid() {
        return senderid;
    }

    public void setSenderid(Object senderid) {
        this.senderid = senderid;
    }

}
