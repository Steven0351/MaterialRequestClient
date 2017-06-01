package com.stevensherry;

/**
 * Created by steven.sherry on 6/1/2017.
 */
public class User {

    private String uuid;
    private String authToken;
    private String role;

    public User(String uuid, String authToken, String role) {
        this.uuid = uuid;
        this.authToken = authToken;
        this.role = role;
    }

    public String getUuid() {
        return uuid;
    }

    public String getAuthToken() {
        return authToken;
    }

    public String getRole() {
        return role;
    }
}
