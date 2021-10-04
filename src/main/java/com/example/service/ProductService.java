/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service;

import com.example.domain.Product;
import com.example.domain.Sale;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ruben
 */
@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public void registerSale(Sale sale) throws Exception {
        Product product = productRepository.findById(sale.getProduct().getId()).orElseThrow(() -> new Exception("Invalid product id"));
    
        Double stock = product.getStock() == null ? 0.0 : product.getStock();
        Double newStock = stock -= sale.getQuantity();
        
        product.setStock(newStock);
        
        productRepository.save(product);
    }
}
