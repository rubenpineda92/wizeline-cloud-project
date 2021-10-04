/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service;

import com.example.domain.Sale;
import com.example.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ruben
 */
@Service
public class SaleService {
    
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private ProductService productService;
    
    public Sale registerSale(Sale sale) throws Exception {
        if(sale.getPrice() == null || sale.getPrice() <= 0.0){
            throw new Exception("Invalid price");
        }
        
        if(sale.getProduct() == null || sale.getProduct().getId() == null){
            throw new Exception("Invalid product");
        }
        
        if(sale.getQuantity() == null || sale.getQuantity() <= 0.0) {
            throw new Exception("Invalid quantity");
        }
        
        sale.setTotal(sale.getQuantity() * sale.getPrice());
        
        sale = saleRepository.save(sale);
        
        productService.registerSale(sale);
        
        return sale;
    }
}
