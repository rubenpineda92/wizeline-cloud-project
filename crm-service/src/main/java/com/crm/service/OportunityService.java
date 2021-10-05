package com.crm.service;

import com.crm.client.SaleClient;
import com.crm.domain.Oportunity;
import com.crm.model.Sale;
import com.crm.repository.LeadRepository;
import com.crm.repository.OportunityRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ruben
 */
@Service
@AllArgsConstructor
public class OportunityService {
    
    private final OportunityRepository oportunityRepository;
    
    private final LeadRepository leadRepository;
    
    @Autowired
    private SaleClient saleClient;
    
    public Oportunity save(Oportunity oportunity) throws Exception {
        if(oportunity.getLead() == null){
            throw new Exception("The lead is required");
        }
        
        if(oportunity.getName()  == null) {
            throw new Exception("The name is required");
        }
        
        if(!leadRepository.existsById(oportunity.getLead().getId())){
            throw new Exception("The lead specified in the oportunity doesn't exist");
        }
        
        //If our lead have an 100% success, lets create the sale automatically
        if(oportunity.getSuccessRate() != null && oportunity.getSuccessRate() >= 100.0){
            createSale(oportunity);
        }
        
        return oportunityRepository.save(oportunity);
    }

    private void createSale(Oportunity oportunity) {
        Sale sale = Sale.builder().
                price(oportunity.getAmount() / oportunity.getQuantity()).
                quantity(oportunity.getQuantity()).
                total(oportunity.getAmount()).
                product(oportunity.getProduct()).build();
        
        
        saleClient.save(sale);
    }
}
