package com.walmart.calendar.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class MeetingRoom {
    private String meetingId;
    private String roomName;
    private Integer roomCapacity;
    private HashMap<LocalDate, ArrayList<Event>> bookedEvents;
}
