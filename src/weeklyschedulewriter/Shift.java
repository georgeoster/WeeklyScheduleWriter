package weeklyschedulewriter;

import java.io.Serializable;
import java.util.ArrayList;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * @author george
 */

public class Shift implements Serializable{
 
    String jobrole;
    int shift[];
    /*
    shift[] is an int array that represents the shift.
    the format is: {daycode, startTime, endTime}
    ie:{1,8,21} means: monday(1) from 8am(8) to 9pm(21)
    ie:{2,6,13} means: tuesday(2) from 6am(6) to 1pm(13)
    */
    
    ArrayList<Employee> canBeCoveredBy;//a list of every employee who can work this shift
    boolean isCovered = false;//set to true when shift is assigned to an employee
    Employee coveredBy;//obviously, the employee who will be assigned to this shift
    
    public Shift (){
        this.jobrole = "";
        this.shift = new int[3];
        this.canBeCoveredBy = new ArrayList();
    }
    
    public Shift (String jobrole, int[] shift){
        this.jobrole=jobrole;
        this.shift = shift;
        this.canBeCoveredBy = new ArrayList();
    }

    public Employee getCoveredBy() {
        return coveredBy;
    }
    
    public void setCoveredBy(Employee willWork){
        this.coveredBy = willWork;
        this.isCovered = true;
    }

    public boolean getIsCovered() {
        return isCovered;
    }

    public void setIsCovered(boolean isCovered) {
        this.isCovered = isCovered;
    }
    
    
    public int[] getShift() {
        return shift;
    }

    public void setShift(int[] shift) {
        this.shift = shift;
    }
    
    public void addCanBeCoveredBy(Employee employee){
        this.canBeCoveredBy.add(employee);
    }
    
    public void removeCanBeCoveredBy(Employee employee){
        this.canBeCoveredBy.remove(employee);
    }

    public ArrayList<Employee> getCanBeCoveredBy() {
        return canBeCoveredBy;
    }

    public void setCanBeCoveredBy(ArrayList<Employee> canBeCoveredBy) {
        this.canBeCoveredBy = canBeCoveredBy;
    }

    public String getJobrole() {
        return jobrole;
    }

    public void setJobrole(String jobrole) {
        this.jobrole = jobrole;
    }
    
    public void whoAmI(){
        System.out.println("role: " + this.jobrole);
        System.out.println(" day: " + this.shift[0]);
        System.out.println("from: " + this.shift[1]);
        System.out.println("  to: " + this.shift[2]);
    }
    
    
    public void loadCanBeCoveredBy(EmployeeRoster roster){
        int i;
        for (i=0; i < roster.getMyEmps().size(); i++){
            if ( roster.getMyEmps().get(i).canWork(this) ){
                this.canBeCoveredBy.add(roster.getMyEmps().get(i));
                roster.getMyEmps().get(i).setNumberOfShiftsICanCover( roster.getMyEmps().get(i).getNumberOfShiftsICanCover() + 1 );
            }
        }
    }
    
    
    
    
    
}