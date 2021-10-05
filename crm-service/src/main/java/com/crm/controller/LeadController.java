/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.controller;

import com.crm.domain.Lead;
import com.crm.repository.LeadRepository;
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
@RequestMapping("/leads")
public class LeadController {
    
    @Autowired
    private LeadRepository repo;
    
    @GetMapping
    public List<Lead> getAll() {
        return (List<Lead>) repo.findAll();
    }
    
    @PostMapping
    public Lead save(@RequestBody Lead category){
        return repo.save(category);
    }
}
