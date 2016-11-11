package weeklyschedulewriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author george
 */
public class Schedule {

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        MainFrame mainWindow = new MainFrame();
         /*
        DAYCODES:
        1=mon;
        2=tues;
        3=wednes
        4=thurs
        5=fri
        6=sat
        7=sun
         */
        /* 
        Employee andrew = new Employee("andrew");//andrew over his minHours
        andrew.setMinHours(5);
        andrew.setCurrentlyScheduledHours(6);
        andrew.setNumberOfShiftsICanCover(2);
        //andrew.whoAmI();
         
        Employee george = new Employee("george");//george under his minHours
        george.setMinHours(5);
        george.setCurrentlyScheduledHours(4);
        george.setNumberOfShiftsICanCover(3);
       // george.whoAmI();
       
        Employee matt = new Employee("matt"); // matt under his minHours, has higher numShiftsCanCover than george
        matt.setMinHours(5);
        matt.setCurrentlyScheduledHours(2);
        matt.setNumberOfShiftsICanCover(4);
        
        Employee alexis = new Employee("alexis"); // alexis is over her minHours, has higher numShiftsCanCover than andrew
        alexis.setMinHours(5);
        alexis.setCurrentlyScheduledHours(8);
        alexis.setNumberOfShiftsICanCover(3);
        
        Employee tom = new Employee("tom");//tom is under his minHours, can cover less shifts than george or matt
        tom.setMinHours(5);
        tom.setCurrentlyScheduledHours(3);
        tom.setNumberOfShiftsICanCover(2);
        
         
        EmployeeRoster derp = new EmployeeRoster();
        derp.addEmployee(andrew);
        derp.addEmployee(george);
        derp.addEmployee(matt);
        derp.addEmployee(alexis);
        derp.addEmployee(tom);
        
        Collections.sort(derp.getMyEmps(), new EmployeeComparator());
        
        System.out.println("order is:");
        for (int i=0; i < derp.getMyEmps().size(); i++){
            System.out.println(derp.getMyEmps().get(i).getName() + " can cover " + derp.getMyEmps().get(i).getNumberOfShiftsICanCover() + " shifts");
        }
        
        
        Shift shift1 = new Shift();
        shift1.setJobrole("shift1");
        shift1.addCanBeCoveredBy(george);
        shift1.addCanBeCoveredBy(matt);
        
        Shift shift2 = new Shift();
        shift2.setJobrole("shift2");
        shift2.addCanBeCoveredBy(george);
        shift2.addCanBeCoveredBy(matt);
        shift2.addCanBeCoveredBy(alexis);
        
        Shift shift3 = new Shift();
        shift3.setJobrole("shift3");
        shift3.addCanBeCoveredBy(george);
        shift3.addCanBeCoveredBy(matt);
        shift3.addCanBeCoveredBy(alexis);
        shift3.addCanBeCoveredBy(andrew);
        
        WeeklySchedule blerg = new WeeklySchedule();
        blerg.addShiftToWeek(shift3);
        blerg.addShiftToWeek(shift1);
        blerg.addShiftToWeek(shift2);
        
        
        Collections.sort(blerg.getShiftsForWeek(), new ShiftComparator());
        
        System.out.println("shift order is: ");
        for (int j=0; j < blerg.getShiftsForWeek().size(); j++){
            System.out.println(blerg.getShiftsForWeek().get(j).getJobrole() + " can be covered by: " + blerg.getShiftsForWeek().get(j).getCanBeCoveredBy().size() + " people");
        }
        
        
        
        Employee luke = new Employee("luke");
        int[] lukeAvailability = {1, 5, 17, 2, 0, 24, 3, 0, 24, 4, 0, 24, 5, 0, 24, 6, 0, 24, 7, 0, 24};
        luke.setAvailability(lukeAvailability);
        ArrayList <String> lukeRoles = new ArrayList();
        lukeRoles.add("ovenready");
        lukeRoles.add("chicken");
        lukeRoles.add("counter");
        luke.setJobroles(lukeRoles);
        luke.setMaxHours(17);

        int[] shiftInt = {1, 6, 12};
        Shift shiftOne = new Shift("chicken", shiftInt);
        
        if (luke.canWork(shiftOne)){
            System.out.println("luke can totally work that shift");
        }
        
        EmployeeRoster lukeRoster = new EmployeeRoster();
        lukeRoster.addEmployee(luke);
        
        System.out.println("luke.s currently scheduled hours is: " + lukeRoster.getMyEmps().get(0).getCurrentlyScheduledHours());
        System.out.println("luke.s numberOfShiftsICanCover is: " + lukeRoster.getMyEmps().get(0).getNumberOfShiftsICanCover()  );
        
        System.out.println("shiftOne.s number of people who can cover it is: "  + shiftOne.getCanBeCoveredBy().size()   );
        
        System.out.println("so now let.s load it and see if that changes.");
        
        shiftOne.loadCanBeCoveredBy(lukeRoster);
        
        System.out.println("loaded. so now its: \n");
        
         System.out.println("luke.s currently scheduled hours is: " + lukeRoster.getMyEmps().get(0).getCurrentlyScheduledHours());
        System.out.println("luke.s numberOfShiftsICanCover is: " + lukeRoster.getMyEmps().get(0).getNumberOfShiftsICanCover()  );
        
        System.out.println("shiftOne.s number of people who can cover it is: "  + shiftOne.getCanBeCoveredBy().size()   );
        
        
        */
        
        
        
        
        
        
        
