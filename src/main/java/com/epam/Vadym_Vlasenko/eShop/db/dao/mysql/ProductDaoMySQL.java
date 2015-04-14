package com.epam.Vadym_Vlasenko.eShop.db.dao.mysql;

import com.epam.Vadym_Vlasenko.eShop.db.DBConnection;
import com.epam.Vadym_Vlasenko.eShop.db.dao.IProductDAO;
import com.epam.Vadym_Vlasenko.eShop.db.query_builder.QueryCreator;
import com.epam.Vadym_Vlasenko.eShop.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.epam.Vadym_Vlasenko.eShop.db.util.DBUtil.*;

/**
 * Created by Вадим on 22.03.2015.
 */
public class ProductDaoMySQL implements IProductDAO {

    private int noOfPages;

    private static final String PRODUCT_TABLE = "products";
    private static final String ADD_PRODUCT = "INSERT INTO products VALUES (DEFAULT ,?,?,?,?,?,?,?,?,?)";
    private static final String SELECT_FOUND_ROWS = "SELECT FOUND_ROWS()";
    private static final String GET_COUNT_OF_PRODUCT = "SELECT COUNT(*) FROM products WHERE category=?";
    private static final String GET_PRODUCT_BY_ID = "SELECT * FROM products WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM products";
    private static final String GET_ALL_PAGE = "SELECT * FROM products WHERE category=? LIMIT ?,?";
    private static final String GET_CATEGORY_BY_ID = "SELECT * FROM category WHERE id=?";
    private static final String GET_MATERIAL_BY_ID = "SELECT * FROM materials WHERE id=?";
    private static final String GET_INSERT_BY_ID = "SELECT * FROM inserts WHERE id=?";
    private static final String GET_IMAGE_BY_ID = "SELECT * FROM image WHERE id=?";
    private static final String GET_PRODUCTS_BY_CATEGORY = "SELECT * FROM products WHERE category=?";
    private static final String GET_PRODUCTS_BY_CATEGORY_AND_INSERT = "SELECT * FROM products WHERE category=? AND insert_id=?";

