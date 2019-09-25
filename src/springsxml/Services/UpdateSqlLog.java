package springsxml.Services;

public class UpdateSqlLog implements LogService{
    @Override
    public void log(String item) {
        System.out.println("Update went through succesfully for: " +item);
    }

    @Override
    public void error(String item) {
        System.out.println("Error updating SQL: " + item);
    }
}
