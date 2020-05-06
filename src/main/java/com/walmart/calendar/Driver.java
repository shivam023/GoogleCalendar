package com.walmart.calendar;

import com.walmart.calendar.models.Date;
import com.walmart.calendar.models.Event;
import com.walmart.calendar.models.TimeInterval;
import com.walmart.calendar.models.User;
import com.walmart.calendar.service.CalendarManager;
import com.walmart.calendar.service.CalendarService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Driver {

    public static void main(String[] args) throws Exception {
        //CalendarManager calendarManager = CalendarManager.getInstance();
        CalendarService calendarService = new CalendarService();

        Scanner scanner = new Scanner(System.in);
        Event event;
        System.out.println("Please enter QUIT to exit from application");
        while(true) {
            String command = scanner.nextLine();
            String[] commands = command.split(" ");
            String commandType = commands[0];

            //
            switch (commandType){
                case "ADD_USER":
                    for (int i=1; i<commands.length; i++){
                        calendarService.addUser(commands[i]);
                    }
                    break;

                case "CREATE_MEETING":
                    int size = commands.length, i=1;
                    if(size <7){
                        System.out.println("Not enough inputs!");
                        break;
                    }
                    String userId = commands[i]; i++;
                    Integer startTime = Integer.parseInt(commands[i]); i++;
                    Integer endTime = Integer.parseInt(commands[i]); i++;
                    // format of input is dd mm yyyy
                    Integer day = Integer.parseInt(commands[i]); i++;
                    Integer month = Integer.parseInt(commands[i]); i++;
                    Integer year = Integer.parseInt(commands[i]); i++;
                    Date date = new Date(day, month, year);
                    // The next parameters are optional as the meeting can be created without following information
                    String title = "";
                    String location= "";

                    Set<String> guestList = new HashSet<>();
                    if(i<size) {
                         title = commands[i];
                        i++;
                    }
                    if(i<size) {
                         location = commands[i];
                        i++;
                    }
                    if(i<size){
                        for(int p=6; p<size; p++){
                            guestList.add(commands[i]);
                        }
                    }

                    // call to calendar service
                    calendarService.createMeeting(userId, new TimeInterval(startTime, endTime), title, location,
                            guestList, date);
                    break;

                case "UPDATE_MEETING":
                    String field = commands[1];
                   switch (field){
                       case "TITLE":
                           //
                           break;
                       case "LOCATION":
                           //
                           break;
                       case "TIME":
                           //
                           break;

                       default:
                           break;
                   }

                case "FETCH_EVENTS":
                    userId = commands[1];
                    // Assuming date in format of dd/mm/yyyy
                    String[] startDate = commands[2].split("/");
                    String[] endDate = commands[3].split("/");
                    Date startD = new Date(Integer.parseInt(startDate[0]), Integer.parseInt(startDate[1]), Integer.parseInt(startDate[2]));
                    Date endD = new Date(Integer.parseInt(endDate[0]), Integer.parseInt(endDate[1]), Integer.parseInt(endDate[2]));
                    calendarService.fetchEventsByDateRange(userId, startD, endD);

                case "QUIT":
                    System.out.println("Exiting out of the application");
                    return;

                default:
                    break;
            }
        }
    }
}
