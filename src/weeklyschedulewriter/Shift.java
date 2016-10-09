package weeklyschedulewriter;

/*
 * @author george oster
 */

public class Shift {
 
    String jobrole;
    int shift[];
    
    /*
    shift[] is an int array that represents the shift.
    the format is: {daycode, startTime, endTime}
    ie:{1,8,21} means: monday(1) from 8am(8) to 9pm(21)
    ie:{2,6,13} means: tuesday(2) from 6am(6) to 1pm(13)
    */
    
    boolean isCovered = false;
    Employee coveredBy;
    
    public Shift (){
    }
    
    public Shift (String jobrole, int[] shift){
        this.jobrole=jobrole;
        this.shift = shift;
    }
    
    public void setCoveredBy(Employee coveredBy){
        this.coveredBy = coveredBy;
        this.isCovered = true;
    }

    public String getJobrole() {
        return jobrole;
    }

    public void setJobrole(String jobrole) {
        this.jobrole = jobrole;
    }
    
    public int[] getShift() {
        return shift;
    }

    public void setShift(int[] shift) {
        this.shift = shift;
    }
    
}
