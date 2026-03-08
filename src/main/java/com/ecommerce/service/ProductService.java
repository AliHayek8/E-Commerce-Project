package com.ecommerce.service;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import java.util.List;

public class ProductService {

    private ProductRepository productRepository;


    public ProductService() {
        // Use singleton to get repository version
        this.productRepository = ProductRepository.getInstance();
    }


    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }


    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

}
