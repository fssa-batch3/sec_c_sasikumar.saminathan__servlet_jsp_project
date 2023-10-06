package com.fssa.shopnow.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.fssa.shopnow.dao.DAOException;
import com.fssa.shopnow.exception.InvalidOrderException;
import com.fssa.shopnow.model.Order;
import com.fssa.shopnow.model.Product;
import com.fssa.shopnow.service.OrderService;

/**
 * Servlet implementation class AddOrder
 */
public class AddOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		OrderService service = new OrderService();
		
		try {
			List<Order> OrdersList = service.getOrdersById(userId);
			
			JSONArray ordersJSonArray = new JSONArray(OrdersList);
			PrintWriter out = response.getWriter();
			out.println(ordersJSonArray.toString());
			out.close();
			out.flush();
			
		} catch (ClassNotFoundException | DAOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		int productId = Integer.parseInt(request.getParameter("productId"));
		int addressId = Integer.parseInt(request.getParameter("addressId"));
		int shopId = Integer.parseInt(request.getParameter("shopId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String status = request.getParameter("status");
		String paymentMethod = request.getParameter("paymentMethod");
		LocalDate date = LocalDate.now();
		OrderService service = new OrderService();
		
		Order order = new Order(date, addressId, status, productId, quantity, shopId, userId, paymentMethod);
		
		try {
			service.addOrder(order);
		} catch (InvalidOrderException | SQLException | DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
