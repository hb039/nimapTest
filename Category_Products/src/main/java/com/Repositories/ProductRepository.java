package com.Repositories;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Page<Product>findAll(Pageable pageable);
}
