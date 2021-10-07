/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.domain.Product;
import com.example.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ruben
 */
@RestController
@RequestMapping("/inventory/products")
public class ProductController {
    
    @Autowired
    private ProductRepository repo;
    
    @GetMapping
    public List<Product> getAll() {
        return (List<Product>) repo.findAll();
    }
    
    
    @PostMapping
    public Product save(@RequestBody Product category){
        return repo.save(category);
    }
}
