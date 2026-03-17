package com.ecommerce.controller;

import com.ecommerce.dto.ApiResponse;
import com.ecommerce.dto.product.ProductRequestDTO;
import com.ecommerce.dto.product.ProductResponseDTO;
import com.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping("/{id:\\d+}")
    public ApiResponse<ProductResponseDTO> getProductById(@PathVariable Long id){

        ProductResponseDTO product = productService.getProductById(id);

        return new ApiResponse<>(
                true,
                "Product fetched successfully",
                product
        );
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ApiResponse<ProductResponseDTO> addProduct(@Valid @RequestBody ProductRequestDTO dto){

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

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteProduct(@PathVariable Long id){

        productService.deleteProduct(id);

        return new ApiResponse<>(
                true,
                "Product deleted successfully",
                null
        );
    }

    @GetMapping("/filter")
    public ApiResponse<List<ProductResponseDTO>> filterProducts(
            @RequestParam double minPrice,
            @RequestParam double maxPrice){

        List<ProductResponseDTO> products =
                productService.filterProductsByPrice(minPrice, maxPrice);

        return new ApiResponse<>(
                true,
                "Products filtered successfully",
                products
        );
    }


    @GetMapping("/search")
    public ApiResponse<List<ProductResponseDTO>> searchProducts(
            @RequestParam String name){

        List<ProductResponseDTO> products =
                productService.searchProducts(name);

        return new ApiResponse<>(
                true,
                "Products found successfully",
                products
        );
    }


    @GetMapping("/in-stock")
    public ApiResponse<List<ProductResponseDTO>> getProductsInStock(){

        List<ProductResponseDTO> products =
                productService.getProductsInStock();

        return new ApiResponse<>(
                true,
                "Products in stock",
                products
        );
    }


    @GetMapping("/paged")
    public ApiResponse<List<ProductResponseDTO>> getProductsPaged(
            @RequestParam int page,
            @RequestParam int size){

        List<ProductResponseDTO> products =
                productService.getProductsPaged(page, size);

        return new ApiResponse<>(
                true,
                "Products page fetched successfully",
                products
        );
    }


}