package com.fethi.productsalesteamB.repository;


import com.fethi.productsalesteamB.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
