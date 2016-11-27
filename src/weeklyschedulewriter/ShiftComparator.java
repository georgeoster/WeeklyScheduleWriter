package weeklyschedulewriter;

import java.util.Comparator;

/*
 * @author george
 */

public class ShiftComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Shift thing1 = (Shift) o1;
        Shift thing2 = (Shift) o2;
        int toReturn = 0;

        if (thing1.getCanBeCoveredBy().size() == thing2.getCanBeCoveredBy().size()) {
            toReturn = 0;
        }

        if (thing1.getCanBeCoveredBy().size() > thing2.getCanBeCoveredBy().size()) {
            toReturn = 1;
        }

        if (thing1.getCanBeCoveredBy().size() < thing2.getCanBeCoveredBy().size()) {
            toReturn = -1; 
        }

        return toReturn;
    }

}
