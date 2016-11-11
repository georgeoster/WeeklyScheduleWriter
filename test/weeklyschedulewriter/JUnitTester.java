/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weeklyschedulewriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static junit.framework.Assert.assertEquals;
import org.junit.Assert;

/**
 *
 * @author george
 */
public class JUnitTester {

    public JUnitTester() {
    }

    @Test
    public void testEmployeeGetJobRoles() {

        Employee george = new Employee("george");
        ArrayList<String> georgeRoles = new ArrayList();
        georgeRoles.add("chicken");
        georgeRoles.add("sausage");
        george.setJobroles(georgeRoles);

        assertEquals("[chicken, sausage]", george.getJobroles().toString());

    }

    @Test
    public void testEmployeeGetAvailability() {
        Employee george = new Employee("george");
        ArrayList<String> georgeRoles = new ArrayList();

        int[] georgeAvailability = {1, 8, 21, 2, 8, 21, 3, 8, 21, 4, 8, 21, 5, 8, 21, 6, 8, 21, 7, 8, 21};
        george.setAvailability(georgeAvailability);

        assertEquals(8, george.getAvailability()[1]);

    }

    @Test
    public void testShiftConstructor() {
        int[] shiftHours = {1, 8, 21};
        Shift temp = new Shift("chicken", shiftHours);

        Assert.assertArrayEquals(shiftHours, temp.getShift());
        assertEquals("chicken", temp.getJobrole());

    }

    @Test
    public void testShiftIsCovered() {
        int[] shiftHours = {1, 8, 21};
        Shift temp = new Shift("chicken", shiftHours);

        Employee george = new Employee("george");

        assertEquals(false, temp.getIsCovered());

        temp.setCoveredBy(george);

        assertEquals(true, temp.getIsCovered());

    }

    @Test
    public void testEmployeeCanWork() {

        int[] shiftHours = {1, 8, 21};
        Shift temp = new Shift("chicken", shiftHours);

        Employee george = new Employee("george");
        ArrayList<String> georgeRoles = new ArrayList();
        georgeRoles.add("chicken");
        george.setJobroles(georgeRoles);
        int[] georgeAvailability = {1, 8, 21, 2, 0, 0, 3, 0, 0, 4, 0, 0, 5, 0, 0, 6, 0, 0, 7, 0, 0};
        george.setAvailability(georgeAvailability);
        george.setMaxHours(40);

        assertEquals(true, george.canWork(temp));

    }

    @Test
    public void testEmployeeCanWorkFalse() {

        int[] shiftHours = {1, 7, 21};
        Shift temp = new Shift("chicken", shiftHours);

        Employee george = new Employee("george");
        ArrayList<String> georgeRoles = new ArrayList();
        georgeRoles.add("chicken");
        george.setJobroles(georgeRoles);
        int[] georgeAvailability = {1, 8, 21, 2, 0, 0, 3, 0, 0, 4, 0, 0, 5, 0, 0, 6, 0, 0, 7, 0, 0};
        george.setAvailability(georgeAvailability);
        george.setMaxHours(40);

        assertEquals(false, george.canWork(temp));

    }

    @Test
    public void testEmployeeCanWorkDoesntHaveJobRoleFalse() {

        int[] shiftHours = {1, 7, 21};
        Shift temp = new Shift("chicken", shiftHours);

        Employee george = new Employee("george");
        ArrayList<String> georgeRoles = new ArrayList();
        georgeRoles.add("sausage");
        george.setJobroles(georgeRoles);
        int[] georgeAvailability = {1, 8, 21, 2, 0, 0, 3, 0, 0, 4, 0, 0, 5, 0, 0, 6, 0, 0, 7, 0, 0};
        george.setAvailability(georgeAvailability);
        george.setMaxHours(40);

        assertEquals(false, george.canWork(temp));

    }

    @Test
    public void testEmployeeWillPutIntoOvertime() {

        int[] shiftHours = {1, 8, 16};
        Shift temp = new Shift("chicken", shiftHours);

        Employee george = new Employee("george");
        ArrayList<String> georgeRoles = new ArrayList();
        georgeRoles.add("chicken");
        george.setJobroles(georgeRoles);
        int[] georgeAvailability = {1, 8, 21, 2, 0, 0, 3, 0, 0, 4, 0, 0, 5, 0, 0, 6, 0, 0, 7, 0, 0};
        george.setAvailability(georgeAvailability);
        george.setMaxHours(5);

        assertEquals(false, george.canWork(temp));

    }

