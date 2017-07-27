

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "F2", urlPatterns = { "/F2" })
public class FeedbackServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Name=request.getParameter("n2");
		String Username=request.getParameter("u2");
		String Password=request.getParameter("p2");
		String Gender=request.getParameter("g2");
		String Language=request.getParameter("l2");
		String City=request.getParameter("c2");
		PrintWriter out=response.getWriter();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","Amit_2197","1234");
			PreparedStatement pst=c.prepareStatement("insert into Table01(Name,Username,Password,Gender,Language,City) values(?,?,?,?,?,?)");
			pst.setString(1,Name);
			pst.setString(2,Username);
			pst.setString(3,Password);
			pst.setString(4,Gender);
			pst.setString(5,Language);
			pst.setString(6,City);
			int i=pst.executeUpdate();
			if(i>0){
				out.print("<html><body bgcolor=#d9dee2 size=16px font=Arial>");
				   out.print("<h1>Succesfully Registered<h1>");
				   out.print("<a href='Logout'> Logout</a>"); 
				   out.print("</html></body>"); 
			}
			c.close();
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
	}

}
