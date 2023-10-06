package com.fssa.shopnow.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fssa.shopnow.dao.DAOException;
import com.fssa.shopnow.service.UserService;
import com.fssa.shopnow.util.PasswordTool;

/**
 * Servlet implementation class CheckAccount
 */
@WebServlet("/CheckAccount")
public class CheckAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String hashedPassword = PasswordTool.hashPassword(password);
		
		UserService service = new UserService();
		
		try {
			PrintWriter out = response.getWriter();
			if(service.isAccountExist(email, hashedPassword)) {
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				out.print(true);
			}
			else {
				out.print(false);
			}
		} catch (SQLException | DAOException e) {
			e.printStackTrace();
		}
	}

}
