package test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
@WebServlet(name = "ListServlet", urlPatterns = "/list")
public class Serve extends HttpServlet {

    private final String Driver_Name = "jdbc:derby:";
    private final String DATABASE_PATH = "/WEB-INF/lib/dbDistributedJava";
    private final String USER = "Daniel";
    private final String PW = "000522007";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset= null;
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String path = getServletContext().getRealPath(DATABASE_PATH);
            conn = DriverManager.getConnection(Driver_Name + path, USER, PW);
            stmt = conn.createStatement();
            StringBuilder sql = new StringBuilder();
            sql.append("Select * from Person ");
            sql.append("Order By name");

            rset = stmt.executeQuery(sql.toString());

            StringBuilder html = new StringBuilder("<html><body><ul>");

            while(rset.next()){
                String name = rset.getString("name");
                String SelfieFileName = rset.getString("SelfieFileName");
                String Bio = rset.getString("Bio");

                html.append("<li>").append(name).append("</li>");
                html.append("<li>").append(SelfieFileName).append("</li>");
                html.append("<li>").append(Bio).append("</li>");

            }
            html.append("</ul></body></html>");
            response.getWriter().print(html.toString());

        } catch (ClassNotFoundException | SQLException e){
            response.getWriter().print(e.getMessage());
        } finally{
            if(stmt != null){
                try{
                    stmt.close();
                } catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(rset != null){
                try{
                    rset.close();
                } catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try{
                    conn.close();
                } catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