    @Test
    public void testEmployeeAlreadyScheduledOn() {

        Employee george = new Employee("george");
        ArrayList<String> georgeRoles = new ArrayList();
        georgeRoles.add("chicken");
        george.setJobroles(georgeRoles);
        int[] georgeAvailability = {1, 8, 21, 2, 0, 0, 3, 0, 0, 4, 0, 0, 5, 0, 0, 6, 0, 0, 7, 0, 0};
        george.setAvailability(georgeAvailability);
        george.setMaxHours(40);

        boolean[] tempB = george.getAlreadyScheduledOn();

        assertEquals(false, tempB[0]);

        tempB[0] = true;
        george.setAlreadyScheduledOn(tempB);

        assertEquals(true, george.getAlreadyScheduledOn()[0]);

    }
    
    @Test
    public void testLoadCanBeCoveredBy(){
        
        Employee george = new Employee("george");
        ArrayList<String> georgeRoles = new ArrayList();
        georgeRoles.add("chicken");
        george.setJobroles(georgeRoles);
        int[] georgeAvailability = {1, 8, 21, 2, 0, 0, 3, 0, 0, 4, 0, 0, 5, 0, 0, 6, 0, 0, 7, 0, 0};
        george.setAvailability(georgeAvailability);
        george.setMaxHours(40);
        
        Employee andrew = new Employee("andrew");
        ArrayList<String> andrewRoles = new ArrayList();
        andrewRoles.add("chicken");
        andrew.setJobroles(andrewRoles);
        int[] andrewAvailability = {1, 8, 21, 2, 0, 0, 3, 0, 0, 4, 0, 0, 5, 0, 0, 6, 0, 0, 7, 0, 0};
        andrew.setAvailability(andrewAvailability);
        andrew.setMaxHours(40);
        
        Employee matt = new Employee("matt");
        ArrayList<String> mattRoles = new ArrayList();
        mattRoles.add("chicken");
        matt.setJobroles(mattRoles);
        int[] mattAvailability = {1, 8, 21, 2, 0, 0, 3, 0, 0, 4, 0, 0, 5, 0, 0, 6, 0, 0, 7, 0, 0};
        matt.setAvailability(mattAvailability);
        matt.setMaxHours(40);
        
        EmployeeRoster roster = new EmployeeRoster();
        roster.addEmployee(george);
        roster.addEmployee(andrew);
        roster.addEmployee(matt);
        
        int[] shiftHours = {1, 8, 16};
        Shift temp = new Shift("chicken", shiftHours);
        
        temp.loadCanBeCoveredBy(roster);
        
        assertEquals(roster.getMyEmps(), temp.getCanBeCoveredBy());
    }
    