        //Employee george = new Employee("george");
        //EmployeeViewForm bla = new EmployeeViewForm(george);
        
        
      
        /*
        EmployeeRoster testRoster = new EmployeeRoster();
        testRoster = testRoster.readFromFile("employees.ser");
        testRoster.toString();
        
        for (int i=0; i < testRoster.getMyEmps().size(); i++){
            
        testRoster.getMyEmps().get(i).whoAmI();
                }
        
        WeeklySchedule schedule = new WeeklySchedule();
        int[] blerg = {6,9,5};
        int[] fuply = {6,9,5};
        Shift satCounter = new Shift("counter", blerg);
        Shift sunCounter = new Shift("closer", fuply);
        schedule.addShiftToWeek(satCounter);
        schedule.addShiftToWeek(sunCounter);
        
        for (int i=0; i < schedule.getShiftsForWeek().size(); i++){
            for (int j=0; j < testRoster.getMyEmps().size(); j++){
                if (testRoster.getMyEmps().get(j).canWork(schedule.shiftsForWeek.get(i))){
                    System.out.println("FUCKING SUCCESS BRAH!\n");
                    schedule.shiftsForWeek.get(i).setCoveredBy(testRoster.getMyEmps().get(j)); 
                    
                   // System.out.println("schedule.shiftsForWeek.get(i).shift[0] is " + schedule.shiftsForWeek.get(i).shift[0]);
                    
                    testRoster.getMyEmps().get(j).alreadyScheduledOn[ schedule.shiftsForWeek.get(i).shift[0]-1   ] = true;
                }
            }
        }
        if (testRoster.getMyEmps().get(0).alreadyScheduledOn[0]){
        System.out.println("if this prints, then setting alreadyScheduledOn worked.");
        }
        */
        
        
        
        
        /*
        DAYCODES:
        1=mon;
        2=tues;
        3=wednes
        4=thurs
        5=fri
        6=sat
        7=sun
         */
       /* 
        Employee andrew = new Employee("andrew");
        int[] andrewAvailability = {1, 5, 17, 2, 0, 24, 3, 0, 24, 4, 0, 24, 5, 0, 24, 6, 0, 24, 7, 0, 24};
        andrew.setAvailability(andrewAvailability);
        String[] andrewRoles = {"ovenready", "chicken", "counter"};
        andrew.setJobroles(andrewRoles);
        andrew.setMaxHours(7);

        int[] shiftInt = {3, 6, 12};
        Shift shiftOne = new Shift("chicken", shiftInt);

        if (andrew.canWork(shiftOne)) {
            System.out.println("andrew can work that shift!!!!");
            andrew.setCurrentlyScheduledHours(andrew.getCurrentlyScheduledHours() + (shiftOne.shift[2] - shiftOne.shift[1]));
            System.out.println("andrew is currently scheduled for " + andrew.getCurrentlyScheduledHours() + " hours\n\n");
        }

        int[] shiftInt2 = {3, 6, 12};
        Shift shiftTwo = new Shift("chicken", shiftInt2);

        if (andrew.canWork(shiftOne)) {
            System.out.println("andrew can work that shift!!!!");
            andrew.setCurrentlyScheduledHours(andrew.getCurrentlyScheduledHours() + (shiftOne.shift[2] - shiftOne.shift[1]));
            System.out.println("andrew is currently scheduled for " + andrew.getCurrentlyScheduledHours() + " hours");
        }

        Employee alexis = new Employee("alexis");
        Employee george = new Employee("george");

        EmployeeRoster derp = new EmployeeRoster();
        derp.addEmployee(andrew);
        derp.addEmployee(alexis);
        derp.addEmployee(george);
        System.out.println(derp.toString());

        derp.writeToFile(derp, "wholeFoodsMeat");

        EmployeeRoster newDerp = new EmployeeRoster();
        newDerp = derp.readFromFile("wholeFoodsMeat.ser");

        System.out.println("if all went according to plan, we are about to see the same employees");
        System.out.println(newDerp.toString());
/*
        JobRoles burg = new JobRoles();
        burg.addJobRole("chicken");
        burg.addJobRole("sausage");
        burg.writeToFile(burg, "testingroles");
       
       
        JobRoles readTest = new JobRoles();
        readTest = readTest.readFromFile("roles.ser");
        readTest.whoAmI();
       
        */
        
   
    }
}
