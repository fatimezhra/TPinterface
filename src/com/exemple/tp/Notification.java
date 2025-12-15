package com.exemple.tp;

public interface Notification {
    void send(String recipient, String message);
    int getPriority();
    String getType();
}