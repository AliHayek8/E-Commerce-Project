package com.ecommerce.service;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void addProduct(Product product){
        productRepository.addProduct(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.getAllProducts();
    }

    public Product getProductById(Long id){
        return productRepository.getProductById(id);
    }

    public Product updateProduct(Long id, Product product){
        return productRepository.updateProduct(id, product);
    }

    public boolean deleteProduct(Long id){
        return productRepository.deleteProduct(id);
    }

}