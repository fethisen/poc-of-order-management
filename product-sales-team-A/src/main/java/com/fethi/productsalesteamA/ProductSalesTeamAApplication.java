package com.fethi.productsalesteamA;

import com.fethi.productsalesteamA.domain.Product;
import com.fethi.productsalesteamA.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class ProductSalesTeamAApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductSalesTeamAApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(ProductRepository productRepository) {
//		return args -> {
//			productRepository.deleteAll();
//
//			Product product1 = new Product("iPhone 11", "iPhone 11", BigDecimal.valueOf(24.299).setScale(2, BigDecimal.ROUND_HALF_EVEN), 241, 5, LocalDate.now().minusMonths(4));
//			Product product2 = new Product("Poco C40", "Poco C40", BigDecimal.valueOf(3.699).setScale(2, BigDecimal.ROUND_HALF_EVEN), 147, 5, LocalDate.now().minusYears(1));
//			Product product3 = new Product("Xiaomi Redmi Note", "Xiaomi Redmi Note",  BigDecimal.valueOf(12.299).setScale(2, BigDecimal.ROUND_HALF_EVEN), 235, 5, LocalDate.now().minusYears(2));
//			Product product4 = new Product("Samsung Galaxy Z Flip5", "Samsung Galaxy Z Flip5",  BigDecimal.valueOf(47.999).setScale(2, BigDecimal.ROUND_HALF_EVEN), 256, 5, LocalDate.now().minusYears(3));
//			Product product5 = new Product("iPhone 13", "iPhone 13",  BigDecimal.valueOf(36.899).setScale(2, BigDecimal.ROUND_HALF_EVEN), 457, 5, LocalDate.now().minusYears(4));
//			Product product6 = new Product("Tcl 30 Plus", "Tcl 30 Plus",  BigDecimal.valueOf(5.999).setScale(2, BigDecimal.ROUND_HALF_EVEN), 541, 5, LocalDate.now().minusYears(5));
//
//			productRepository.saveAll(Arrays.asList(product1,product2,product3,product4,product5,product6));
//
//		};
//	}
}
