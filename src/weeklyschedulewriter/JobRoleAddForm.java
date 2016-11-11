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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * @author george
 */
public class JobRoleAddForm {
    JobRoles roles;
    public JobRoleAddForm() throws IOException, FileNotFoundException, ClassNotFoundException {
        
        roles = new JobRoles();
        File f = new File("roles.ser");
        if ( f.exists()  ){
            roles = roles.readFromFile("roles.ser");
        }
        
        JFrame frame = new JFrame();
        frame.setLocation(100, 100);
        frame.setSize(200, 200);

        BoxLayout box = new BoxLayout(frame.getContentPane(), Y_AXIS);
        frame.setLayout(box);

        JLabel instruction = new JLabel("Enter Job Role");
       
        JTextField text = new JTextField("*************************************");
        text.setMaximumSize(text.getPreferredSize());
        text.setText("");
       
        JButton button = new JButton("Add");
        
                
        
        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                roles.addJobRole(text.getText());
                try {
                    roles.writeToFile(roles, "roles.ser");
                } catch (IOException ex) {
                    Logger.getLogger(JobRoleAddForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                text.setText("");
               JOptionPane.showMessageDialog(frame, "Job Role Sucessfully Added");
            }
        };
        
        button.addActionListener(action);
        text.addActionListener(action);
        
        

        frame.add(instruction);
        frame.add(text);
        frame.add(button);

        frame.setVisible(true);

    }

}
