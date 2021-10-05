package com.example.repository;

import com.example.domain.Category;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author ruben
 */
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {

    public List<Category> getByName(String name);
    
}