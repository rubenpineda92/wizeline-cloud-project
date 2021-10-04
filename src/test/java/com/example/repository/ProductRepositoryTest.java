/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.repository;

import com.example.domain.Category;
import com.example.domain.Product;
import java.util.Date;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author ruben
 */
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class ProductRepositoryTest {
    
    private final String testCategoryName = "category1";
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    private Category category;
    
    @BeforeAll
    public void beforeTests() {
        category = categoryRepository.save(Category.builder().name("Sugary").build());
    }
    
    @Test
    public void whenFindByName_thenReturnListCategory() {
        
        Product cokeProduct = productRepository.save(Product.builder().
                description("Delicious bottled sugar").
                fecha_creacion(new Date())
                .name("Coca cola")
                .price(15.0)
                .status("Active")
                .stock(0.0)
                .category(category).build());
        
        
        List<Product> listProducts = productRepository.findByCategory(category);
        
        Assertions.assertThat(listProducts).isNotEmpty();
    }
}
