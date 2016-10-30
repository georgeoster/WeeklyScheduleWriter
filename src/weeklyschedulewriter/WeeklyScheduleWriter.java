package weeklyschedulewriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.runner.Result;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

/*
 * @author george
 */

public class WeeklyScheduleWriter {

    public static void main(String[] args) {
        System.out.println("george rules");
        
        try {
            MainFrame frame = new MainFrame();
        } catch (IOException ex) {
            Logger.getLogger(WeeklyScheduleWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WeeklyScheduleWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
     
	
        
        
        
    }
    
}