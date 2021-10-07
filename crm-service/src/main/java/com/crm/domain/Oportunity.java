/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.domain;

import com.crm.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author ruben
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Oportunity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private Double amount;
    
    @Transient
    private Double quantity;
    
    @Transient
    private Product product; 
    
    @JsonProperty("success_rate")
    private Double successRate;
    
    @ManyToOne
    @JoinColumn(name = "lead_id")
    @JsonProperty("lead_id")
    private Lead lead;
    
    
}
