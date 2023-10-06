package com.fssa.shopnow.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;

import com.fssa.shopnow.dao.DAOException;
import com.fssa.shopnow.model.User;
import com.fssa.shopnow.service.UserService;

/**
 * Servlet implementation class GetUser
 */
public class GetUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		
		UserService service = new UserService();
		try {
			List<User> userList = new ArrayList<User>();
			User user = service.getUserbyEmail(email);
			userList.add(user);
			JSONArray userJSonArray = new JSONArray(userList);
			PrintWriter out = response.getWriter();
			out.println(userJSonArray);
			out.flush();
			out.close();
			
		} catch (ClassNotFoundException | DAOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
