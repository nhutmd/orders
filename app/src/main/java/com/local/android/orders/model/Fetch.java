package com.local.android.orders.model;

import com.google.gson.annotations.SerializedName;

public class Fetch {
    @SerializedName("status")
    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
