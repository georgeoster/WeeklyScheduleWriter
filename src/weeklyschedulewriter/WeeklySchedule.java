package weeklyschedulewriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * @author george oster
 */

public class WeeklySchedule implements Serializable{

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
    
    public void writeToFile(WeeklySchedule toWrite, String filename) throws IOException {
        WeeklyScheduleReaderWriter temp = new WeeklyScheduleReaderWriter();
        temp.writeToFile(toWrite, filename);
    }

    public WeeklySchedule readFromFile(String filename) throws IOException, FileNotFoundException, ClassNotFoundException {
        WeeklyScheduleReaderWriter temp = new WeeklyScheduleReaderWriter();
        return temp.readFromFile(filename);
    }
    
}