    @Test
    public void testLoadCanBeCoveredBy2(){
        
        Employee george = new Employee("george");
        ArrayList<String> georgeRoles = new ArrayList();
        georgeRoles.add("chicken");
        george.setJobroles(georgeRoles);
        int[] georgeAvailability = {1, 8, 21, 2, 0, 0, 3, 0, 0, 4, 0, 0, 5, 0, 0, 6, 0, 0, 7, 0, 0};
        george.setAvailability(georgeAvailability);
        george.setMaxHours(40);
        
        Employee andrew = new Employee("andrew");
        ArrayList<String> andrewRoles = new ArrayList();
        andrewRoles.add("chicken");
        andrew.setJobroles(andrewRoles);
        int[] andrewAvailability = {1, 8, 21, 2, 0, 0, 3, 0, 0, 4, 0, 0, 5, 0, 0, 6, 0, 0, 7, 0, 0};
        andrew.setAvailability(andrewAvailability);
        andrew.setMaxHours(40);
        
        Employee matt = new Employee("matt");
        ArrayList<String> mattRoles = new ArrayList();
        mattRoles.add("chicken");
        matt.setJobroles(mattRoles);
        int[] mattAvailability = {1, 0, 0, 2, 0, 0, 3, 0, 0, 4, 0, 0, 5, 0, 0, 6, 0, 0, 7, 0, 0};
        matt.setAvailability(mattAvailability);
        matt.setMaxHours(40);
        
        EmployeeRoster roster = new EmployeeRoster();
        roster.addEmployee(george);
        roster.addEmployee(andrew);
        roster.addEmployee(matt);
        
        int[] shiftHours = {1, 8, 16};
        Shift temp = new Shift("chicken", shiftHours);
        
        temp.loadCanBeCoveredBy(roster);
        
        ArrayList<Employee> withoutMatt = new ArrayList();
        withoutMatt.add(george);
        withoutMatt.add(andrew);
        
        assertEquals(withoutMatt, temp.getCanBeCoveredBy());
    }

    
        @Test
    public void testEmployeeNumberOfShiftsICanCover(){
        
        Employee george = new Employee("george");
        ArrayList<String> georgeRoles = new ArrayList();
        georgeRoles.add("chicken");
        george.setJobroles(georgeRoles);
        int[] georgeAvailability = {1, 8, 21, 2, 8, 21, 3, 0, 0, 4, 0, 0, 5, 0, 0, 6, 0, 0, 7, 0, 0};
        george.setAvailability(georgeAvailability);
        george.setMaxHours(40);
        
        Employee andrew = new Employee("andrew");
        ArrayList<String> andrewRoles = new ArrayList();
        andrewRoles.add("chicken");
        andrew.setJobroles(andrewRoles);
        int[] andrewAvailability = {1, 8, 21, 2, 0, 0, 3, 0, 0, 4, 0, 0, 5, 0, 0, 6, 0, 0, 7, 0, 0};
        andrew.setAvailability(andrewAvailability);
        andrew.setMaxHours(40);
        
        Employee matt = new Employee("matt");
        ArrayList<String> mattRoles = new ArrayList();
        mattRoles.add("chicken");
        matt.setJobroles(mattRoles);
        int[] mattAvailability = {1, 8, 21, 2, 0, 0, 3, 0, 0, 4, 0, 0, 5, 0, 0, 6, 0, 0, 7, 0, 0};
        matt.setAvailability(mattAvailability);
        matt.setMaxHours(40);
        
        EmployeeRoster roster = new EmployeeRoster();
        roster.addEmployee(george);
        roster.addEmployee(andrew);
        roster.addEmployee(matt);
        
        int[] shiftHours = {1, 8, 16};
        Shift temp = new Shift("chicken", shiftHours);
        
        temp.loadCanBeCoveredBy(roster);
        
        assertEquals(roster.getMyEmps(), temp.getCanBeCoveredBy());
        assertEquals(1, roster.getMyEmps().get(0).getNumberOfShiftsICanCover());
        
        int[] shiftHours2 = {2, 8, 16};
        Shift temp2 = new Shift("chicken", shiftHours2);
        
        temp2.loadCanBeCoveredBy(roster);
        assertEquals(2, roster.getMyEmps().get(0).getNumberOfShiftsICanCover());
        
    }
    
    @Test
    public void testWeeklyScheduleReaderWriter() throws IOException, FileNotFoundException, ClassNotFoundException{
        
        int[] shiftHours = {1, 8, 16};
        Shift temp = new Shift("chicken", shiftHours);
        
        int[] shiftHours2 = {2, 8, 16};
        Shift temp2 = new Shift("sausage", shiftHours2);
        
        WeeklySchedule tester = new WeeklySchedule();
        tester.addShiftToWeek(temp);
        tester.addShiftToWeek(temp2);
        
        WeeklyScheduleReaderWriter testerReaderWriter = new WeeklyScheduleReaderWriter();
        
        testerReaderWriter.writeToFile(tester, "testfilename.ser");
        
        WeeklySchedule didItWork = new WeeklySchedule();
        didItWork = testerReaderWriter.readFromFile("testfilename.ser");
        
        System.out.println( tester.getShiftsForWeek().get(0).getShift()[0]  );
        
        assertEquals(didItWork.shiftsForWeek.get(0).getJobrole(), tester.shiftsForWeek.get(0).getJobrole());
        assertEquals(didItWork.shiftsForWeek.get(1).getJobrole(), tester.shiftsForWeek.get(1).getJobrole());
        
        assertEquals(didItWork.getShiftsForWeek().get(0).getShift()[0], tester.getShiftsForWeek().get(0).getShift()[0]);
        assertEquals(didItWork.getShiftsForWeek().get(0).getShift()[1], tester.getShiftsForWeek().get(0).getShift()[1]);
    }
    
    
    
    
}
