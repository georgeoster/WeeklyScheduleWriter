package weeklyschedulewriter;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * @author george
 */
public class Employee implements Serializable{

    String name;
    ArrayList<String> jobroles;
    ArrayList<Shift> shiftsThisWeek;
    int availability[];
    int minHours;
    int maxHours;
    int currentlyScheduledHours;
    int remainingSchedulableHours;
    boolean alreadyScheduledOn[] = {false, false, false, false, false, false, false};
    int numberOfShiftsICanCover;

    /*
    availability[] is an int array that represents the employees availability for every day of the week.
    the format is: {daycode, startTime, endTime, daycode, startTime, endTime, daycode, startTime, endTime ...}
    ie:{1,8,21,2,0,24...} means: monday(1) available from 8am(8) to 9pm(21) , tuesday(2) available from midnight(0) to midnight(24). ...
    1 is 1am, 2 is 2am, ... , 11 is 11am, 12 is noon, 13 is 1pm, 14 is 2pm, etc 
     */
    
    public Employee(String name) {
        this.name = name;
        this.jobroles = new ArrayList();
        this.availability = new int[21];
        this.minHours = 0;
        this.maxHours = 0;
        this.currentlyScheduledHours = 0;
        this.numberOfShiftsICanCover = 0;
        this.shiftsThisWeek = new ArrayList();
    }

    public String getName() {
        return name;
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

    public int getRemainingSchedulableHours() {
        return remainingSchedulableHours;
    }

    public boolean[] getAlreadyScheduledOn() {
        return alreadyScheduledOn;
    }

    public void setAlreadyScheduledOn(boolean[] alreadyScheduledOn) {
        this.alreadyScheduledOn = alreadyScheduledOn;
    }
    
    public void setSpecificAlreadyScheduledOn(int i, boolean value){
        this.alreadyScheduledOn[i] = value;
    }

    public int getNumberOfShiftsICanCover() {
        return numberOfShiftsICanCover;
    }

    public void setNumberOfShiftsICanCover(int numberOfShiftsICanCover) {
        this.numberOfShiftsICanCover = numberOfShiftsICanCover;
    }
    
    public void addShiftsThisWeek(Shift toAdd){
        this.shiftsThisWeek.add(toAdd);
    }

    public void whoAmI() {
        System.out.println("name: " + this.name);
        System.out.print("job roles: ");
        for (int i = 0; i < this.jobroles.size(); i++) {
            System.out.println(this.jobroles.get(i));
        }
        System.out.println("availability is: ");
        System.out.println("monday " + this.availability[1] + " to " + this.availability[2]);
        System.out.println("tuesday " + this.availability[4] + " to " + this.availability[5]);
        System.out.println("wednesday " + this.availability[7] + " to " + this.availability[8]);
        System.out.println("thursday " + this.availability[10] + " to " + this.availability[11]);
        System.out.println("friday " + this.availability[13] + " to " + this.availability[14]);
        System.out.println("satday " + this.availability[16] + " to " + this.availability[17]);
        System.out.println("sunday " + this.availability[19] + " to " + this.availability[20]);

        System.out.println("min hours: " + this.minHours);
        System.out.println("max hours: " + this.maxHours);
    }

    public boolean canWork(Shift toCover) {//will return true if employee knows jobrole, and is availabile for those hours on that day and shift will not put employee into overtime

        boolean toReturn = false;

        if (hasJobRole(toCover)) {

            if (isAvailableToWorkShift(toCover)) {

                if (!willPutIntoOvertime(toCover)) {
                    toReturn = true;
                }

            }

        }
        return toReturn;
    }

    public boolean hasJobRole(Shift toCover) {//returns true if employee knows jobRole
        
        boolean toReturn = false;
        
        for (int i = 0; i < this.jobroles.size(); i++) {
        
            if (toCover.jobrole.equals(this.jobroles.get(i))) {
                toReturn = true;
                break;//as soon as jobrole matches, there is no need to continue checking
            }
        }
        return toReturn;
    }

    public boolean isAvailableToWorkShift(Shift toCover) {//returns true if employee is available for those hours on that day
        
        boolean toReturn = false;
       
        if (!isAlreadyScheduledOn(toCover)) { //employee not already scheduled for that day

            for (int j = 0; j < 21; j = j + 3) {  //iterates 0,3,6etc  until daycode matches

                if (toCover.shift[0] == this.availability[j] 
                        && toCover.shift[1] >= this.availability[j + 1] //employee is available from start time
                        && toCover.shift[2] <= this.availability[j + 2]) {  //employee is avaiable until end time

                    toReturn = true;
                    break;
                }
            }
        }
        return toReturn;

    }

    public boolean willPutIntoOvertime(Shift toCover) {//returns true if shift will push employee into overtime 
        boolean toReturn = false;

        if ((this.currentlyScheduledHours + (toCover.shift[2] - toCover.shift[1])) > this.maxHours) {
            toReturn = true;
            }
        return toReturn;
    }

    public boolean isAlreadyScheduledOn(Shift toCover) {//returns true if employee is already scheduled on that day

        return this.alreadyScheduledOn[toCover.shift[0] - 1];

        /*
       toCover.shift[0] is daycode = 1 for monday, 2 for tuesday, ... , 7 for sunday
       alreadyScheduledOn[0] is boolean = true/false for monday
       
       we want to check for monday:
       toCover.shift[0] = 1
       we need to check alreadyScheduledOn[0].
       so: alreadyScheduledOn[ toCover.shift[0] -1 ]  
       
       we want to check for tuesday:
       toCover.shift[0] = 2
       we need to check alreadyScheduledOn[1]
       so: alreadyScheduldedOn[ toCover-shift[0] -1 ]
         */
    }
}