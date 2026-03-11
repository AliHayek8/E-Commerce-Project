package com.ecommerce.controller;

import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.ecommerce.dto.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ApiResponse<List<Product>> getAllProducts(){

        List<Product> products = productService.getAllProducts();

        return new ApiResponse<>(
                true,
                "Products fetched successfully",
                products
        );
    }

    @PostMapping
    public ApiResponse<Product> addProduct(@RequestBody Product product){

        Product saved = productService.addProduct(product);

        return new ApiResponse<>(
                true,
                "Product created successfully",
                saved
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<Product> getProductById(@PathVariable Long id){

        Product product = productService.getProductById(id);

        return new ApiResponse<>(
                true,
                "Product fetched successfully",
                product
        );
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){

        productService.deleteProduct(id);

        return "Product deleted successfully";
    }

}