/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.model;

import lombok.Builder;
import lombok.Data;


/**
 *
 * @author ruben
 */
@Data
@Builder
public class Sale {
    
    private Long id;
    
    private Double quantity;
    
    private Double price;
    
    private Double total;
    
    private Product product;
}
