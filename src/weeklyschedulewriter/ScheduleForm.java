package weeklyschedulewriter;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.BLACK;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import static java.awt.GridBagConstraints.LINE_END;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.Border;

/*
 * @author george
 */
public class ScheduleForm {

    boolean alreadyScheduledOn[] = {false, false, false, false, false, false, false};
    WeeklySchedule toWrite;
    EmployeeRoster employees;
    JobRoles roles;
    String[] hours = {"", "12 am", "1 am", "2 am", "3 am", "4 am", "5 am", "6 am", "7 am", "8 am", "9 am", "10 am", "11 am", "12 pm", "1 pm", "2 pm", "3 pm", "4 pm", "5 pm", "6 pm", "7 pm", "8 pm", "9 pm", "10 pm", "11pm"};
    JComboBox[] from;
    JComboBox[] to;
    JLabel[] start;
    JLabel[] end;

    public ScheduleForm() throws IOException, FileNotFoundException, ClassNotFoundException {

        employees = new EmployeeRoster();
        File f = new File("employees.ser");
        if (f.exists()) {
            employees = employees.readFromFile("employees.ser");
        }

        roles = new JobRoles();
        File r = new File("roles.ser");
        if (r.exists()) {
            roles = roles.readFromFile("roles.ser");
        }

        from = new JComboBox[7 * roles.getRoles().size()];
        System.out.println("roles.getRoles().size() is: " + roles.getRoles().size());
        to = new JComboBox[7 * roles.getRoles().size()];
        start = new JLabel[7 * roles.getRoles().size()];
        end = new JLabel[7 * roles.getRoles().size()];

        String[] days = {"", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String[] jobRoles = roles.getRoles().toArray(new String[roles.getRoles().size()]);

        JFrame frame = new JFrame();

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        JScrollPane scrollPane = new JScrollPane(panel);

        frame.add(scrollPane);

        GridBagConstraints c = new GridBagConstraints();

        Border border = BorderFactory.createLineBorder(BLACK);

        int i;
        for (i = 0; i < days.length; i++) {

            JLabel daytemp = new JLabel(days[i]);
            Font font = new Font(daytemp.getFont().toString(), Font.BOLD, daytemp.getFont().getSize() + 3);
            daytemp.setFont(font);

            c.gridx = i;
            c.gridy = 0;

            panel.add(daytemp, c);

        }

        int j;
        for (j = 0; j < 7 * roles.getRoles().size(); j++) {
            from[j] = new JComboBox(hours);
            to[j] = new JComboBox(hours);
            start[j] = new JLabel(" Start");
            end[j] = new JLabel(" End  ");
        }

        int k;
        int l;
        int m = 0;
        for (k = 0; k < roles.getRoles().size(); k++) {

            JPanel tempPanel = new JPanel();

            JLabel jobroletemp = new JLabel(roles.getRoles().get(k));
            jobroletemp.setHorizontalAlignment(CENTER);

            tempPanel.add(jobroletemp, BorderLayout.CENTER);

            c.gridx = 0;
            c.gridy = k + 1;
            c.anchor = LINE_END;

            panel.add(tempPanel, c);

            for (l = 0; l < 7; l++) {
                JPanel temp = new JPanel();
                temp.setLayout(new GridBagLayout());

                from[m].setRenderer(new DefaultListCellRenderer() {
                    @Override
                    public void paint(Graphics g) {
                        setBackground(Color.LIGHT_GRAY);
                        setForeground(Color.BLACK);
                        super.paint(g);
                    }
                });

                to[m].setRenderer(new DefaultListCellRenderer() {
                    @Override
                    public void paint(Graphics g) {
                        setBackground(Color.LIGHT_GRAY);
                        setForeground(Color.BLACK);
                        super.paint(g);
                    }
                });

                c.gridx = 0;
                c.gridy = 0;
                temp.add(start[m], c);

                c.gridx = 1;
                c.gridy = 0;
                temp.add(from[m], c);

                c.gridx = 0;
                c.gridy = 1;
                temp.add(end[m], c);

                c.gridx = 1;
                c.gridy = 1;
                temp.add(to[m], c);

                m++;

                c.gridx = l + 1;
                c.gridy = k + 1;
                temp.setBorder(border);
                panel.add(temp, c);
            }
        }

        int n;
        for (n = 0; n < 6; n++) {
            JLabel temp = new JLabel("");
            frame.add(temp);
        }

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton createScheduleButton = new JButton("Create");

        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                toWrite = new WeeklySchedule();
                Shift[] tempShifts = new Shift[roles.getRoles().size() * 7];

                int tempShiftsIndex = 0;
                int jobRoleIndex;
                int weekDayIndex;
                int fromToIndex = 0;

                for (jobRoleIndex = 0; jobRoleIndex < roles.getRoles().size(); jobRoleIndex++) {

                    for (weekDayIndex = 0; weekDayIndex < 7; weekDayIndex++) {

                        if (from[fromToIndex].getSelectedIndex() != 0 && to[fromToIndex].getSelectedIndex() != 0) {//if the user didn't assign anything, then don't create a schedule for that slot

                            tempShifts[tempShiftsIndex] = new Shift();

                            tempShifts[tempShiftsIndex].setJobrole(roles.getRoles().get(jobRoleIndex));

                            tempShifts[tempShiftsIndex].getShift()[0] = weekDayIndex + 1;
                            tempShifts[tempShiftsIndex].getShift()[1] = (from[fromToIndex].getSelectedIndex() - 1) ;
                            tempShifts[tempShiftsIndex].getShift()[2] = (to[fromToIndex].getSelectedIndex() - 1) ;

                            toWrite.addShiftToWeek(tempShifts[tempShiftsIndex]);
                            tempShiftsIndex++;

                        }
                        fromToIndex++;
                    }//end fromToIndex loop
                }//end jobRoleIndex loop
// AT THIS POINT THE SCHEDULE HAS BEEN SUCCESSFULLY CREATED, BUT NOT ACTUALLY WRITTEN.
                writeSchedule();
            }
        };

