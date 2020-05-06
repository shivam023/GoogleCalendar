package com.walmart.calendar.models;

public class TimeInterval {
    private Integer startTime;
    private Integer endTime;

    public TimeInterval(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public boolean findOverLap(Event event) {
        if(event.getTimeInterval().getStartTime() >= startTime && event.getTimeInterval().getStartTime() <= endTime)
            return true;
        else if(event.getTimeInterval().getEndTime() >= startTime && event.getTimeInterval().getEndTime() <= endTime)
            return true;
        else if(event.getTimeInterval().getStartTime() == startTime || event.getTimeInterval().getStartTime() == endTime
                || event.getTimeInterval().getEndTime() == startTime || event.getTimeInterval().getEndTime() == endTime)
            return true;

        return false;
    }
}
