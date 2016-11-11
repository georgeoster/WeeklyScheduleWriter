package weeklyschedulewriter;

import java.awt.event.ActionEvent;
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

/*
 * @author george
 */
public class JobRoleRemoveForm {

    JobRoles roles;

    public JobRoleRemoveForm() throws IOException, FileNotFoundException, ClassNotFoundException {

        roles = new JobRoles();
        File f = new File("roles.ser");
        if (f.exists()) {
            roles = roles.readFromFile("roles.ser");
        }

        JFrame frame = new JFrame();
        frame.setLocation(100, 100);
        frame.setSize(200, 200);

        BoxLayout box = new BoxLayout(frame.getContentPane(), Y_AXIS);
        frame.setLayout(box);

        int i;
        for (i = 0; i < roles.getRoles().size(); i++) {
            JButton button = new JButton("Delete");
            JTextField text = new JTextField(roles.getRoles().get(i));
            text.setMaximumSize(text.getPreferredSize());

            JPanel panel = new JPanel();

            panel.add(button);
            panel.add(text);

            Action action = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    roles.deleteJobRole(text.getText());     //addJobRole(text.getText());
                    try {
                        roles.writeToFile(roles, "roles.ser");
                    } catch (IOException ex) {
                        Logger.getLogger(JobRoleAddForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    text.setText("");
                    frame.dispose();
                    JOptionPane.showMessageDialog(frame, "Job Role Sucessfully Deleted");
                }
            };

            button.addActionListener(action);

            frame.add(panel);
        }
        frame.setVisible(true);

    }

}
