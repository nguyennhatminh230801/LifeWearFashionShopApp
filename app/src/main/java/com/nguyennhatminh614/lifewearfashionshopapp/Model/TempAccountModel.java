package com.nguyennhatminh614.lifewearfashionshopapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class TempAccountModel {
    @SerializedName("email")
    @Expose
    private String username;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("device_name")
    @Expose
    private String deviceName;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TempAccountModel() {
    }

    public TempAccountModel(String username, String password, String deviceName) {
        this.username = username;
        this.password = password;
        this.deviceName = deviceName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TempAccountModel)) return false;
        TempAccountModel tempAccountModel = (TempAccountModel) o;
        return Objects.equals(username, tempAccountModel.username) && Objects.equals(password, tempAccountModel.password);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
