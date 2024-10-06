package com.vrl.dto;

import org.springframework.web.context.request.WebRequest;

import java.util.Date;

public class ErrorDetails {

    private String errorMessage;
    private Date date;
    private String WebRequest;

    public ErrorDetails(String errorMessage, Date date, String webRequest) {
        this.errorMessage = errorMessage;
        this.date = date;
        WebRequest = webRequest;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getWebRequest() {
        return WebRequest;
    }

    public void setWebRequest(String webRequest) {
        WebRequest = webRequest;
    }
}
