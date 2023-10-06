package com.fssa.shopnow.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fssa.shopnow.dao.DAOException;
import com.fssa.shopnow.exception.InvalidAddressException;
import com.fssa.shopnow.service.AddressService;

/**
 * Servlet implementation class DeleteAddress
 */
@WebServlet("/DeleteAddress")
public class DeleteAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAddress() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		AddressService service = new AddressService();
		
		try {
			service.deleteAddress(Integer.parseInt(id));
		} catch (NumberFormatException | InvalidAddressException | ClassNotFoundException | DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
