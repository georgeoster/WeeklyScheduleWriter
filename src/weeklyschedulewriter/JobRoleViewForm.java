package weeklyschedulewriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.Y_AXIS;
import javax.swing.JFrame;
import javax.swing.JTextField;

/*
 * @author george
 */

public class JobRoleViewForm {
   
    JobRoles roles;
    
    public JobRoleViewForm() throws IOException, FileNotFoundException, ClassNotFoundException{
        
        roles = new JobRoles();
        File f = new File("roles.ser");
        if ( f.exists()  ){
            roles = roles.readFromFile("roles.ser");
        }
        
        JFrame frame = new JFrame();
        frame.setLocation(100, 100);
        frame.setSize(200, 600);
        
        
        BoxLayout box = new BoxLayout(frame.getContentPane(), Y_AXIS);
        frame.setLayout(box);
        
        int i;
        for(i=0; i < roles.getRoles().size(); i++){
            JTextField text = new JTextField(roles.getRoles().get(i));
            text.setMaximumSize(text.getPreferredSize());
            frame.add(text);
        }
        frame.setVisible(true);
        
        
        
    }
    
    
}
