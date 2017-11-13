package weeklyschedulewriter;

import java.util.Comparator;

/**
 *
 * @author george
 */
public class HTMLShiftComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Shift thing1 = (Shift) o1;
        Shift thing2 = (Shift) o2;
        int toReturn = 0;

        if (thing1.getShift()[0] == thing2.getShift()[0] ) {
            toReturn = 0;
        }

        if (thing1.getShift()[0] > thing2.getShift()[0]) {
            toReturn = 1;
        }

        if (thing1.getShift()[0] < thing2.getShift()[0]) {
            toReturn = -1; 
        }

        return toReturn;
    }
}
