package com.fethi.productsalesteamB;

import com.fethi.productsalesteamB.domain.Product;
import com.fethi.productsalesteamB.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class ProductSalesTeamBApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductSalesTeamBApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(ProductRepository productRepository) {
//		return args -> {
//			productRepository.deleteAll();
//
//			Product product1 = new Product("MSI THIN GF63", "MSI THIN GF63", BigDecimal.valueOf(26.999).setScale(2, BigDecimal.ROUND_HALF_EVEN), 1000, 5, LocalDate.now().minusMonths(4));
//			Product product2 = new Product("Huawei MateBook D15", "Huawei MateBook D15", BigDecimal.valueOf(20.999).setScale(2, BigDecimal.ROUND_HALF_EVEN), 2541, 5, LocalDate.now().minusYears(1));
//			Product product3 = new Product("Monster Abra A5 ", "Monster Abra A5 ",  BigDecimal.valueOf(25.799).setScale(2, BigDecimal.ROUND_HALF_EVEN), 2541, 5, LocalDate.now().minusYears(2));
//			Product product4 = new Product("Dell Vostro 3400", "Dell Vostro 3400",  BigDecimal.valueOf(6.999).setScale(2, BigDecimal.ROUND_HALF_EVEN), 2365, 5, LocalDate.now().minusYears(3));
//			Product product5 = new Product("Acer Nitro 5", "Acer Nitro 5",  BigDecimal.valueOf(36.499).setScale(2, BigDecimal.ROUND_HALF_EVEN), 256, 5, LocalDate.now().minusYears(4));
//			Product product6 = new Product("Asus X515EA", "Asus X515EA",  BigDecimal.valueOf(6.999).setScale(2, BigDecimal.ROUND_HALF_EVEN), 365, 5, LocalDate.now().minusYears(5));
//
//			productRepository.saveAll(Arrays.asList(product1,product2,product3,product4,product5,product6));
//
//		};
//	}
}
