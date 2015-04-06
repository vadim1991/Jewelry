package com.epam.Vadym_Vlasenko.eShop.web.servlets;

import com.epam.Vadym_Vlasenko.eShop.entity.Product;
import com.epam.Vadym_Vlasenko.eShop.service.product.IProductService;
import com.epam.Vadym_Vlasenko.eShop.service.product.ProductService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Вадим on 22.03.2015.
 */
@WebServlet("/rings")
public class RingsServlet extends HttpServlet {

    private static final String PRODUCT_SERVICE = "product_service";

    private IProductService service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        service = (ProductService)config.getServletContext().getAttribute(PRODUCT_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = service.getProducts();
        req.setAttribute("products",products);
        req.getRequestDispatcher("collections.jsp").forward(req,resp);
    }
}
