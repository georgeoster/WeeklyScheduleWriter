package weeklyschedulewriter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.input.KeyCode.J;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/*
 * @author george
 */
public class MainFrame {

    EmployeeRoster employees;
    JobRoles roles;

    public MainFrame() throws IOException, FileNotFoundException, ClassNotFoundException {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        JMenuBar menuBar = new JMenuBar();

        JMenu jobRoleMenu = new JMenu("Job Roles");
        JMenu employeeMenu = new JMenu("Employees");
        JMenu scheduleMenu = new JMenu("Schedule");

        menuBar.add(jobRoleMenu);
        menuBar.add(employeeMenu);
        menuBar.add(scheduleMenu);

        JMenuItem addJobRole = new JMenuItem("Add Job Role");
        JMenuItem viewJobRole = new JMenuItem("View Job Roles");
        JMenu deleteJobRole = new JMenu("Delete Job Role");

        jobRoleMenu.add(addJobRole);
        jobRoleMenu.add(viewJobRole);
        jobRoleMenu.add(deleteJobRole);

        addJobRole.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    JobRoleAddForm addJobRole = new JobRoleAddForm();
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        viewJobRole.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {

                    JobRoleViewForm viewJobRole = new JobRoleViewForm();

                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        deleteJobRole.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {

                roles = new JobRoles();
                File f = new File("roles.ser");
                if (f.exists()) {
                    try {
                        roles = roles.readFromFile("roles.ser");
                    } catch (IOException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                ActionListener[] action = new ActionListener[roles.getRoles().size()];
                int i;
                for (i = 0; i < roles.getRoles().size(); i++) {
                    int k = i;
                    JMenuItem temp = new JMenuItem(roles.getRoles().get(i));
                    action[i] = new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            roles.deleteJobRole(roles.getRoles().get(k));
                            try {
                                roles.writeToFile(roles, "roles.ser");
                            } catch (IOException ex) {
                                Logger.getLogger(JobRoleAddForm.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            JOptionPane.showMessageDialog(frame, "Job Role Sucessfully Deleted");

                        }
                    };
                   temp.addActionListener(action[i]);
                    deleteJobRole.add(temp);
                }

            }

            @Override
            public void menuDeselected(MenuEvent e) {
                deleteJobRole.removeAll();
            }

            @Override
            public void menuCanceled(MenuEvent e) {
                deleteJobRole.removeAll();
            }

        });

        JMenuItem addEmployee = new JMenuItem("Add Employee");
        employeeMenu.add(addEmployee);

        addEmployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    EmployeeAddForm addEmployeeForm = new EmployeeAddForm();
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        JMenu viewEmployees = new JMenu("View Employees");

        viewEmployees.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                employees = new EmployeeRoster();
                File f = new File("employees.ser");
                if (f.exists()) {
                    try {
                        employees = employees.readFromFile("employees.ser");
                    } catch (IOException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                ActionListener[] action = new ActionListener[employees.getMyEmps().size()];
                int i;
                for (i = 0; i < employees.getMyEmps().size(); i++) {
                    int k = i;
                    JMenuItem temp = new JMenuItem(employees.getMyEmps().get(i).getName());

                    action[i] = new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            try {
                                EmployeeViewForm view = new EmployeeViewForm(employees.getMyEmps().get(k));
                            } catch (IOException ex) {
                                Logger.getLogger(SelectEmployeeForm.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(SelectEmployeeForm.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }
                    };

                    temp.addActionListener(action[i]);
                    viewEmployees.add(temp);
                }

            }

            @Override
            public void menuDeselected(MenuEvent e) {
                viewEmployees.removeAll();
            }

            @Override
            public void menuCanceled(MenuEvent e) {
                viewEmployees.removeAll();
            }

        });

        employeeMenu.add(viewEmployees);

        JMenuItem writeSchedule = new JMenuItem("Write Schedule");
        writeSchedule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ScheduleForm schedule = new ScheduleForm();
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        );

        scheduleMenu.add(writeSchedule);

        frame.setJMenuBar(menuBar);
        frame.setVisible(true);

    }

}
