package weeklyschedulewriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * @author george oster
 */
public class JobRolesReaderWriter {

    public JobRolesReaderWriter() {
    }

    public void writeToFile(JobRoles toWrite, String filename) throws FileNotFoundException, IOException {
        FileOutputStream outStream = new FileOutputStream(filename + ".ser");
        ObjectOutputStream ObjOutStream = new ObjectOutputStream(outStream);
        ObjOutStream.writeObject(toWrite);
        ObjOutStream.close();
    }

    public JobRoles readFromFile(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream inStream = new FileInputStream(filename);
        ObjectInputStream ObjInStream = new ObjectInputStream(inStream);
        JobRoles toReturn = (JobRoles) ObjInStream.readObject();
        ObjInStream.close();
        return toReturn;
    }

}
