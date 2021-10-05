package com.example.repository;

import com.example.domain.Category;
import com.example.domain.Product;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author ruben
 */
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    public List<Product> findByCategory(Category category);
}