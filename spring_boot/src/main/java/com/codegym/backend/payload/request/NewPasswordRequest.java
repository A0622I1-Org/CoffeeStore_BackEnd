package com.codegym.backend.payload.request;

public class NewPasswordRequest {
    private String newPassword;
    private String code;

    public NewPasswordRequest() {
    }

    public NewPasswordRequest(String newPassword, String code) {
        this.newPassword = newPassword;
        this.code = code;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
