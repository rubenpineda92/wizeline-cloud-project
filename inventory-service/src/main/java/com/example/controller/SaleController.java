/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.domain.Sale;
import com.example.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ruben
 */
@RestController
@RequestMapping("/sale")
public class SaleController {
    
    @Autowired
    private SaleRepository repo;
    
    
    @GetMapping("/{id}")
    public Sale getSale(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }
    
    @PostMapping
    public Sale save(@RequestBody Sale sale){
        return repo.save(sale);
    }
}
