package com.epam.Vadym_Vlasenko.eShop.web.servlets;

import com.epam.Vadym_Vlasenko.eShop.entity.Product;
import com.epam.Vadym_Vlasenko.eShop.entity.cart.Cart;
import com.epam.Vadym_Vlasenko.eShop.service.cart.CartService;
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
 * Created by swift-seeker-89717 on 06.04.2015.
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    private IProductService productService;
    private CartService cartService;

    private static final int DEFAULT_AMOUNT = 1;
    private static final String CART_ATTRIBUTE = "cart";
    private static final String TOTAL_PRICE_ATTRIBUTE = "total";
    private static final String REMOVE_PARAMETER = "remove";
    private static final String ID_REMOVE_PARAMETER = "idRemove";
    private static final String ID_PARAMETER = "id";
    private static final String CART_JSP = "cart.jsp";

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        productService = (IProductService) context.getAttribute(Constants.PRODUCT_SERVICE);
        //cartService = (CartService) context.getAttribute(Constants.CART_SERVICE);
        cartService = new CartService(new Cart());
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String remove = req.getParameter(REMOVE_PARAMETER);
        String idRemove = req.getParameter(ID_REMOVE_PARAMETER);
        if (remove != null) {
            Product product = productService.getProductByID(Integer.parseInt(idRemove));
            cartService.delete(product);
            resp.getWriter().write(CART_ATTRIBUTE);
            return;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter(ID_PARAMETER);
        if (id != null) {
            Product product = productService.getProductByID(Integer.parseInt(id));
            cartService.addProduct(product, DEFAULT_AMOUNT);
        }
        double totalPrice = cartService.totalPrice();
        List<Integer> singlePrice = cartService.getSinglePrice();
        req.setAttribute("prices", singlePrice);
        req.setAttribute(CART_ATTRIBUTE, cartService.getContent());
        req.setAttribute(TOTAL_PRICE_ATTRIBUTE, totalPrice);
        req.getRequestDispatcher(CART_JSP).forward(req, resp);
    }

}
