package com.fssa.shopnow.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.fssa.shopnow.dao.DAOException;
import com.fssa.shopnow.exception.InvalidAddressException;
import com.fssa.shopnow.exception.InvalidUserException;
import com.fssa.shopnow.model.Address;
import com.fssa.shopnow.model.Product;
import com.fssa.shopnow.service.AddressService;

/**
 * Servlet implementation class AddAddress
 */
public class AddAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAddress() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		
		AddressService service = new AddressService();
		
		
			 
			try {
				
				try {
					List<Address> AddressList = service.getAddressbyUser(Integer.parseInt(userId));
					JSONArray addressJsonArray = new JSONArray(AddressList);
					PrintWriter out = response.getWriter();
					out.println(addressJsonArray.toString());
					out.close();
					out.flush();
				} catch (ClassNotFoundException | DAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phoneNumber");
		String userId = request.getParameter("userId");
		String area = request.getParameter("area");
		String houseNumber = request.getParameter("houseNumber");
		String landmark = request.getParameter("landmark");
		String pincode = request.getParameter("pincode");
		
		Address address = new Address(name,phoneNumber,area,houseNumber,landmark,pincode);
		address.setUserId(Integer.parseInt(userId));
		
		AddressService service = new AddressService();
		PrintWriter out = response.getWriter();
		try {	
			service.addAddress(address);
			out.print(false);
		} catch (InvalidAddressException | SQLException | DAOException e) {
			out.println(e.getMessage());
			e.printStackTrace();
		}
		out.close();
		out.flush();
		
	}

}
