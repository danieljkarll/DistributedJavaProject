package test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class Search extends HttpServlet {
    private final String Driver_Name = "jdbc:derby:";
    private final String DATABASE_PATH = "/WEB-INF/lib/dbDistributedJava";
    private final String USER = "Daniel";
    private final String PW = "000522007";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }




        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Connection conn = null;
            PreparedStatement pstmt =null;
            ResultSet rset = null;

            try{
                String searchTerm = request.getParameter("searchTerm");
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                String path = getServletContext().getRealPath(DATABASE_PATH);

                conn = DriverManager.getConnection(Driver_Name +path,USER, PW);

                String sql = "SELECT name FROM Person WHERE name= ?";

                pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, searchTerm);

                rset = pstmt.executeQuery();

                StringBuilder html = new StringBuilder("<html><body>");

                while(rset.next()){
                    int id = rset.getInt(1);
                    html.append("<p>ID:").append(id).append("</p>");
                }
                html.append("</body></html>");

                response.getWriter().print(html.toString());
            }catch(SQLException | ClassNotFoundException e){
                response.getWriter().print(e.getMessage());
            }finally {
                if(pstmt != null){
                    try{
                        pstmt.close();
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
