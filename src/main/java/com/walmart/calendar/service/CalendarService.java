package com.walmart.calendar.service;

import com.walmart.calendar.models.Date;
import com.walmart.calendar.models.Event;
import com.walmart.calendar.models.Meeting;
import com.walmart.calendar.models.TimeInterval;
import com.walmart.calendar.models.User;

import java.time.LocalDate;
import java.util.*;

public class CalendarService {

    private CalendarManager calendarManager = CalendarManager.getInstance();

    /**
     * This is a service for creating the meeting
     *
     * @param userId
     * @param timeInterval
     * @param title
     * @param location
     * @param guestList
     * @throws Exception
     * */
    public Event createMeeting(String userId, TimeInterval timeInterval, String title, String location, Set<String> guestList, Date date) throws Exception {
        String eventId = UUID.randomUUID().toString();
        Event event = new Meeting.MeetingBuilder(eventId, calendarManager.getUserIdMap(userId), timeInterval)
                .setLocation(location)
                .setTitle(title)
                .setGuestList(guestList).build();
        calendarManager.addEventId(event, eventId);
        calendarManager.addEventToDate(date, event);
        return event;
    }

    /**
     * This method maintains the mapping of userId (or emailId) and User instance
     *
     * @param userId
     * */
    public void addUser(String userId) {
        calendarManager.addUserIdMap(userId);
    }

    public Set<Event> fetchEventsByDateRange(String userId, Date startDate, Date endDate) throws Exception {
        User user = calendarManager.getUserIdMap(userId);
        HashMap<Date, Set<Event>> dateWiseEvents = user.getCalendar().getCalendarEvents();
        Set<Event> eventsByDateRange = new HashSet<>();
        for(Map.Entry entry : dateWiseEvents.entrySet()){
            Date date = (Date)entry.getKey();
            if(date.getYear() == startDate.getYear() && date.getYear() == endDate.getYear() && date.getDay() >= startDate.getDay()
                    && date.getDay() <=endDate.getDay() && date.getMonth() >= startDate.getMonth() && date.getMonth() <= endDate.getMonth() ){
                eventsByDateRange.add((Event) entry.getValue());
            }
        }
        return eventsByDateRange;
    }
}
