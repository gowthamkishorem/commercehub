package com.commercehub.app.product.service;

import com.commercehub.app.common.exception.ProductNotFoundException;
import com.commercehub.app.product.dto.ProductResponse;
import com.commercehub.app.product.dto.ProductRequest;
import com.commercehub.app.product.entity.Product;
import com.commercehub.app.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class ProductService {

        private final ProductRepository productRepository;

        public ProductService(ProductRepository productRepository) {
            this.productRepository = productRepository;
        }

    public ProductResponse createProduct(ProductRequest request) {

        // 1. Convert DTO -> Entity
        Product product = new Product();

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());

        // 2. Save Entity
        Product savedProduct = productRepository.save(product);

        // 3. Convert Entity -> Response DTO
        ProductResponse response = new ProductResponse();

        response.setId(savedProduct.getId());
        response.setName(savedProduct.getName());
        response.setDescription(savedProduct.getDescription());
        response.setPrice(savedProduct.getPrice());
        response.setQuantity(savedProduct.getQuantity());

        return response;
    }
    public List<ProductResponse> getProducts() {

        return productRepository.findAll()
                .stream()
                .map(product -> {
                    ProductResponse response = new ProductResponse();

                    response.setId(product.getId());
                    response.setName(product.getName());
                    response.setDescription(product.getDescription());
                    response.setPrice(product.getPrice());
                    response.setQuantity(product.getQuantity());

                    return response;
                })
                .toList();
    }

    public ProductResponse getProductById(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id " + id));

        ProductResponse response = new ProductResponse();

        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setQuantity(product.getQuantity());

        return response;
    }



}
