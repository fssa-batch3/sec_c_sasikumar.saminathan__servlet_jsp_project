package com.fssa.shopnow.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fssa.shopnow.dao.DAOException;
import com.fssa.shopnow.exception.InvalidProductException;
import com.fssa.shopnow.model.Product;
import com.fssa.shopnow.service.ProductService;

/**
 * Servlet implementation class postProducts
 */
@WebServlet("/PostProducts")
public class PostProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String ram = request.getParameter("ram");
		String storage = request.getParameter("storage");
		String img1 = request.getParameter("img1");
		String img2 = request.getParameter("img2");
		String img3 = request.getParameter("img3");
		String img4 = request.getParameter("img4");
		String description = request.getParameter("desc");
		
		ProductService service = new ProductService();
		
		Product product = new Product();
		product.setName(name);
		product.setPrice(Double.parseDouble(price));
		product.setRam(Integer.parseInt(ram));
		product.setStorage(Integer.parseInt(storage));
		product.setDescription(description);
		product.setBrand("mobile");
		product.setQuantity(1);
		
		List<String> imageList = new ArrayList<>();
		imageList.add(img1);
		imageList.add(img2);
		imageList.add(img3);
		imageList.add(img4);
		
		//Adding image list into Product
		product.setImageURL(imageList);
		
		
		try {
			service.addProduct(product);
			service.addImageUrls(imageList, name);
			
		} catch (InvalidProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
