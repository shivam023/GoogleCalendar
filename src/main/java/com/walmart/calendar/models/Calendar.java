package com.walmart.calendar.models;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Calendar {
    private HashMap<Date, Set<Event>> calendarEvents;

    public Calendar() {
        calendarEvents = new HashMap<>();
    }

    public void addCalenderEvent(Event event, Date currentDate) {
        Set<Event> events;
        if(calendarEvents.containsKey(currentDate)){
            events = calendarEvents.get(currentDate);
        }
        else{
            events = new HashSet<>();
        }
        events.add(event);
        calendarEvents.put(currentDate, events);
    }

    public HashMap<Date, Set<Event>> getCalendarEvents() {
        return calendarEvents;
    }
}
