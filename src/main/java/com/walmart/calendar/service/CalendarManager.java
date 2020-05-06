package com.walmart.calendar.service;

import com.walmart.calendar.models.Date;
import com.walmart.calendar.models.User;
import com.walmart.calendar.models.Event;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

// Singleton
public class CalendarManager {
    private HashMap<String, Event> eventIdMap;
    private HashMap<String, User> userIdMap;
    private TreeMap<Date, Set<Event>> dateWiseEvents;
    private Set<User> registeredUsers;

    private static CalendarManager calendarManager = null;

    private CalendarManager() {
        registeredUsers = new HashSet<>();
        // Initializing default registered users
        registeredUsers.add(new User("test@gmail.com"));
        registeredUsers.add(new User("xyz@gmail.com"));
        registeredUsers.add(new User("test1@yahoo.com"));
        userIdMap = new HashMap<>();
        eventIdMap = new HashMap<>();
        dateWiseEvents = new TreeMap<>();
    }

    public static CalendarManager getInstance() {
        if(calendarManager == null){
            calendarManager = new CalendarManager();
        }
        return calendarManager;
    }

    public TreeMap<Date, Set<Event>> getDateWiseEvents() {
        return dateWiseEvents;
    }

    public void addEventId(Event event, String eventId) {
        if(! eventIdMap.containsKey(eventId)){
            eventIdMap.put(eventId, event);
        }
    }

    public void addUserIdMap(String userId){
        if(! userIdMap.containsKey(userId)){
            User user = new User(userId);
            registeredUsers.add(user);
            userIdMap.put(userId, user);
        }
    }

    public User getUserIdMap(String userId) throws Exception {
        if(! userIdMap.containsKey(userId)){
            return userIdMap.get(userId);
        }
        throw new Exception("User Id is invalid!");
    }

    public void addEventToDate(Date localDate, Event event) {
        Set<Event> events;
        if(dateWiseEvents.containsKey(localDate)) {
            events = dateWiseEvents.get(localDate);
        }
        else{
            events = new HashSet<>();
        }
        events.add(event);
        dateWiseEvents.put(localDate, events);
    }
}
