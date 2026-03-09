package com.ecommerce.repository;

import com.ecommerce.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public List<Product> getAllProducts(){
        return products;
    }

    public Product getProductById(Long id){
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Product updateProduct(Long id, Product updatedProduct){

        for(Product product : products){

            if(product.getId().equals(id)){

                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());
                product.setStockQuantity(updatedProduct.getStockQuantity());

                return product;
            }

        }

        return null;
    }

    public boolean deleteProduct(Long id){

        return products.removeIf(product -> product.getId().equals(id));

    }
}