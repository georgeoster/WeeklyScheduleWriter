package weeklyschedulewriter;

import java.util.Comparator;

/*
 * @author george
 */

public class EmployeeComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
            Employee thing1 = (Employee) o1;
            Employee thing2 = (Employee) o2;
            int toReturn = 0;
            
            //initial sort by minHours met.
            
            if( (thing1.getCurrentlyScheduledHours() >= thing1.getMinHours()) &&  (thing2.getCurrentlyScheduledHours() >= thing2.getMinHours())    ){
                toReturn = 0; // both are above their minHours, so no switch
            }
            
            if( (thing1.getCurrentlyScheduledHours() <= thing1.getMinHours()) && (thing2.getCurrentlyScheduledHours() <= thing2.getMinHours())               ){
                toReturn = 0; // both are under their minHours, so no switch
            }
            
            if( (thing1.getCurrentlyScheduledHours() < thing1.getMinHours()) && (thing2.getCurrentlyScheduledHours() >= thing2.getMinHours())               ){
                toReturn = -1; // thing1 is under minHours, thing2 is above minHours
            }
            
            if( (thing1.getCurrentlyScheduledHours() >= thing1.getMinHours()) && (thing2.getCurrentlyScheduledHours() < thing2.getMinHours())               ){
                toReturn = 1; // thing1 is above minHours, thing2 is under minHours
            }
            
    
            if (toReturn == 0) {//second sorting. sorting by numberOfShiftsICanCover, the # of shifts the employee can work
                
                if ( thing1.getNumberOfShiftsICanCover() > thing2.getNumberOfShiftsICanCover() ){
                    toReturn = 1;
                }
                else if( thing1.getNumberOfShiftsICanCover() < thing2.getNumberOfShiftsICanCover() ){
                    toReturn = -1;
                }
                else if ( thing1.getNumberOfShiftsICanCover() == thing2.getNumberOfShiftsICanCover()  ){
                    toReturn = 0;
                }
                
            }
    
    
    return toReturn;
    }
    
}