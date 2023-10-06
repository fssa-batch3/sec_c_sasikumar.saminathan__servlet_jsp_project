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

import org.json.JSONArray;

import com.fssa.shopnow.dao.DAOException;
import com.fssa.shopnow.exception.InvalidAddressException;
import com.fssa.shopnow.model.Address;
import com.fssa.shopnow.model.Product;
import com.fssa.shopnow.service.AddressService;

/**
 * Servlet implementation class UpdateAddress
 */
public class UpdateAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAddress() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		AddressService service = new AddressService();
		
		try {
			Address address = service.getAddressById(Integer.parseInt(id));
			List<Address> AddressList = new ArrayList<Address>();
			AddressList.add(address);
			JSONArray addressJson = new JSONArray(AddressList);
			PrintWriter out = response.getWriter();
			out.println(addressJson);
			out.flush();
			out.close();
			
		} catch (NumberFormatException | ClassNotFoundException | DAOException | SQLException e) {
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
		String id = request.getParameter("id");
		String area = request.getParameter("area");
		String houseNumber = request.getParameter("houseNumber");
		String landmark = request.getParameter("landmark");
		String pincode = request.getParameter("pincode");
		
		AddressService service = new AddressService();
		PrintWriter out = response.getWriter();
		
		Address address = new Address(name, phoneNumber, area, houseNumber, landmark, pincode);
		
		try {
			service.updateAddress(address, Integer.parseInt(id));
			out.print(false);
		} catch (NumberFormatException | InvalidAddressException | ClassNotFoundException | DAOException e) {
			// TODO Auto-generated catch block
			out.println(e.getMessage());
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

}
