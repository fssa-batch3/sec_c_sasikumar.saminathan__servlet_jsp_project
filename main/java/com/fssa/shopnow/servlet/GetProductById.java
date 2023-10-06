package com.fssa.shopnow.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.fssa.shopnow.dao.DAOException;
import com.fssa.shopnow.model.Product;
import com.fssa.shopnow.service.ProductService;

/**
 * Servlet implementation class GetProductById
 */
public class GetProductById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProductById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		ProductService service = new ProductService();
		
		try {
			Product smartPhone = service.getProuctById(Integer.parseInt(id));
			List<Product> productList = new ArrayList<Product>();
			productList.add(smartPhone);
			JSONArray productJson = new JSONArray(productList);
			PrintWriter out = response.getWriter();
			out.println(productJson);
			out.flush();
			out.close();
			
		} catch (NumberFormatException | ClassNotFoundException | DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
