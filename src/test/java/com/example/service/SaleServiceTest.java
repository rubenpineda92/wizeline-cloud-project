/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service;

import com.example.domain.Category;
import com.example.domain.Product;
import com.example.repository.ProductRepository;
import com.example.repository.SaleRepository;
import java.util.Date;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author ruben
 */
@SpringBootTest
public class SaleServiceTest {
    
    @Mock
    private ProductRepository productRepository;
    @Mock
    private SaleRepository saleRepository;
    private AutoCloseable closeable;
    private SaleService saleService;
    private ProductService productService;
    
    @BeforeEach
    public void beforeTests() {
        closeable = MockitoAnnotations.openMocks(this);
        productService = new ProductService(productRepository);
        
        Category sugaryCategory = Category.builder().
                        id(1L).
                        name("Sugary").
                        build();
        
        Product cokeProduct = Product.builder().
                id(1L).
                description("Delicious bottled sugar").
                fecha_creacion(new Date())
                .name("Coca cola")
                .price(15.0)
                .status("Active")
                .stock(10.0)
                .category(sugaryCategory).build();
        
        Product milkyWay = Product.builder().
                id(2L).
                description("Kids healthiest food").
                fecha_creacion(new Date())
                .name("Milky Way")
                .price(7.0)
                .status("Active")
                .stock(5.0)
                .category(sugaryCategory).build();
        
        Mockito.when(productRepository.findByCategory(sugaryCategory)).thenReturn(Lists.list(cokeProduct, milkyWay));
    }
    
    @AfterEach
    void closeService() throws Exception {
        closeable.close();
    }
}
