package com.walmart.calendar.models;

public class User {
    private String firstName;
    private String lastName;
    private String userId;
    private Calendar calendar;

    public User(String userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public String getUserId() {
        return userId;
    }

    public Calendar getCalendar() {
        return calendar;
    }
}
