package weeklyschedulewriter;

import java.util.ArrayList;

/*
 * @author george oster
 */

public class EmployeeRoster {

    ArrayList<Employee> myEmps = new ArrayList();

    public EmployeeRoster() {
    }

    public EmployeeRoster(ArrayList<Employee> myEmps){
        this.myEmps = myEmps;
    }
    
    public ArrayList<Employee> getMyEmps() {
        return myEmps;
    }

    public void setMyEmps(ArrayList<Employee> myEmps) {
        this.myEmps = myEmps;
    }
    
    public void addEmployee(Employee emp) {
        this.myEmps.add(emp);
    }

    public void deleteEmployee(Employee emp) {
        this.myEmps.remove(emp);
    }

    public String toString() {
        String toReturn = "";

        for (int i = 0; i < this.myEmps.size(); i++) {
            toReturn = toReturn + "\n" + this.myEmps.get(i).name;
        }

        return toReturn;
    }

}
