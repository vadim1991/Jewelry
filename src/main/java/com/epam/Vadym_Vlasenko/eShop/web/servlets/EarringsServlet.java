package com.epam.Vadym_Vlasenko.eShop.web.servlets;

import com.epam.Vadym_Vlasenko.eShop.entity.Product;
import com.epam.Vadym_Vlasenko.eShop.service.product.IProductService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by swift-seeker-89717 on 10.04.2015.
 */
@WebServlet("/earrings")
public class EarringsServlet extends HttpServlet {

    private IProductService productService;

    private static final String EARRINGS_ATTRIBUTE = "products";

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        productService = (IProductService) context.getAttribute(Constants.PRODUCT_SERVICE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.getProductsByCategory(Constants.EARRINGS_CATEGORY);
        req.setAttribute(EARRINGS_ATTRIBUTE, products);
        req.getRequestDispatcher(Constants.EARRINGS_PAGE).forward(req, resp);
    }
}
