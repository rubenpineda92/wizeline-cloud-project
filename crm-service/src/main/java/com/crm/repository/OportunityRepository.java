package com.crm.repository;

import com.crm.domain.Oportunity;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author ruben
 */
public interface OportunityRepository extends PagingAndSortingRepository<Oportunity, Long> {
    
    public List<Oportunity> findByLeadId(Long leadId);
}