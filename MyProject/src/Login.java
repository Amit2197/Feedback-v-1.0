

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "L1", urlPatterns = { "/L1" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u=request.getParameter("u1");
		String p=request.getParameter("p1");
		PrintWriter out=response.getWriter();
		HttpSession s=request.getSession();
		s.setAttribute("Username",u);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Amit_2197","1234");
			Statement st=c.createStatement();
			ResultSet rs=st.executeQuery("select USERNAME,PASSWORD from Table00 where USERNAME='"+u+"'and PASSWORD='"+p+"'");
			
		if(rs.next())
		{
			response.sendRedirect("medium");
		}
		else
		{
			out.print("<html><body bgcolor=#d9dee2 size=16px font=Arial>");
	        out.println("<h1>Invalid password</h1>");
	        out.print("<a href='Student.jsp'>try again</a><br>");
	        out.print("<a href='HomePage.jsp'>Go to Home</a>");
	        out.print("</html></body>");
			
		}
		} catch(Exception e) {System.out.println(e);}

	}

}