        createScheduleButton.addActionListener(action);

        buttonPanel.add(createScheduleButton);

        c.gridx = 7;
        c.gridy = roles.getRoles().size() + 1;

        panel.add(buttonPanel, c);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void writeSchedule() {

        for (int shiftIndex = 0; shiftIndex < toWrite.getShiftsForWeek().size(); shiftIndex++) {

            for (int i = shiftIndex; i < toWrite.getShiftsForWeek().size(); i++) {//loads shift.canBeCoveredBy and employee.numberOfShiftsICanCover
                toWrite.getShiftsForWeek().get(i).loadCanBeCoveredBy(employees);
            }

            Collections.sort(toWrite.getShiftsForWeek(), new ShiftComparator());
            Collections.sort(employees.getMyEmps(), new EmployeeComparator());

            for (int employeeIndex = 0; employeeIndex < employees.getMyEmps().size(); employeeIndex++) {
                if (employees.getMyEmps().get(employeeIndex).canWork(toWrite.getShiftsForWeek().get(shiftIndex))) {

                    toWrite.getShiftsForWeek().get(shiftIndex).setCoveredBy(employees.getMyEmps().get(employeeIndex));
                    toWrite.getShiftsForWeek().get(shiftIndex).setIsCovered(true);

                    employees.getMyEmps().get(employeeIndex).setSpecificAlreadyScheduledOn(toWrite.getShiftsForWeek().get(shiftIndex).getShift()[0] - 1, true);
                    employees.getMyEmps().get(employeeIndex).setCurrentlyScheduledHours( employees.getMyEmps().get(employeeIndex).getCurrentlyScheduledHours() + (toWrite.getShiftsForWeek().get(shiftIndex).getShift()[2] - toWrite.getShiftsForWeek().get(shiftIndex).getShift()[1])   );
                    employees.getMyEmps().get(employeeIndex).addShiftsThisWeek(toWrite.getShiftsForWeek().get(shiftIndex));
                    
                    break;
                }
                if ( (employeeIndex == employees.getMyEmps().size()-1)   &&  (toWrite.getShiftsForWeek().get(shiftIndex).getIsCovered() == false )       ){
                    System.out.println("Housten, we have a serious problem.");//for testing purposes. if we see this on the console, the schedule was not able to be written
                }

            }//end employeeIndex loop
        }//end shiftIndex loop
        printSchedule();//for testing, to see the schedule that was written
    }//end method

    public void printSchedule(){//for testing. remove later
        
        String[] days = {"monday", "tuesday","wednesday","thursday","friday","saturday","sunday"};
        
        int i;
        for (i=0; i < toWrite.shiftsForWeek.size(); i++){
            System.out.println( 
                    days[ toWrite.shiftsForWeek.get(i).getShift()[0]-1 ] + " " 
                    + toWrite.shiftsForWeek.get(i).getJobrole() + 
                    " from " + toWrite.shiftsForWeek.get(i).getShift()[1] +
                    " to " + toWrite.shiftsForWeek.get(i).getShift()[2] +
                    " covered by "  + toWrite.shiftsForWeek.get(i).getCoveredBy().getName() 
                    ) ;
                                
        }
       printByEmployee(); 
    }
    
    
    public void printByEmployee(){//for testing. remove later
        String[] days = {"monday", "tuesday","wednesday","thursday","friday","saturday","sunday"};
        int i;
        for (i=0; i < employees.getMyEmps().size(); i++){
            
            for (int j=0; j < employees.getMyEmps().get(i).shiftsThisWeek.size(); j++){
                
                System.out.println(
                        employees.getMyEmps().get(i).getName() + " " +
                        employees.getMyEmps().get(i).shiftsThisWeek.get(j).getJobrole() + " " +
                        days[ employees.getMyEmps().get(i).shiftsThisWeek.get(j).getShift()[0]-1 ] + 
                        " from " + employees.getMyEmps().get(i).shiftsThisWeek.get(j).getShift()[1] +
                        " to " + employees.getMyEmps().get(i).shiftsThisWeek.get(j).getShift()[2]
                        
                );
                
            }
            
        }
        
        
        
    }
    

    
}
