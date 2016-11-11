package weeklyschedulewriter;

import java.io.*;

/**
 * @author george
 */
public class EmployeeRosterReaderWriter {

    public EmployeeRosterReaderWriter() {
    }
    
    public void writeToFile(EmployeeRoster toWrite, String filename) throws FileNotFoundException, IOException{
        FileOutputStream outStream = new FileOutputStream(filename);
        ObjectOutputStream ObjOutStream = new ObjectOutputStream(outStream);
        ObjOutStream.writeObject(toWrite);
        ObjOutStream.close();
    }
    
    public EmployeeRoster readFromFile(String filename) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream inStream = new FileInputStream(filename);
        ObjectInputStream ObjInStream = new ObjectInputStream(inStream);
        EmployeeRoster toReturn = (EmployeeRoster) ObjInStream.readObject();
        ObjInStream.close();
        return toReturn;
    }
            

    
}
