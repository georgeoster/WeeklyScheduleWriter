package weeklyschedulewriter;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.X_AXIS;
import static javax.swing.BoxLayout.Y_AXIS;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*
 * @author george
 */
public class EmployeeAddForm {
    
    EmployeeRoster employees;
    JobRoles roles;
    String[] hours = { "" ,"12 am","1 am","2 am","3 am","4 am","5 am","6 am","7 am", "8 am","9 am","10 am","11 am","12 pm","1 pm","2 pm","3 pm","4 pm","5 pm","6 pm","7 pm","8 pm","9 pm","10 pm","11pm"};
    
    
    public EmployeeAddForm() throws IOException, FileNotFoundException, ClassNotFoundException{
        employees = new EmployeeRoster();
        File f = new File("employees.ser");
        if ( f.exists()  ){
            employees = employees.readFromFile("employees.ser");
        }
        
        roles = new JobRoles();
        File r = new File("roles.ser");
        if ( r.exists()  ){
            roles = roles.readFromFile("roles.ser");
        }
        
        JFrame frame = new JFrame();
        frame.setLocation(100, 100);
        frame.setSize(500, 500);
        
        BoxLayout box = new BoxLayout(frame.getContentPane(), Y_AXIS);
        frame.setLayout(box);
        
        
        
//******************************** START NAME PANEL *******************************        
        JPanel namePanel = new JPanel();  
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
        
        JLabel nameLabel = new JLabel("Name");
        JTextField nameTextField = new JTextField("** ** ** ** **  **");
        nameTextField.setMaximumSize(nameTextField.getPreferredSize());
        nameTextField.setText("");
        
        namePanel.add(nameLabel);
        namePanel.add(nameTextField);
        frame.add(namePanel);
//******************************** END NAME PANEL *******************************         
        
//******************************** START JOBROLE PANEL *******************************  
        frame.add(new JSeparator(SwingConstants.HORIZONTAL));
        
        JLabel rolesLabel = new JLabel("Job Roles");
        frame.add(rolesLabel);
        
        JPanel rolesPanel = new JPanel();
        rolesPanel.setLayout(new BoxLayout(rolesPanel, BoxLayout.X_AXIS));
        
        ArrayList<JCheckBox> jCheckBoxList = new ArrayList<>();
        
        for (int i=0; i < roles.getRoles().size(); i++){
            JCheckBox checkbox = new JCheckBox(roles.getRoles().get(i));
            
            jCheckBoxList.add(checkbox);
            rolesPanel.add(jCheckBoxList.get(i));
        }
        
        frame.add(rolesPanel);
        
//******************************** END JOBROLE PANEL *******************************         
  
//******************************** START AVAILABILITY PANEL ******************************* 
        frame.add(new JSeparator(SwingConstants.HORIZONTAL));
        JPanel availabilityPanel = new JPanel();
        availabilityPanel.setLayout(new BoxLayout(availabilityPanel, Y_AXIS));

        JLabel availabilityLabel = new JLabel("Availability");
        availabilityPanel.add(availabilityLabel);
        
     
        
        JPanel mondayFromToPanel = new JPanel();
        mondayFromToPanel.setLayout(new BoxLayout(mondayFromToPanel, X_AXIS));
        
        JLabel mondayLabel = new JLabel("Monday");
        JComboBox monFrom = new JComboBox(hours);
        monFrom.setMaximumSize(monFrom.getPreferredSize());
       
        JLabel monToLabel = new JLabel(" to ");
        
        JComboBox monTo = new JComboBox(hours);
        monTo.setMaximumSize(monTo.getPreferredSize());
     
        mondayFromToPanel.add(mondayLabel);
        mondayFromToPanel.add(monFrom);
        mondayFromToPanel.add(monToLabel);
        mondayFromToPanel.add(monTo);

        availabilityPanel.add(mondayFromToPanel);
        
        
        JPanel tuesdayFromToPanel = new JPanel();
        tuesdayFromToPanel.setLayout(new BoxLayout(tuesdayFromToPanel, X_AXIS));
        
        JLabel tuesdayLabel = new JLabel("Tuesday");
        JComboBox tuesFrom = new JComboBox(hours);
        tuesFrom.setMaximumSize(tuesFrom.getPreferredSize());
        
        JLabel tuesToLabel = new JLabel(" to ");
        
        JComboBox tuesTo = new JComboBox(hours);
        tuesTo.setMaximumSize(tuesTo.getPreferredSize());
        
        tuesdayFromToPanel.add(tuesdayLabel);
        tuesdayFromToPanel.add(tuesFrom);
        tuesdayFromToPanel.add(tuesToLabel);
        tuesdayFromToPanel.add(tuesTo);
        
        availabilityPanel.add(tuesdayFromToPanel);
        
        JPanel wednesdayFromToPanel = new JPanel();
        wednesdayFromToPanel.setLayout(new BoxLayout(wednesdayFromToPanel, X_AXIS));
        
        JLabel wednesdayLabel = new JLabel("Wednesday");
        JComboBox wednesFrom = new JComboBox(hours);
        wednesFrom.setMaximumSize(wednesFrom.getPreferredSize());
        
        JLabel wednesToLabel = new JLabel(" to ");
        
        JComboBox wednesTo = new JComboBox(hours);
        wednesTo.setMaximumSize(wednesTo.getPreferredSize());
        
        wednesdayFromToPanel.add(wednesdayLabel);
        wednesdayFromToPanel.add(wednesFrom);
        wednesdayFromToPanel.add(wednesToLabel);
        wednesdayFromToPanel.add(wednesTo);
        
        availabilityPanel.add(wednesdayFromToPanel);
        
        
        JPanel thursdayFromToPanel = new JPanel();
        thursdayFromToPanel.setLayout(new BoxLayout(thursdayFromToPanel, X_AXIS));
        
        JLabel thursdayLabel = new JLabel("Thursday");
        JComboBox thursFrom = new JComboBox(hours);
        thursFrom.setMaximumSize(thursFrom.getPreferredSize());
        
        JLabel thursToLabel = new JLabel(" to ");
        
        JComboBox thursTo = new JComboBox(hours);
        thursTo.setMaximumSize(thursTo.getPreferredSize());
        
        thursdayFromToPanel.add(thursdayLabel);
        thursdayFromToPanel.add(thursFrom);
        thursdayFromToPanel.add(thursToLabel);
        thursdayFromToPanel.add(thursTo);
        
        availabilityPanel.add(thursdayFromToPanel);
        
        
        
        
        
        JPanel fridayFromToPanel = new JPanel();
        fridayFromToPanel.setLayout(new BoxLayout(fridayFromToPanel, X_AXIS));
        
        JLabel fridayLabel = new JLabel("Friday");
        JComboBox friFrom = new JComboBox(hours);
        friFrom.setMaximumSize(friFrom.getPreferredSize());
        
        JLabel friToLabel = new JLabel(" to ");
        
        JComboBox friTo = new JComboBox(hours);
        friTo.setMaximumSize(friTo.getPreferredSize());
        
        fridayFromToPanel.add(fridayLabel);
        fridayFromToPanel.add(friFrom);
        fridayFromToPanel.add(friToLabel);
        fridayFromToPanel.add(friTo);
        
        availabilityPanel.add(fridayFromToPanel);
        
        
        
        JPanel saturdayFromToPanel = new JPanel();
        saturdayFromToPanel.setLayout(new BoxLayout(saturdayFromToPanel, X_AXIS));
        
        JLabel saturdayLabel = new JLabel("Saturday");
        JComboBox satFrom = new JComboBox(hours);
        satFrom.setMaximumSize(satFrom.getPreferredSize());
        
        JLabel satToLabel = new JLabel(" to ");
        
        JComboBox satTo = new JComboBox(hours);
        satTo.setMaximumSize(satTo.getPreferredSize());
        
        saturdayFromToPanel.add(saturdayLabel);
        saturdayFromToPanel.add(satFrom);
        saturdayFromToPanel.add(satToLabel);
        saturdayFromToPanel.add(satTo);
        
        availabilityPanel.add(saturdayFromToPanel);
        
        JPanel sundayFromToPanel = new JPanel();
        sundayFromToPanel.setLayout(new BoxLayout(sundayFromToPanel, X_AXIS));
        
        JLabel sundayLabel = new JLabel("Sunday");
        JComboBox sunFrom = new JComboBox(hours);
        sunFrom.setMaximumSize(sunFrom.getPreferredSize());
        
        JLabel sunToLabel = new JLabel(" to ");
        
        JComboBox sunTo = new JComboBox(hours);
        sunTo.setMaximumSize(sunTo.getPreferredSize());
        
        sundayFromToPanel.add(sundayLabel);
        sundayFromToPanel.add(sunFrom);
        sundayFromToPanel.add(sunToLabel);
        sundayFromToPanel.add(sunTo);
        
        availabilityPanel.add(sundayFromToPanel);
     
        frame.add(availabilityPanel);
        frame.add(new JSeparator(SwingConstants.HORIZONTAL));
//******************************** END AVAILABILITY PANEL ******************************* 

//******************************** START MAX / MIN PANEL ******************************* 

       
        
       JPanel minPanel = new JPanel();
       minPanel.setLayout(new BoxLayout(minPanel, BoxLayout.X_AXIS));
       JLabel minLabel = new JLabel("Minimum Hours");
       JTextField min = new JTextField("* * *");
       min.setMaximumSize(min.getPreferredSize());
       min.setText("");
       minPanel.add(minLabel);
       minPanel.add(min);
       frame.add(minPanel);
       
       JPanel maxPanel = new JPanel();
       maxPanel.setLayout(new BoxLayout(maxPanel, BoxLayout.X_AXIS));
       JLabel maxLabel = new JLabel("Maximum Hours");
       JTextField max = new JTextField("* * *");
       max.setMaximumSize(max.getPreferredSize());
       max.setText("");
       maxPanel.add(maxLabel);
       maxPanel.add(max);
       frame.add(maxPanel);
       frame.add(new JSeparator(SwingConstants.HORIZONTAL));
//******************************** END MAX / MIN PANEL ******************************* 
    
        JButton addEmployeeButton = new JButton("Add Employee");
        
        
        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee temp = new Employee(nameTextField.getText());
                ArrayList<String> tempRoles = new ArrayList();
              
                for (int i=0; i < jCheckBoxList.size(); i++){
                    if ( jCheckBoxList.get(i).isSelected()  ){
                       // System.out.println("i wonder if this worked: " + jCheckBoxList.get(i).getText() );
                        tempRoles.add(jCheckBoxList.get(i).getText() );
                    }       
                }
                
                temp.setJobroles(tempRoles);
                
                
                
                int tempAvailability[] = { 1, monFrom.getSelectedIndex()-1,    monTo.getSelectedIndex()-1,
                                           2, tuesFrom.getSelectedIndex()-1,   tuesTo.getSelectedIndex()-1,
                                           3, wednesFrom.getSelectedIndex()-1, wednesTo.getSelectedIndex()-1,
                                           4, thursFrom.getSelectedIndex()-1,  thursTo.getSelectedIndex()-1,
                                           5, friFrom.getSelectedIndex()-1,    friTo.getSelectedIndex()-1,
                                           6, satFrom.getSelectedIndex()-1,    satTo.getSelectedIndex()-1,
                                           7, sunFrom.getSelectedIndex()-1,    sunTo.getSelectedIndex()-1
                                         };
                
                temp.setAvailability(tempAvailability);
                
               temp.setMinHours(Integer.parseInt(min.getText()));
               temp.setMaxHours(Integer.parseInt(max.getText()));
                
                employees.addEmployee(temp);
                try {
                    employees.writeToFile(employees, "employees.ser");
                } catch (IOException ex) {
                    Logger.getLogger(EmployeeAddForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                
               JOptionPane.showMessageDialog(frame, "Employee Sucessfully Added");
            }
        };
        
        
        addEmployeeButton.addActionListener(action);
        
        
        
        
        
        
        
        frame.add(addEmployeeButton);



        frame.setVisible(true);
    }
    
}
