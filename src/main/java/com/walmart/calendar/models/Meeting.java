package com.walmart.calendar.models;

import java.util.Set;

public class Meeting extends Event {

    private Meeting(MeetingBuilder meetingBuilder) throws Exception {
        super(meetingBuilder.id, meetingBuilder.owner, meetingBuilder.timeInterval, meetingBuilder.title,
                meetingBuilder.location, meetingBuilder.guestList);
    }

    public static class MeetingBuilder{
        private String id;
        private User owner;
        private TimeInterval timeInterval;

        // optional
        private String title;
        private String location;
        private Set<String> guestList;
        public MeetingBuilder(String id, User owner, TimeInterval timeInterval){
            this.id = id;
            this.owner = owner;
            this.timeInterval = timeInterval;
        }

        public MeetingBuilder setTitle(String title){
            this.title = title;
            return this;
        }

        public MeetingBuilder setLocation(String location){
            this.location = location;
            return this;
        }

        public MeetingBuilder setGuestList(Set<String> guestList){
            this.guestList = guestList;
            return this;
        }

        public Meeting build() throws Exception {
            return new Meeting(this);
        }
    }
}
