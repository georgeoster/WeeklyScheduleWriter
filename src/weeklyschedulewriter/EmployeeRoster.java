package weeklyschedulewriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/*
 * @author george oster
 */

public class EmployeeRoster {

    ArrayList<Employee> employees;

    public EmployeeRoster() {
        this.employees = new ArrayList();
    }

    public EmployeeRoster(ArrayList<Employee> myEmps){
        this.employees = myEmps;
    }
    
    public ArrayList<Employee> getMyEmps() {
        return employees;
    }

    public void setMyEmps(ArrayList<Employee> myEmps) {
        this.employees = myEmps;
    }
    
    public void addEmployee(Employee emp) {
        this.employees.add(emp);
    }

    public void deleteEmployee(Employee emp) {
        this.employees.remove(emp);
    }

    public String toString() {
        String toReturn = "";

        for (int i = 0; i < this.employees.size(); i++) {
            toReturn = toReturn + "\n" + this.employees.get(i).name;
        }

        return toReturn;
    }
    
    public void writeToFile(EmployeeRoster toWrite, String filename) throws IOException {
        EmployeeRosterReaderWriter temp = new EmployeeRosterReaderWriter();
        temp.writeToFile(toWrite, filename);
    }

    public EmployeeRoster readFromFile(String filename) throws IOException, FileNotFoundException, ClassNotFoundException {
        EmployeeRosterReaderWriter temp = new EmployeeRosterReaderWriter();
        return temp.readFromFile(filename);
    }

}
