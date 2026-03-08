package com.ecommerce.controller;

import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;

import java.util.List;

public class ProductController {

    private ProductService productService;


    public ProductController() {
        this.productService = new ProductService();
    }


    public void addProduct(Product product) {
        productService.addProduct(product);
        System.out.println("Product added: " + product.getName());
    }


    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

}
