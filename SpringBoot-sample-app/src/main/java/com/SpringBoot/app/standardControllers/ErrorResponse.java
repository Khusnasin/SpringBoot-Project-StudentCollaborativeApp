package com.SpringBoot.app.standardControllers;

public class ErrorResponse {
	private String message;

    public ErrorResponse(String message) {
        this.message = "An Error occurred!";
    }

    // Getters...
    public String getmessage() {
        return message;
    }
}
