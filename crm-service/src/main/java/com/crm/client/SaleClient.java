/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.client;

import com.crm.model.Sale;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author ruben
 */
@FeignClient(name = "inventory-service", fallback = SaleHystrixFallbackFactory.class)
public interface SaleClient {
    
    @GetMapping("/sale/{id}")
    public Sale getSale(@PathVariable Long id);
    
    @PostMapping("/sale")
    public Sale save(@RequestBody Sale sale);
}