    @Override
    public boolean addProduct(Product product) throws SQLException {
        Connection connection = DBConnection.getConnectionHolder().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_PRODUCT)) {
            int index = 1;
            preparedStatement.setString(index++, product.getTitle());
            preparedStatement.setInt(index++, product.getPrice());
            preparedStatement.setString(index++, product.getDescription());
            preparedStatement.setInt(index++, product.getImage().getId());
            preparedStatement.setDouble(index++, product.getWeight());
            preparedStatement.setInt(index++, product.getInsert().getId());
            preparedStatement.setInt(index++, product.getMaterial().getId());
            preparedStatement.setInt(index++, product.getCategory().getId());
            preparedStatement.setDouble(index++, product.getSize());
            preparedStatement.executeUpdate();
        } finally {
            closeConnection(connection);
        }
        return true;
    }

    @Override
    public Product getProductByID(int id) {
        Product product = new Product();
        try (Connection connection = DBConnection.getConnectionHolder().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_BY_ID)) {
            int index = 1;
            preparedStatement.setInt(index, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                product = extractProduct(resultSet);
            }
        } catch (SQLException e) {

        }
        return product;
    }

    @Override
    public List<Product> getProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection connection = DBConnection.getConnectionHolder().getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    products.add(extractProduct(resultSet));
                }
            }
        } finally {
            closeConnection(connection);
        }
        return products;
    }

    @Override
    public List<Product> getProducts(int idCategory, int offset, int records) throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection connection = DBConnection.getConnectionHolder().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PAGE)) {
            int index = 1;
            preparedStatement.setInt(index++, idCategory);
            preparedStatement.setInt(index++, offset);
            preparedStatement.setInt(index++, records);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    products.add(extractProduct(resultSet));
                }
            }
        } finally {
            closeConnection(connection);
        }
        return products;
    }

    @Override
    public List<Product> getProductsByCategory(int idCategory) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = DBConnection.getConnectionHolder().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCTS_BY_CATEGORY)) {
            int index = 1;
            preparedStatement.setInt(index, idCategory);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                products.add(extractProduct(resultSet));
            }
        } catch (SQLException e) {

        }
        return products;
    }

    @Override
    public List<Product> getProductsByCriteria(Criteria criteria) {
        List<Product> products = new ArrayList<>();
        String query = new QueryCreator().buildCriteria(criteria, PRODUCT_TABLE);
        try (Connection connection = DBConnection.getConnectionHolder().getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                products.add(extractProduct(resultSet));
            }
            resultSet.close();
            resultSet = statement.executeQuery(SELECT_FOUND_ROWS);
            if (resultSet.next()) {
                this.noOfPages = resultSet.getInt(1);
                System.out.println(noOfPages);
            }
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
        return products;
    }

    @Override
    public int getCountOfProduct(int idCategory) throws SQLException {
        int count = 0;
        try (Connection connection = DBConnection.getConnectionHolder().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_COUNT_OF_PRODUCT)) {
            int index = 1;
            preparedStatement.setInt(index, idCategory);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        }
        return count;
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
    public List<Product> getAllByCategoryAndInsert(int id_category, int id_insert) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = DBConnection.getConnectionHolder().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCTS_BY_CATEGORY)) {
            int index = 1;
            preparedStatement.setInt(index++, id_category);
            preparedStatement.setInt(index++, id_insert);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                products.add(extractProduct(resultSet));
            }
        } catch (SQLException e) {

        }
        return products;
    }

    @Override
    public boolean removeProduct(int id) {
        return false;
    }

    public Category getCategoryByID(int id) throws SQLException {
        Category category = new Category();
        Connection connection = DBConnection.getConnectionHolder().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_CATEGORY_BY_ID)) {
            int index = 1;
            preparedStatement.setInt(index, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("title"));
            }
        } finally {
            closeConnection(connection);
        }
        return category;
    }

    public Image getImageByID(int id) throws SQLException {
        Image image = new Image();
        Connection connection = DBConnection.getConnectionHolder().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_IMAGE_BY_ID)) {
            int index = 1;
            preparedStatement.setInt(index, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                image.setId(resultSet.getInt("id"));
                image.setTitle(resultSet.getString("title"));
                image.setUrl(resultSet.getString("url"));
            }
        } finally {
            closeConnection(connection);
        }
        return image;
    }

    public Material getMaterialByID(int id) throws SQLException {
        Material material = new Material();
        Connection connection = DBConnection.getConnectionHolder().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_MATERIAL_BY_ID)) {
            int index = 1;
            preparedStatement.setInt(index, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                material.setId(resultSet.getInt("id"));
                material.setName(resultSet.getString("name"));
            }
        } finally {
            closeConnection(connection);
        }
        return material;
    }

    public Insert getInsertByID(int id) throws SQLException {
        Insert insert = new Insert();
        Connection connection = DBConnection.getConnectionHolder().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_INSERT_BY_ID)) {
            int index = 1;
            preparedStatement.setInt(index, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                insert.setId(resultSet.getInt("id"));
                insert.setTitle(resultSet.getString("name"));
            }
        } finally {
            closeConnection(connection);
        }
        return insert;
    }

    private Product extractProduct(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setTitle(rs.getString("title"));
        product.setPrice(rs.getInt("price"));
        product.setDescription(rs.getString("description"));
        product.setImage(getImageByID(rs.getInt("image_id")));
        product.setWeight(rs.getDouble("weight"));
        product.setInsert(getInsertByID(rs.getInt("insert_id")));
        product.setMaterial(getMaterialByID(rs.getInt("material")));
        product.setCategory(getCategoryByID(rs.getInt("category")));
        product.setSize(rs.getDouble("size"));
        return product;
    }

    public int getNoOfPages() {
        return noOfPages;
    }
}
