package com.epam.Vadym_Vlasenko.eShop.db.dao.mysql;

import com.epam.Vadym_Vlasenko.eShop.db.DBConnectionHolder;
import com.epam.Vadym_Vlasenko.eShop.db.dao.IProductDAO;
import com.epam.Vadym_Vlasenko.eShop.db.query_builder.QueryCreator;
import com.epam.Vadym_Vlasenko.eShop.entity.*;
import com.epam.Vadym_Vlasenko.eShop.entity.criteria.CriteriaResultBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Вадим on 22.03.2015.
 */
public class ProductDaoMySQL implements IProductDAO {

    private static final String ID_COLUMN = "id";
    private static final String TITLE_COLUMN = "title";
    private static final String PRICE_COLUMN = "price";
    private static final String INSERT_ID_COLUMN = "insert_id";
    private static final String MATERIAL_ID_COLUMN = "material";
    private static final String IMAGE_ID_COLUMN = "image_id";
    private static final String CATEGORY_ID_COLUMN = "category";
    private static final String WEIGHT_COLUMN = "weight";
    private static final String SIZE_COLUMN = "size";
    private static final String DESCRIPTION_COLUMN = "description";
    private static final String NAME_COLUMN = "name";

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
    private static final String GET_PRODUCTS_BY_CATEGORY = "SELECT * FROM products WHERE category=?";

    private static final ImageDaoMySQL imageDao = new ImageDaoMySQL();

    @Override
    public boolean addProduct(Product product) throws SQLException {
        Connection connection = DBConnectionHolder.getConnectionHolder().getConnection();
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
        }
        return true;
    }

    @Override
    public Product getProductByID(int id) throws SQLException {
        Product product = null;
        Connection connection = DBConnectionHolder.getConnectionHolder().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_BY_ID)) {
            int index = 1;
            preparedStatement.setInt(index, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                product = extractProduct(resultSet, connection);
            }
        }
        return product;
    }

    @Override
    public List<Product> getProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection connection = DBConnectionHolder.getConnectionHolder().getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    products.add(extractProduct(resultSet, connection));
                }
            }
        }
        return products;
    }

    @Override
    public List<Product> getProducts(int idCategory, int offset, int records) throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection connection = DBConnectionHolder.getConnectionHolder().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PAGE)) {
            int index = 1;
            preparedStatement.setInt(index++, idCategory);
            preparedStatement.setInt(index++, offset);
            preparedStatement.setInt(index++, records);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    products.add(extractProduct(resultSet, connection));
                }
            }
        }
        return products;
    }

    @Override
    public List<Product> getProductsByCategory(int idCategory) throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection connection = DBConnectionHolder.getConnectionHolder().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCTS_BY_CATEGORY)) {
            int index = 1;
            preparedStatement.setInt(index, idCategory);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                products.add(extractProduct(resultSet, connection));
            }
        }
        return products;
    }

    @Override
    public CriteriaResultBean getProductsByCriteria(Criteria criteria) throws SQLException {
        List<Product> products = new ArrayList<>();
        int noOfPages = 0;
        String query = new QueryCreator().buildCriteria(criteria, PRODUCT_TABLE);
        Connection connection = DBConnectionHolder.getConnectionHolder().getConnection();
        try (Statement statement = connection.createStatement()) {
            Connection newConnection = DBConnectionHolder.getConnectionHolder().getConnectionNew();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                products.add(extractProduct(resultSet, newConnection));
            }
            resultSet.close();
            resultSet = statement.executeQuery(SELECT_FOUND_ROWS);
            if (resultSet.next()) {
                noOfPages = resultSet.getInt(1);
            }
            resultSet.close();
            newConnection.close();
        }
        return new CriteriaResultBean(noOfPages, products);
    }

    @Override
    public boolean removeProduct(int id) {
        return false;
    }

    public Category getCategoryByID(int id, Connection connection) throws SQLException {
        Category category = new Category();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_CATEGORY_BY_ID)) {
            int index = 1;
            preparedStatement.setInt(index, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                category.setId(resultSet.getInt(ID_COLUMN));
                category.setName(resultSet.getString(TITLE_COLUMN));
            }
            resultSet.close();
        }
        return category;
    }

    public Material getMaterialByID(int id, Connection connection) throws SQLException {
        Material material = new Material();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_MATERIAL_BY_ID)) {
            int index = 1;
            preparedStatement.setInt(index, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                material.setId(resultSet.getInt(ID_COLUMN));
                material.setName(resultSet.getString(NAME_COLUMN));
            }
            resultSet.close();
        }
        return material;
    }

    public Insert getInsertByID(int id, Connection connection) throws SQLException {
        Insert insert = new Insert();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_INSERT_BY_ID)) {
            int index = 1;
            preparedStatement.setInt(index, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                insert.setId(resultSet.getInt(ID_COLUMN));
                insert.setTitle(resultSet.getString(NAME_COLUMN));
            }
            resultSet.close();
        }
        return insert;
    }

    private Product extractProduct(ResultSet rs, Connection connection) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt(ID_COLUMN));
        product.setTitle(rs.getString(TITLE_COLUMN));
        product.setPrice(rs.getInt(PRICE_COLUMN));
        product.setDescription(rs.getString(DESCRIPTION_COLUMN));
        product.setImage(imageDao.getImageById(rs.getInt(IMAGE_ID_COLUMN), connection));
        product.setWeight(rs.getDouble(WEIGHT_COLUMN));
        product.setInsert(getInsertByID(rs.getInt(INSERT_ID_COLUMN), connection));
        product.setMaterial(getMaterialByID(rs.getInt(MATERIAL_ID_COLUMN), connection));
        product.setCategory(getCategoryByID(rs.getInt(CATEGORY_ID_COLUMN), connection));
        product.setSize(rs.getDouble(SIZE_COLUMN));
        return product;
    }

}
