package com.ecommerce.controller;

import com.ecommerce.dto.ApiResponse;
import com.ecommerce.dto.product.ProductRequestDTO;
import com.ecommerce.dto.product.ProductResponseDTO;
import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ApiResponse<List<ProductResponseDTO>> getAllProducts(){

        List<ProductResponseDTO> products = productService.getAllProducts();

        return new ApiResponse<>(
                true,
                "Products fetched successfully",
                products
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<ProductResponseDTO> getProductById(@PathVariable Long id){

        ProductResponseDTO product = productService.getProductById(id);

        return new ApiResponse<>(
                true,
                "Product fetched successfully",
                product
        );
    }

    @PostMapping
    public ApiResponse<ProductResponseDTO> addProduct(@RequestBody ProductRequestDTO dto){

        ProductResponseDTO saved = productService.addProduct(dto);

        return new ApiResponse<>(
                true,
                "Product created successfully",
                saved
        );
    }

    @PutMapping("/{id}")
    public ApiResponse<ProductResponseDTO> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductRequestDTO dto){

        ProductResponseDTO updated = productService.updateProduct(id, dto);

        return new ApiResponse<>(
                true,
                "Product updated successfully",
                updated
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteProduct(@PathVariable Long id){

        productService.deleteProduct(id);

        return new ApiResponse<>(
                true,
                "Product deleted successfully",
                null
        );
    }

}