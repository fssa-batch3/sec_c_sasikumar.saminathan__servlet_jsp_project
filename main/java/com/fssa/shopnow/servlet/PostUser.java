package com.fssa.shopnow.servlet;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fssa.shopnow.service.UserService;
import com.fssa.shopnow.dao.DAOException;
import com.fssa.shopnow.exception.InvalidUserException;
import com.fssa.shopnow.model.*;

/**
 * Servlet implementation class PostUser
 */
@WebServlet("/PostUser")
public class PostUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String password = request.getParameter("password");
		
		UserService service = new UserService();
		
		User user = new User(name,email,phoneNumber);
		user.setPassword(password);
		
		PrintWriter out = response.getWriter();
		try {
		
			service.addUser(user);
			out.print(false);
		} catch (InvalidUserException | SQLException | DAOException e) {
			// TODO Auto-generated catch block
			out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
