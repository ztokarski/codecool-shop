package com.codecool.shop.dao;

import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marek on 25.04.17.
 */
public class ProductDaoImpl implements ProductDao {

    @Override
    public void add(Product product) {

    }

    @Override
    public Product find(int id) {
        Product newProduct = null;
        String query = "SELECT * from Products where id='" + id + "'";
        ResultSet resultSet = Connector.getQueryResult(query);
        try {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Float price = resultSet.getFloat("price");
                String description = resultSet.getString("description");
                String currency = resultSet.getString("currency");
                Integer idProductCategory = resultSet.getInt("id_productCategory");
                ProductCategory productCategory = new ProductCategoryDaoImpl()
                    .find(idProductCategory);
                Integer idSupplier = resultSet.getInt("id_supplier");
                Supplier supplier = new SupplierDaoImpl().find(idSupplier);
                newProduct = new Product(id, name, price, description, currency,
                    productCategory, supplier);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + " in product :" + e.getMessage());
            System.exit(0);
        }
        return newProduct;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public ArrayList<Product> getAll() {
        ArrayList<Product> listProducts = new ArrayList<>();
        String query = "SELECT * from Products";
        ResultSet resultSet = Connector.getQueryResult(query);
        try {
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Float price = resultSet.getFloat("price");
                String description = resultSet.getString("description");
                String currency = resultSet.getString("currency");
                Integer idProductCategory = resultSet.getInt("id_productCategory");
                ProductCategory productCategory = new ProductCategoryDaoImpl()
                    .find(idProductCategory);
                Integer idSupplier = resultSet.getInt("id_supplier");
                Supplier supplier = new SupplierDaoImpl().find(idSupplier);
                Product newProduct = new Product(id, name, price, description, currency,
                    productCategory, supplier);
                listProducts.add(newProduct);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + " in productdaoimpl :" + e.getMessage());
            System.exit(0);
        }
        return listProducts;
    }

    @Override
    public List<Product> getBy(Supplier supplier) {
        return null;
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        return null;
    }
}
