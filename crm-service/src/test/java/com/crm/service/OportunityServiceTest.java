/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.service;

import com.crm.domain.Lead;
import com.crm.domain.Oportunity;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import com.crm.repository.LeadRepository;
import com.crm.repository.OportunityRepository;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author ruben
 */
@SpringBootTest
public class OportunityServiceTest {
    
    @Mock
    private LeadRepository leadRepository;
    @Mock
    private OportunityRepository oportunityRepository;
    
    private AutoCloseable closeable;
    
    private OportunityService oportunityService;
    
    @BeforeEach
    public void beforeTests() {
        closeable = MockitoAnnotations.openMocks(this);
        oportunityService = new OportunityService(oportunityRepository, leadRepository, null);
        Lead lead = Lead.builder().strDirection("Iturbide 75").leadDate(new Date()).leadName("New lead 1").build();
        
        Mockito.when(leadRepository.findById(1L)).thenReturn(Optional.of(lead));
        Mockito.when(leadRepository.existsById(1L)).thenReturn(true);
        
        Mockito.when(oportunityRepository.save(Mockito.any())).thenReturn(Oportunity.builder().id(1L).build());
    }
    
    @AfterEach
    void closeService() throws Exception {
        closeable.close();
    }
    
    @Test
    public void saveTest() throws Exception {
        Oportunity oportunity = Oportunity.builder().
                name("New oportunity").
                amount(1000.0).
                successRate(100.0).
                lead(Lead.builder().id(1L).build()).
                build();
        
        Oportunity savedOportunity = oportunityService.save(oportunity);
        
        Assertions.assertTrue(savedOportunity.getId().equals(1L));
        
    }
    
    @Test
    public void whenLeadEmpty_thenThrowException() {
        Oportunity oportunity = Oportunity.builder().
                name("New Oportunity").
                amount(1000.0).
                successRate(100.0).
                build();
        
        Exception assertThrows = Assertions.assertThrows(Exception.class, () -> oportunityService.save(oportunity));
        
        Assertions.assertTrue(assertThrows.getMessage().contains("The lead is required"));
        
    }
    
    @Test
    public void whenNameEmpty_thenThrowException() {
        Oportunity oportunity = Oportunity.builder().
                amount(1000.0).
                successRate(100.0).
                lead(Lead.builder().id(1L).build()).
                build();
        
        Exception assertThrows = Assertions.assertThrows(Exception.class, () -> oportunityService.save(oportunity));
        
        Assertions.assertTrue(assertThrows.getMessage().contains("The name is required"));
        
    }
    
    @Test
    public void whenLeadDoesntExist_thenThrowException() {
        Oportunity oportunity = Oportunity.builder().
                amount(1000.0).
                successRate(100.0).
                lead(Lead.builder().id(2L).build()).
                build();
        
        Exception assertThrows = Assertions.assertThrows(Exception.class, () -> oportunityService.save(oportunity));
        
        Assertions.assertTrue(assertThrows.getMessage().contains("The name is required"));
        
    }
    
}
