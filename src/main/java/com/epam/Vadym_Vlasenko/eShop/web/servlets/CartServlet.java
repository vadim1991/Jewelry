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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by swift-seeker-89717 on 06.04.2015.
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    private IProductService service;
    private Map<Product, Integer> cart;
    private static final String PRODUCT_SERVICE = "product_service";

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        service = (IProductService) context.getAttribute(PRODUCT_SERVICE);
        cart = new HashMap<>();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String remove = req.getParameter("remove");
        String idRemove = req.getParameter("idRemove");
        if (remove != null) {
            cart.remove(service.getProductByID(Integer.parseInt(idRemove)));
            resp.getWriter().write("ok");
            return;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String remove = req.getParameter("remove");
        String idRemove = req.getParameter("idRemove");
        if (remove != null) {
            cart.remove(service.getProductByID(Integer.parseInt(idRemove)));
            resp.getWriter().write("ok");
            return;
        }
        String id = req.getParameter("id");
        addProduct(id);
        double totalCost = totalCost();
        //  List<Product> products = getProductFromCart();
        // List<Integer> countList = getCountList();
        // req.setAttribute("counts", countList);
        req.setAttribute("cart", cart);
        //  req.setAttribute("products", products);
        req.setAttribute("total", totalCost);
        req.getRequestDispatcher("cart.jsp").forward(req, resp);
    }

    private void addProduct(String idParam) {
        if (idParam != null) {
            int id = Integer.parseInt(idParam);
            Product product = service.getProductByID(id);
            if (cart.containsKey(product)) {
                int value = cart.get(product);
                cart.put(product, value + 1);
            } else {
                cart.put(product, 1);
            }
        }

    }

    private List<Integer> getCountList() {
        List<Integer> countList = new ArrayList<>();
        for (Map.Entry entry : cart.entrySet()) {
            countList.add((Integer) entry.getValue());
        }
        return countList;
    }

    private List<Product> getProductFromCart() {
        List<Product> products = new ArrayList<>();
        for (Map.Entry entry : cart.entrySet()) {
            products.add(service.getProductByID((Integer) entry.getKey()));
        }
        return products;
    }

    private double totalCost() {
        int result = 0;
        for (Map.Entry entry : cart.entrySet()) {
            Product product = (Product) entry.getKey();
            result += (product.getPrice() * (Integer) entry.getValue());
        }
        return result;
    }
}
