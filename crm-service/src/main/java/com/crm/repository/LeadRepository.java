package com.crm.repository;

import com.crm.domain.Lead;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author ruben
 */
public interface LeadRepository extends PagingAndSortingRepository<Lead, Long> {

}