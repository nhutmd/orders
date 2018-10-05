package com.local.android.orders.handler;

import android.util.Log;

import com.local.android.orders.contains.Helper;

public class LoginHandler {
    private String phone;
    private String password;
    private String message;

    public LoginHandler(String phone, String password) {
        this.phone = phone;
        this.password = password;
        this.message = "";
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getMessage() {
        return message;
    }

    public boolean validateInput(String phone, String password) {
        if (Helper.isPhone(phone)) {
            if (Helper.isNotEmpty(password)) {
                return true;
            } else {
                this.message = Helper.MESSAGES_ERROR[1];
                return false;
            }
        } else {
            this.message = Helper.MESSAGES_ERROR[0];
            return false;
        }
    }

    public boolean resultLogin() {
        return true;
    }
}
