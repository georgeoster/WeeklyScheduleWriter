package weeklyschedulewriter;

import java.util.ArrayList;

/*
 * @author george oster
 */

public class WeeklySchedule {

    ArrayList<Shift> shiftsForWeek;
    
    public WeeklySchedule() {
        shiftsForWeek = new ArrayList();
    }

    public WeeklySchedule(ArrayList<Shift> shiftsForWeek) {
        this.shiftsForWeek = shiftsForWeek;
    }

    public ArrayList<Shift> getShiftsForWeek() {
        return shiftsForWeek;
    }

    public void setShiftsForWeek(ArrayList<Shift> shiftsForWeek) {
        this.shiftsForWeek = shiftsForWeek;
    }
    
    public void addShiftToWeek(Shift toAdd){
        this.shiftsForWeek.add(toAdd);
    }
 
    public void removeShiftFromWeek(Shift toRemove){
        this.shiftsForWeek.remove(toRemove);
    }
}
