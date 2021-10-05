/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.client;

import com.crm.model.Sale;
import org.springframework.stereotype.Component;

/**
 *
 * @author ruben
 */
@Component
public class SaleHystrixFallbackFactory implements SaleClient {

    @Override
    public Sale getSale(Long id) {
        Sale sale = Sale.builder().build();
        
        return sale;
    }

    @Override
    public Sale save(Sale sale) {        
        return sale;
    }
    
}
