package com.category_products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.category_products.model.Category;
import com.category_products.model.Product;
import com.category_products.model.ProductDTO;
import com.category_products.repository.CategoryRepository;
import com.category_products.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable).getContent();
    }

    public Product createProduct(Product product, int categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow();
        product.setCategory(category);
        return productRepository.save(product);
    }

    public ProductDTO getProductById(int id) {
    	Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    	ProductDTO dto= new ProductDTO();
    	dto.setId(product.getId());
    	dto.setName(product.getName());
    	dto.setPrice(product.getPrice());
    	dto.setCategory(product.getCategory().getName());
   
        return dto;
        
    }

    public Product updateProduct(int id, Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow();
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        return productRepository.save(product);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
