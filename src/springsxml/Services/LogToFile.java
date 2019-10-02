package springsxml.Services;
import java.util.logging.*;
import java.io.*;
public class LogToFile implements LogService{
    @Override
    public void log(String item) {
        System.out.println("Writing log to file");
        try{
            FileWriter fw=new FileWriter("loggingFile", true);
            fw.write("Successfully updated: " + item);
            fw.close();
        }catch(Exception e){
            error("Error updating: " + item + "Error message:"+ e);}
    }

    @Override
    public void error(String item) {
        System.out.println(item);
    }
}
