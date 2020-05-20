package india;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		//print Reg values
		String Firstname = request.getParameter("Firstname");
		String Lastname= request.getParameter("Lastname");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password= request.getParameter("password");
		response.setContentType("text/html");
		out.println("<div>");
		out.println("<p>Firstname : " + Firstname + "</p>");
		out.println("<p>Lastname : " + Lastname + "</p>");
		out.println("<p>gender : " + gender + "</p>");
		out.println("<p>email : "+ email +"</p>" );
		out.println("<p>phone : "  + phone + "</p>");
		out.println("<p>password : "+ password +"</p>");
		

		Connection conn = DBUtil.getConnection();
		Statement stmt = null;
		String sql = "INSERT INTO SIGNUP VALUES ('"+Firstname+"','"+ Lastname +"','"+ gender +"','"+email+"','"+ phone +"', '"+password+"')";
		try {
			stmt = conn.createStatement();
			int i = stmt.executeUpdate(sql);
			System.out.println("User created sucessfuly" +i);
			response.sendRedirect("logout.html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
