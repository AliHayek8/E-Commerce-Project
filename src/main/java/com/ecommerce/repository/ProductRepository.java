package com.ecommerce.repository;

import com.ecommerce.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private static ProductRepository instance;

    private List<Product> products;


    private ProductRepository() {
        products = new ArrayList<>();
    }


    public static ProductRepository getInstance() {
        if (instance == null) {
            instance = new ProductRepository();
        }
        return instance;
    }


    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
