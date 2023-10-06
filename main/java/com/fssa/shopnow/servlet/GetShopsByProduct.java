package com.fssa.shopnow.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.fssa.shopnow.dao.DAOException;
import com.fssa.shopnow.service.ProductService;
import com.mysql.cj.xdevapi.JsonArray;

/**
 * Servlet implementation class GetShopsByProduct
 */
public class GetShopsByProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetShopsByProduct() {
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
			//Getting the productName by Id
			String productName = service.getProductNamebyId(Integer.parseInt(id));
			
			//Getting the shopList which they have this product
			List<Integer> shopList = service.getShopListbyProductName(productName);
			
			JSONArray shopArray = new JSONArray(shopList);
			PrintWriter out = response.getWriter();
			out.println(shopArray.toString());
			out.close();
			out.flush();
		} catch (NumberFormatException | DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
