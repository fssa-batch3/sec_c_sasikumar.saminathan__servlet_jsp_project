package com.fssa.shopnow.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.fssa.shopnow.dao.DAOException;
import com.fssa.shopnow.model.Product;
import com.fssa.shopnow.service.ProductService;

/**
 * Servlet implementation class GetProducts
 */
public class GetProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetProducts() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductService service = new ProductService();

		try {
			List<Product> productsList = service.getProducts();
			
			JSONArray accountsJSonArray = new JSONArray(productsList);
			PrintWriter out = response.getWriter();
			out.println(accountsJSonArray.toString());
			out.close();
			out.flush();
//			PrintWriter out = response.getWriter();
//
//			request.setAttribute("getProducts", productsList);
//			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			//rd.forward(request, response);
		} catch (ClassNotFoundException | DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
