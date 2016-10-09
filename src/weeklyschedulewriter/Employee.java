package weeklyschedulewriter;

import java.util.ArrayList;

/*
 * @author george oster
 */

public class Employee {

    String name;
    ArrayList<String> jobroles;
    int availability[];
    int minHours;
    int maxHours;
    int currentlyScheduledHours;
    boolean alreadyScheduledOn[] = {false, false, false, false, false, false, false};

    /*
    availability[] is an int array that represents the employees availability for every day of the week.
    the format is: {daycode, startTime, endTime, daycode, startTime, endTime, daycode, startTime, endTime ...}
    ie:{1,8,21,2,0,24...} means: monday(1) available from 8am(8) to 9pm(21) , tuesday(2) available from midnight(0) to midnight(24). ...
    1 is 1am, 2 is 2am, ... , 11 is 11am, 12 is noon, 13 is 1pm, 14 is 2pm, etc 
    */
    
    
    public Employee(String name) {
        this.name = name;
    }

    public int getMinHours() {
        return minHours;
    }

    public void setMinHours(int minHours) {
        this.minHours = minHours;
    }

    public int getMaxHours() {
        return maxHours;
    }

    public void setMaxHours(int maxHours) {
        this.maxHours = maxHours;
    }

    public ArrayList<String> getJobroles() {
        return jobroles;
    }

    public void setJobroles(ArrayList<String> jobroles) {
        this.jobroles = jobroles;
    }

    public int[] getAvailability() {
        return availability;
    }

    public void setAvailability(int[] availability) {
        this.availability = availability;
    }

    public int getCurrentlyScheduledHours() {
        return currentlyScheduledHours;
    }

    public void setCurrentlyScheduledHours(int currentlyScheduledHours) {
        this.currentlyScheduledHours = currentlyScheduledHours;
    }

    public void whoAmI(){
        System.out.println("NAME: " + this.name);
        System.out.print("JOB ROLES: ");
        for (int i=0; i < this.jobroles.size(); i++){
            System.out.println(this.jobroles.get(i));
        }
        System.out.println("AVAILABILITY: ");
        System.out.println("monday " + this.availability[1] + " to " + this.availability[2] );
        System.out.println("tuesday " + this.availability[4] + " to " + this.availability[5] );
        System.out.println("wednesday " + this.availability[7] + " to " + this.availability[8] );
        System.out.println("thursday " + this.availability[10] + " to " + this.availability[11] );
        System.out.println("friday " + this.availability[13] + " to " + this.availability[14] );
        System.out.println("satday " + this.availability[16] + " to " + this.availability[17] );
        System.out.println("sunday " + this.availability[19] + " to " + this.availability[20] );
        
        System.out.println("MIN HOURS: " + this.minHours);
        System.out.println("MAX HOURS: " + this.maxHours);
    }

}
