package springsxml.Services;
import java.util.logging.*;
import java.io.*;
public class getSqlLog implements LogService{
    @Override
    public void log(String item) {

        try{
            FileWriter fw=new FileWriter("loggingFile");
            fw.write("Succesfully updated: " + item);
            fw.close();
        }catch(Exception e){
            System.out.println(e);}
    }

    @Override
    public void error(String item) {
        try{
            FileWriter fw=new FileWriter("loggingFile");
            fw.write("Error updating: " + item);
            fw.close();
        }catch(Exception e){
            System.out.println(e);}
    }
}
