package org.motechproject.mHealthDataInterface.config.bean;


/**
 * Created on 15-07-2016.
 */
public class ApplicationSettings {
    private String baseUrl;//openmrs base url
    private String username;//openmrs username
    private String password;//openmrs password
    private String dbUrl;
    private String dbDriver;
    private String dbUsername;
    private String dbPassword;
    private String errorMessage;

    public ApplicationSettings() {
    }

    public ApplicationSettings(String baseUrl, String username, String password, String dbUrl, String dbDriver, String dbUsername, String dbPassword, String errorMessage) {
        this.baseUrl = baseUrl;
        this.username = username;
        this.password = password;
        this.dbUrl = dbUrl;
        this.dbDriver = dbDriver;
        this.dbUsername = dbUsername;
        this.dbPassword = dbPassword;
        this.errorMessage = errorMessage;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
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

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbDriver() {
        return dbDriver;
    }

    public void setDbDriver(String dbDriver) {
        this.dbDriver = dbDriver;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
