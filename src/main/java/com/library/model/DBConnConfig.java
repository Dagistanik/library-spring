package com.library.model;

public class DBConnConfig {
    public String driver;
    public String url;
    public String username;
    public String password;

    public DBConnConfig(String driver, String url, String username, String password) {
        super();
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
