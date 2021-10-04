package com.example.repository;

import com.example.domain.Sale;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author ruben
 */
public interface SaleRepository extends PagingAndSortingRepository<Sale, Long> {

    
}