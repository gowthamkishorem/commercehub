package com.commercehub.app.product.controller;

import com.commercehub.app.product.dto.ProductResponse;
import com.commercehub.app.product.dto.ProductRequest;
import com.commercehub.app.product.entity.Product;
import com.commercehub.app.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductRequest request) {
        return productService.createProduct(request);
    }

    @GetMapping
    public List<ProductResponse> getProducts() {
        return productService.getProducts();

}}
