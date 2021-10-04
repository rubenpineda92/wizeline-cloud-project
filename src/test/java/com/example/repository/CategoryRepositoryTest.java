/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.repository;

import com.example.domain.Category;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author ruben
 */
@SpringBootTest
public class CategoryRepositoryTest {
    
    private final String testCategoryName = "category1";
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Test
    public void whenFindByName_thenReturnListCategory() {
        
        categoryRepository.save(Category.builder().name(testCategoryName).build());
        
        List<Category> categories = categoryRepository.getByName(testCategoryName);
        
        Assertions.assertThat(categories).isNotEmpty();
    }
}
