/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.controller;

import com.crm.domain.Oportunity;
import com.crm.repository.OportunityRepository;
import com.crm.service.OportunityService;
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
@RequestMapping("crm/oportunities")
public class OportunityController {
    
    @Autowired
    private OportunityRepository repo;
    
    @Autowired
    private OportunityService oportunityService;
    
    @GetMapping
    public List<Oportunity> getAll() {
        return (List<Oportunity>) repo.findAll();
    }
    
    @PostMapping
    public Oportunity save(@RequestBody Oportunity category) throws Exception{
        return oportunityService.save(category);
    }
}
