package weeklyschedulewriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author george
 */
public class WeeklyScheduleReaderWriter {

    public WeeklyScheduleReaderWriter() {
    }
    
     public void writeToFile(WeeklySchedule toWrite, String filename) throws FileNotFoundException, IOException{
        FileOutputStream outStream = new FileOutputStream(filename);
        ObjectOutputStream ObjOutStream = new ObjectOutputStream(outStream);
        ObjOutStream.writeObject(toWrite);
        ObjOutStream.close();
    }
    
    public WeeklySchedule readFromFile(String filename) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream inStream = new FileInputStream(filename);
        ObjectInputStream ObjInStream = new ObjectInputStream(inStream);
        WeeklySchedule toReturn = (WeeklySchedule) ObjInStream.readObject();
        ObjInStream.close();
        return toReturn;
    }
    
    
    
}
