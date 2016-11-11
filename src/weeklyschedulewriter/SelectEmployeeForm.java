/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weeklyschedulewriter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.Y_AXIS;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author george
 */
public class SelectEmployeeForm {

    EmployeeRoster employees;
    

    public SelectEmployeeForm() throws IOException, FileNotFoundException, ClassNotFoundException {

        employees = new EmployeeRoster();
        File f = new File("employees.ser");
        if (f.exists()) {
            employees = employees.readFromFile("employees.ser");
        }

        JFrame frame = new JFrame();
        frame.setLocation(100, 100);
        frame.setSize(200, 600);

        BoxLayout box = new BoxLayout(frame.getContentPane(), Y_AXIS);
        frame.setLayout(box);

        final JButton[] buttons = new JButton[employees.getMyEmps().size()];
        final ActionListener[] action = new ActionListener[employees.getMyEmps().size()];
        int i;
        for (i = 0; i < employees.getMyEmps().size(); i++) {
            int k = i;
            buttons[i] = new JButton(employees.getMyEmps().get(i).getName());

            action[i] = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        EmployeeViewForm view = new EmployeeViewForm(employees.getMyEmps().get(k));
                    } catch (IOException ex) {
                        Logger.getLogger(SelectEmployeeForm.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(SelectEmployeeForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    frame.dispose();
                }
            };

            buttons[i].addActionListener(action[i]);
            frame.add(buttons[i]);
        }

        frame.setVisible(true);
    }

}
