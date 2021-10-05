package com.crm.service;

import com.crm.domain.Oportunity;
import com.crm.repository.LeadRepository;
import com.crm.repository.OportunityRepository;
import lombok.AllArgsConstructor;
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
        
        return oportunityRepository.save(oportunity);
    }
}
