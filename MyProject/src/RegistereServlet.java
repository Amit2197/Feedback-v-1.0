

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "R1", urlPatterns = { "/R1" })
public class RegistereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Name=request.getParameter("n1");
		String Username=request.getParameter("u1");
		String Password=request.getParameter("p1");
		String Gender=request.getParameter("g1");
		String Language=request.getParameter("l1");
		String City=request.getParameter("c1");
		PrintWriter out=response.getWriter();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","Amit_2197","1234");
			PreparedStatement pst=c.prepareStatement("insert into Table00(Name,Username,Password,Gender,Language,City) values(?,?,?,?,?,?)");
			pst.setString(1,Name);
			pst.setString(2,Username);
			pst.setString(3,Password);
			pst.setString(4,Gender);
			pst.setString(5,Language);
			pst.setString(6,City);
			int i=pst.executeUpdate();
			if(i>0){
				out.print("<html><body bgcolor=#d9dee2 size=16px font=Arial>");
				   out.print("<h1>Registration is successful<h1>");
				   out.print("<a href='Student.jsp'> Go to Login</a>"); 
				   out.print("</html></body>"); 
			}
			c.close();
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
	}

}
