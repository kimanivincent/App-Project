package com.example.vince.e_health;

public class Item {
    String username,password;

    public Item(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Item(String first, String second, String id, String simu, String arafa, String wote, String kichwa, String male, String female) {

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
}
