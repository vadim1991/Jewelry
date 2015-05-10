package com.epam.Vadym_Vlasenko.eShop.web.servlets;

import com.epam.Vadym_Vlasenko.eShop.entity.Criteria;
import com.epam.Vadym_Vlasenko.eShop.entity.Product;
import com.epam.Vadym_Vlasenko.eShop.service.product.IProductService;
import com.epam.Vadym_Vlasenko.eShop.service.product.ProductService;
import com.epam.Vadym_Vlasenko.eShop.web.Constants;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.ServletConfig;
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

    private static final String PRODUCT_SERVICE = "product_service";

    private static final String ENCODING_TYPE = "utf-8";
    private static final int PRODUCT_ON_PAGE_DEFAULT = 6;

    private static final String EARRINGS_ATTRIBUTE = "products";
    private static final String CURRENT_PAGE_ATTRIBUTE = "currentPage";
    private static final String PAGE_PARAMETER = "page";
    private static final String MIN_PRICE_PARAMETER = "minPrice";
    private static final String MAX_PRICE_PARAMETER = "maxPrice";
    private static final String MIN_WEIGHT_PARAMETER = "minWeight";
    private static final String MAX_WEIGHT_PARAMETER = "maxWeight";
    private static final String INSERT_PARAMETER = "insert";
    private static final String MATERIAL_PARAMETER = "material";
    private static final String PRODUCT_ON_PAGE_PARAMETER = "noOfPages";
    private static final String SORT_TYPE_PARAMETER = "sortType";

    private IProductService productService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        productService = (ProductService) config.getServletContext().getAttribute(PRODUCT_SERVICE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(ENCODING_TYPE);
        resp.setCharacterEncoding(ENCODING_TYPE);
        Gson gson = new Gson();
        int page = 1;
        int records = PRODUCT_ON_PAGE_DEFAULT;
        String pageValue = req.getParameter(PAGE_PARAMETER);
        if (pageValue != null) {
            page = Integer.parseInt(pageValue);
        }
        Criteria criteria = getCriteria(req);
        criteria.setPositionFrom((page - 1) * records);
        criteria.setProductOnPage(records);
        List<Product> products = productService.getProductsByCriteria(criteria);
        int countProduct = productService.getNoOfPages();
        int noOfPages = (int) Math.ceil(countProduct * 1.0 / records);
        if (products == null) {
            req.getRequestDispatcher(Constants.BED_REQUEST_PAGE).forward(req, resp);
            return;
        }
        JsonObject object = new JsonObject();
        object.addProperty(PRODUCT_ON_PAGE_PARAMETER, noOfPages);
        object.addProperty(CURRENT_PAGE_ATTRIBUTE, page);
        object.add(EARRINGS_ATTRIBUTE, gson.toJsonTree(products));
        resp.getWriter().write(gson.toJson(object));
    }

    private Criteria getCriteria(HttpServletRequest request) {
        Criteria criteria = new Criteria();
        criteria.setIdCategory(Constants.EARRINGS_CATEGORY);
        criteria.setMaxPrice(request.getParameter(MAX_PRICE_PARAMETER));
        criteria.setMinPrice(request.getParameter(MIN_PRICE_PARAMETER));
        criteria.setMinWeight(request.getParameter(MIN_WEIGHT_PARAMETER));
        criteria.setMaxWeight(request.getParameter(MAX_WEIGHT_PARAMETER));
        criteria.setInsertId(request.getParameter(INSERT_PARAMETER));
        criteria.setMaterialId(request.getParameter(MATERIAL_PARAMETER));
        criteria.setSortType(request.getParameter(SORT_TYPE_PARAMETER));
        return criteria;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Constants.EARRINGS_PAGE).forward(req, resp);
    }
}
