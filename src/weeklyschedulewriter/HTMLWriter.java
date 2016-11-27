package weeklyschedulewriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Collections;

/*
 * @author george
 */
public class HTMLWriter {

    EmployeeRoster employees;
    String[] hours = {"", "12 am", "1 am", "2 am", "3 am", "4 am", "5 am", "6 am", "7 am", "8 am", "9 am", "10 am", "11 am", "12 pm", "1 pm", "2 pm", "3 pm", "4 pm", "5 pm", "6 pm", "7 pm", "8 pm", "9 pm", "10 pm", "11pm"};

    public HTMLWriter() {
    }

    public HTMLWriter(EmployeeRoster employees) {
        this.employees = employees;
    }

    public void createHTMLFile() {
        try {
            
            StringBuilder builder = new StringBuilder();
            
            builder.append("<html><head><title></title></head>");
            builder.append("<body>");
            builder.append("<table border=\"1\" bordercolor=\"#000000\">");
            builder.append(""
                    + "<tr align = \"center\">"
                    + "<td><b></b></td>"
                    + "<td><b>Monday</b></td>"
                    + "<td><b>Tuesday</b></td>"
                    + "<td><b>Wednesday</b></td>"
                    + "<td><b>Thursday</b></td>"
                    + "<td><b>Friday</b></td>"
                    + "<td><b>Saturday</b></td>"
                    + "<td><b>Sunday</b></td>"
                    + "</tr>");

            for (int i = 0; i < employees.getMyEmps().size(); i++) {

                builder.append("<tr>");
                builder.append(""
                        + "<td><b>"
                        + employees.getMyEmps().get(i).getName()
                        + "</b></td>");

                Collections.sort(employees.getMyEmps().get(i).shiftsThisWeek, new HTMLShiftComparator());
                
                int j=0;
                for (int k=1; k < 8;k++){
                    
                    if (j == employees.getMyEmps().get(i).shiftsThisWeek.size()){
                            break;
                        }
                    
                    if (employees.getMyEmps().get(i).shiftsThisWeek.get(j).getShift()[0] == k){
                        
                        builder.append(""
                                    + "<td align = \"center\">"
                                    + employees.getMyEmps().get(i).shiftsThisWeek.get(j).getJobrole()
                                    + "<br>"
                                    + hours[employees.getMyEmps().get(i).shiftsThisWeek.get(j).getShift()[1] + 1]
                                    + " - "
                                    + hours[employees.getMyEmps().get(i).shiftsThisWeek.get(j).getShift()[2] + 1]
                                    + "</td>");
                        j++;
                    } else { builder.append("<td></td>"); }
                    
                }
                
                builder.append("</tr>");
                
            }

            builder.append("</table></body></html>");
            WriteToFile(builder.toString(), "schedule.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void WriteToFile(String fileContent, String fileName) throws IOException {
        String projectPath = System.getProperty("user.dir");
        String tempFile = projectPath + File.separator + fileName;
        File file = new File(tempFile);
        // if file does exists, then delete and create a new file
        if (file.exists()) {
            try {
                File newFileName = new File(projectPath + File.separator + "backup_" + fileName);
                file.renameTo(newFileName);
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //write to file with OutputStreamWriter
        OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
        Writer writer = new OutputStreamWriter(outputStream);
        writer.write(fileContent);
        writer.close();

    }

}
