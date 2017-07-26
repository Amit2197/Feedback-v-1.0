

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Ad", urlPatterns = { "/Ad" })
public class Adminlodin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u=request.getParameter("u3");
		String p=request.getParameter("p3");
		PrintWriter out=response.getWriter();
		HttpSession s=request.getSession();
		s.setAttribute("Username",u);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Amit_2197","1234");
			Statement st=c.createStatement();
			ResultSet rs=st.executeQuery("select USERNAME,PASSWORD from Admin where USERNAME='"+u+"'and PASSWORD='"+p+"'");
			
		if(rs.next())
		{
			response.sendRedirect("AdminShow.jsp");
		}
		else
		{
			out.print("<html><body bgcolor=#d9dee2 size=16px font=Arial>");
	        out.println("<h1>Invalid password</h1>");
	        out.print("<a href='Adminlogin.jsp'>try again</a><br>");
	        out.print("<a href='HomePage.jsp'>Go to Home</a>");
	        out.print("</html></body>");
			
		}
		} catch(Exception e) {System.out.println(e);}

	}

}
