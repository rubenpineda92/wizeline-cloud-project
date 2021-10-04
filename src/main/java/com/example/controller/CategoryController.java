/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.domain.Category;
import com.example.repository.CategoryRepository;
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
@RequestMapping("/categories")
public class CategoryController {
    
    @Autowired
    private CategoryRepository repo;
    
    @GetMapping
    public List<Category> getAll() {
        return (List<Category>) repo.findAll();
    }
    
    
    @PostMapping
    public Category save(@RequestBody Category category){
        return repo.save(category);
    }
}
