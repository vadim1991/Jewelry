package com.epam.Vadym_Vlasenko.eShop.service.product;

import com.epam.Vadym_Vlasenko.eShop.db.DBConnection;
import com.epam.Vadym_Vlasenko.eShop.db.dao.IProductDAO;
import com.epam.Vadym_Vlasenko.eShop.entity.Category;
import com.epam.Vadym_Vlasenko.eShop.entity.Criteria;
import com.epam.Vadym_Vlasenko.eShop.entity.Product;
import com.epam.Vadym_Vlasenko.eShop.service.transaction.TransactionManager;
import com.epam.Vadym_Vlasenko.eShop.service.transaction.TransactionOperation;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Вадим on 22.03.2015.
 */
public class ProductService implements IProductService {

    private TransactionManager tm;
    private IProductDAO productDAO;

    public ProductService(TransactionManager tm, IProductDAO productDAO) {
        this.tm = tm;
        this.productDAO = productDAO;
    }

    @Override
    public void addProduct(final Product product) {
        tm.transaction(new TransactionOperation<Void>() {
            @Override
            public Void execute() throws SQLException {
                productDAO.addProduct(product);
                return null;
            }
        });
    }

    @Override
    public boolean removeProduct(int id) {
        return false;
    }

    @Override
    public Product getProductByID(final int id) {
        return tm.transaction(new TransactionOperation<Product>() {
            @Override
            public Product execute() throws SQLException {
                return productDAO.getProductByID(id);
            }
        });
    }

    @Override
    public List<Product> getProducts() {
        return tm.transaction(new TransactionOperation<List<Product>>() {
            @Override
            public List<Product> execute() throws SQLException {
                return productDAO.getProducts();
            }
        });
    }

    @Override
    public int getCountOfProduct(final int idCategory) {
        return tm.transaction(new TransactionOperation<Integer>() {
            @Override
            public Integer execute() throws SQLException {
                return productDAO.getCountOfProduct(idCategory);
            }
        });
    }

    @Override
    public List<Product> getProducts(final int idCategory, final int offset, final int records) {
        return tm.transaction(new TransactionOperation<List<Product>>() {
            @Override
            public List<Product> execute() throws SQLException {
                return productDAO.getProducts(idCategory, offset, records);
            }
        });
    }

    @Override
    public List<Product> getProductsByCategory(final int idCategory) {
        return tm.transaction(new TransactionOperation<List<Product>>() {
            @Override
            public List<Product> execute() throws SQLException {
                return productDAO.getProductsByCategory(idCategory);
            }
        });
    }

    @Override
    public List<Product> getProductsByCriteria(final Criteria criteria) {
        return tm.transaction(new TransactionOperation<List<Product>>() {
            @Override
            public List<Product> execute() throws SQLException {
                return productDAO.getProductsByCriteria(criteria);
            }
        });
    }

    @Override
    public List<Product> getProductByName(String name) {
        return null;
    }

    @Override
    public List<Product> getProductsByRange(int minPrice, int maxPrice) {
        return null;
    }

    @Override
    public List<Product> getAllByMaterial(int id_material) {
        return null;
    }

    @Override
    public int getNoOfPages() {
        return productDAO.getNoOfPages();
    }
}
