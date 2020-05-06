package com.walmart.calendar.models;

import java.util.Iterator;
import java.util.Set;

public abstract class Event {
    private String eventId;
    private User owner;
    private TimeInterval timeInterval;
    private String title;
    private String location;
    private Set<String> guestList;

    public Event(String eventId, User owner, TimeInterval timeInterval, String title, String location, Set<String> guestList)
            throws Exception {
        this.eventId = eventId;
        this.owner = owner;
        this.timeInterval = timeInterval;
        this.title = title;
        this.location = location;
        this.guestList = guestList;
    }

    // Setters
    public void setTimeInterval(TimeInterval timeInterval) {
        this.timeInterval = timeInterval;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setGuestList(Set<String> guestList) {
        this.guestList = guestList;
    }

    public void setTitle(String title) {
        this.title = title;
    }

     public void addGuests(Set<String> guests){
         Iterator<String> it = guests.iterator();
         while (it.hasNext()){
             if(!guestList.contains(it.next())){
                 guestList.add(it.next());
             }
         }
     }

     // getters

    public String getEventId() {
        return eventId;
    }

    public String getLocation() {
        return location;
    }

    public TimeInterval getTimeInterval() {
        return timeInterval;
    }

    public String getTitle() {
        return title;
    }

    public User getOwner() {
        return owner;
    }

    public Set<String> getGuestList() {
        return guestList;
    }
}
