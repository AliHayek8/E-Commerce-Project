package com.ecommerce.service;

import com.ecommerce.dto.product.ProductRequestDTO;
import com.ecommerce.dto.product.ProductResponseDTO;
import com.ecommerce.exception.ProductNotFoundException;
import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // CREATE
    public ProductResponseDTO addProduct(ProductRequestDTO dto){

        Product product = mapToEntity(dto);

        Product savedProduct = productRepository.save(product);

        return mapToDTO(savedProduct);
    }

    // READ ALL
    public List<ProductResponseDTO> getAllProducts(){

        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // READ BY ID
    public ProductResponseDTO getProductById(Long id){

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        return mapToDTO(product);
    }

    // UPDATE
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO dto){

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        existingProduct.setName(dto.getName());
        existingProduct.setPrice(dto.getPrice());
        existingProduct.setStockQuantity(dto.getStockQuantity());

        Product updatedProduct = productRepository.save(existingProduct);

        return mapToDTO(updatedProduct);
    }

    // DELETE
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }


    //custom queries

    public List<ProductResponseDTO> filterProductsByPrice(double min, double max){

        List<Product> products = productRepository.findByPriceBetween(min, max);

        return products.stream()
                .map(this::mapToDTO)
                .toList();
    }


    public List<ProductResponseDTO> searchProducts(String name){

        List<Product> products = productRepository
                .findByNameContainingIgnoreCase(name);

        return products.stream()
                .map(this::mapToDTO)
                .toList();
    }


    public List<ProductResponseDTO> getProductsInStock(){

        List<Product> products =
                productRepository.findByStockQuantityGreaterThan(0);

        return products.stream()
                .map(this::mapToDTO)
                .toList();
    }



    public List<ProductResponseDTO> getProductsPaged(int page, int size){

        Pageable pageable = PageRequest.of(page, size);

        Page<Product> productPage = productRepository.findAll(pageable);

        return productPage.getContent()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }


    // =============================
    // Mapping Methods
    // =============================

    private Product mapToEntity(ProductRequestDTO dto){

        Product product = new Product();

        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStockQuantity(dto.getStockQuantity());

        return product;
    }

    private ProductResponseDTO mapToDTO(Product product){

        ProductResponseDTO dto = new ProductResponseDTO();

        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setStockQuantity(product.getStockQuantity());

        return dto;
    }

}