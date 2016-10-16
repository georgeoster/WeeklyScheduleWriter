package weeklyschedulewriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * @author george oster
 */
public class JobRoles implements Serializable {

    ArrayList<String> roles;

    public JobRoles() {
        roles = new ArrayList();
    }

    public void addJobRole(String role) {
        this.roles.add(role);
    }

    public void deleteJobRole(String role) {
        this.roles.remove(role);
    }

    public ArrayList<String> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }

    public void writeToFile(JobRoles toWrite, String filename) throws IOException {
        JobRolesReaderWriter temp = new JobRolesReaderWriter();
        temp.writeToFile(toWrite, filename);
    }

    public JobRoles readFromFile(String filename) throws IOException, FileNotFoundException, ClassNotFoundException {
        JobRolesReaderWriter temp = new JobRolesReaderWriter();
        return temp.readFromFile(filename);
    }

    public void whoAmI() {

        System.out.println("Roles Are As Follows: ");

        int i;
        for (i = 0; i < roles.size(); i++) {
            System.out.println(roles.get(i));
        }

    }

}
