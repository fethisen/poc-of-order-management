package com.fethi.productsalesteamA.repository;

import com.fethi.productsalesteamA.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
