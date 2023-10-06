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
import com.fssa.shopnow.model.Shop;
import com.fssa.shopnow.service.ProductService;
import com.fssa.shopnow.service.ShopService;

/**
 * Servlet implementation class GetShops
 */
public class GetShops extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetShops() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShopService service = new ShopService();
		
		// Get the query parameter 'myArray' from the URL
        String queryString = request.getParameter("shopArray");
        
        if (queryString != null && !queryString.isEmpty()) {
            // Split the query string into an array
            String[] array = queryString.split(",");
            
            try {
				List<Shop> shopList = service.getShopsByProduct(array);
				
				JSONArray productJSonArray = new JSONArray(shopList);
				PrintWriter out = response.getWriter();
				out.println(productJSonArray);
				out.flush();
				out.close();
			} catch (SQLException | DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        
	}
	

}
