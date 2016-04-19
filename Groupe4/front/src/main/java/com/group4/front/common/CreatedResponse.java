package com.group4.front.common;

public class CreatedResponse {
    private Integer id;
    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CreatedResponse{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
