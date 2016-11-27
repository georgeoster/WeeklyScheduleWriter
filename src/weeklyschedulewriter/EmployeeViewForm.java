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
public class EmployeeViewForm {
    
    EmployeeRoster employees;
    JobRoles roles;
    String[] hours = {"12 am","1 am","2 am","3 am","4 am","5 am","6 am","7 am", "8 am","9 am","10 am","11 am","12 pm","1 pm","2 pm","3 pm","4 pm","5 pm","6 pm","7 pm","8 pm","9 pm","10 pm","11pm"};
    Employee temp;// 
    int toEdit;
    
    public EmployeeViewForm(Employee toView) throws IOException, FileNotFoundException, ClassNotFoundException{
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
        
        
        for (toEdit=0; toEdit < employees.getMyEmps().size(); toEdit++){
            if (employees.getMyEmps().get(toEdit).getName().equals(toView.getName()) ){
                break;//now employees.getMyEmps().get(toEdit) will be the employee we want to view/edit
            }
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
        nameTextField.setText(employees.getMyEmps().get(toEdit).getName());
        
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
            
            for (int j=0; j < employees.getMyEmps().get(toEdit).getJobroles().size(); j++ ){
                if (roles.getRoles().get(i).equals(employees.getMyEmps().get(toEdit).getJobroles().get(j)))
                    checkbox.setSelected(true);
            }
            
            
            
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
        monFrom.setSelectedIndex(employees.getMyEmps().get(toEdit).getAvailability()[1]);
       
        JLabel monToLabel = new JLabel(" to ");
        
        JComboBox monTo = new JComboBox(hours);
        monTo.setMaximumSize(monTo.getPreferredSize());
        monTo.setSelectedIndex(employees.getMyEmps().get(toEdit).getAvailability()[2]);
     
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
        tuesFrom.setSelectedIndex(employees.getMyEmps().get(toEdit).getAvailability()[4]);
        
        JLabel tuesToLabel = new JLabel(" to ");
        
        JComboBox tuesTo = new JComboBox(hours);
        tuesTo.setMaximumSize(tuesTo.getPreferredSize());
        tuesTo.setSelectedIndex(employees.getMyEmps().get(toEdit).getAvailability()[5]);
        
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
        wednesFrom.setSelectedIndex(employees.getMyEmps().get(toEdit).getAvailability()[7]);
        
        JLabel wednesToLabel = new JLabel(" to ");
        
        JComboBox wednesTo = new JComboBox(hours);
        wednesTo.setMaximumSize(wednesTo.getPreferredSize());
        wednesTo.setSelectedIndex(employees.getMyEmps().get(toEdit).getAvailability()[8]);
        
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
        thursFrom.setSelectedIndex(employees.getMyEmps().get(toEdit).getAvailability()[10]);
        
        JLabel thursToLabel = new JLabel(" to ");
        
        JComboBox thursTo = new JComboBox(hours);
        thursTo.setMaximumSize(thursTo.getPreferredSize());
        thursTo.setSelectedIndex(employees.getMyEmps().get(toEdit).getAvailability()[11]);
        
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
        friFrom.setSelectedIndex(employees.getMyEmps().get(toEdit).getAvailability()[13]);
        
        JLabel friToLabel = new JLabel(" to ");
        
        JComboBox friTo = new JComboBox(hours);
        friTo.setMaximumSize(friTo.getPreferredSize());
        friTo.setSelectedIndex(employees.getMyEmps().get(toEdit).getAvailability()[14]);
        
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
        satFrom.setSelectedIndex(employees.getMyEmps().get(toEdit).getAvailability()[16]);
        
        JLabel satToLabel = new JLabel(" to ");
        
        JComboBox satTo = new JComboBox(hours);
        satTo.setMaximumSize(satTo.getPreferredSize());
        satTo.setSelectedIndex(employees.getMyEmps().get(toEdit).getAvailability()[17]);
        
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
        sunFrom.setSelectedIndex(employees.getMyEmps().get(toEdit).getAvailability()[19]);
        
        JLabel sunToLabel = new JLabel(" to ");
        
        JComboBox sunTo = new JComboBox(hours);
        sunTo.setMaximumSize(sunTo.getPreferredSize());
        sunTo.setSelectedIndex(employees.getMyEmps().get(toEdit).getAvailability()[20]);
        
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
       min.setText( Integer.toString(employees.getMyEmps().get(toEdit).getMinHours()) );
       minPanel.add(minLabel);
       minPanel.add(min);
       frame.add(minPanel);
       
       JPanel maxPanel = new JPanel();
       maxPanel.setLayout(new BoxLayout(maxPanel, BoxLayout.X_AXIS));
       JLabel maxLabel = new JLabel("Maximum Hours");
       JTextField max = new JTextField("* * *");
       max.setMaximumSize(max.getPreferredSize());
       max.setText(Integer.toString(employees.getMyEmps().get(toEdit).getMaxHours()));
       maxPanel.add(maxLabel);
       maxPanel.add(max);
       frame.add(maxPanel);
       frame.add(new JSeparator(SwingConstants.HORIZONTAL));
//******************************** END MAX / MIN PANEL ******************************* 
    
        JButton addEmployeeButton = new JButton("Save Changes");
        
        
        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                employees.deleteEmployee(employees.getMyEmps().get(toEdit));
                
                Employee temp = new Employee(nameTextField.getText());
                ArrayList<String> tempRoles = new ArrayList();
              
                for (int i=0; i < jCheckBoxList.size(); i++){
                    if ( jCheckBoxList.get(i).isSelected()  ){
                        tempRoles.add(jCheckBoxList.get(i).getText() );
                    }       
                }
                
                temp.setJobroles(tempRoles);
                
                
                
                int tempAvailability[] = { 1, monFrom.getSelectedIndex(),    monTo.getSelectedIndex(),
                                           2, tuesFrom.getSelectedIndex(),   tuesTo.getSelectedIndex(),
                                           3, wednesFrom.getSelectedIndex(), wednesTo.getSelectedIndex(),
                                           4, thursFrom.getSelectedIndex(),  thursTo.getSelectedIndex(),
                                           5, friFrom.getSelectedIndex(),    friTo.getSelectedIndex(),
                                           6, satFrom.getSelectedIndex(),    satTo.getSelectedIndex(),
                                           7, sunFrom.getSelectedIndex(),    sunTo.getSelectedIndex()
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
                
               JOptionPane.showMessageDialog(frame, "Employee Sucessfully Changed");
            }
        };
        
        
        addEmployeeButton.addActionListener(action);
      
        frame.add(addEmployeeButton);

        frame.setVisible(true);
    }
    
}
