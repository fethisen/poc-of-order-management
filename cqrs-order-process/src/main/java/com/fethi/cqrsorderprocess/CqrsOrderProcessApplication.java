package com.fethi.cqrsorderprocess;

import com.fethi.cqrsorderprocess.document.Order;
import com.fethi.cqrsorderprocess.document.OrderItem;
import com.fethi.cqrsorderprocess.document.Product;
import com.fethi.cqrsorderprocess.repository.OrderItemRepository;
import com.fethi.cqrsorderprocess.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class CqrsOrderProcessApplication {

	public static void main(String[] args) {
		SpringApplication.run(CqrsOrderProcessApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
//		return args -> {
//			orderRepository.deleteAll();
//			orderItemRepository.deleteAll();
//
//			Product product1 = new Product("iPhone 11", "iPhone 11", BigDecimal.valueOf(24.299).setScale(2, BigDecimal.ROUND_HALF_EVEN), 241, 5, LocalDate.now().minusMonths(4));
//			Product product2 = new Product("Poco C40", "Poco C40", BigDecimal.valueOf(3.699).setScale(2, BigDecimal.ROUND_HALF_EVEN), 147, 5, LocalDate.now().minusYears(1));
//			Product product3 = new Product("Xiaomi Redmi Note", "Xiaomi Redmi Note",  BigDecimal.valueOf(12.299).setScale(2, BigDecimal.ROUND_HALF_EVEN), 235, 5, LocalDate.now().minusYears(2));
//			Product product4 = new Product("Samsung Galaxy Z Flip5", "Samsung Galaxy Z Flip5",  BigDecimal.valueOf(47.999).setScale(2, BigDecimal.ROUND_HALF_EVEN), 256, 5, LocalDate.now().minusYears(3));
//			Product product5 = new Product("iPhone 13", "iPhone 13",  BigDecimal.valueOf(36.899).setScale(2, BigDecimal.ROUND_HALF_EVEN), 457, 5, LocalDate.now().minusYears(4));
//			Product product6 = new Product("Tcl 30 Plus", "Tcl 30 Plus",  BigDecimal.valueOf(5.999).setScale(2, BigDecimal.ROUND_HALF_EVEN), 541, 5, LocalDate.now().minusYears(5));
//
//
//			Order order1 = new Order(LocalDate.now(), new BigDecimal(4251.01).setScale(2, BigDecimal.ROUND_HALF_EVEN),"PAID","customer1","12345678911");
//			Order order2 = new Order(LocalDate.now(), new BigDecimal(441.01).setScale(2, BigDecimal.ROUND_HALF_EVEN),"CANCEL","customer1","12345678911");
//			Order order3 = new Order(LocalDate.now(), new BigDecimal(7451.01).setScale(2, BigDecimal.ROUND_HALF_EVEN),"PAID","customer1","12345678911");
//			Order order4 = new Order(LocalDate.now(), new BigDecimal(7451.01).setScale(2, BigDecimal.ROUND_HALF_EVEN),"PAID","customer2","22222222222");
//			Order order5 = new Order(LocalDate.now(), new BigDecimal(5454.01).setScale(2, BigDecimal.ROUND_HALF_EVEN),"CANCEL","customer2","22222222222");
//			orderRepository.insert(order1);
//			orderRepository.insert(order2);
//			orderRepository.insert(order3);
//			orderRepository.insert(order4);
//			orderRepository.insert(order5);
//
//			OrderItem orderItem1 = new OrderItem(1, BigDecimal.valueOf(850),product1,order1);
//			OrderItem orderItem2 = new OrderItem(1, BigDecimal.valueOf(500),product2,order1);
//			OrderItem orderItem3 = new OrderItem(1, BigDecimal.valueOf(1200),product3,order2);
//			OrderItem orderItem4 = new OrderItem(1, BigDecimal.valueOf(900),product4,order3);
//			OrderItem orderItem5 = new OrderItem(1, BigDecimal.valueOf(750),product5,order4);
//			OrderItem orderItem6 = new OrderItem(1, BigDecimal.valueOf(650),product6,order5);
//
//			orderItemRepository.insert(orderItem1);
//			orderItemRepository.insert(orderItem2);
//			orderItemRepository.insert(orderItem3);
//			orderItemRepository.insert(orderItem4);
//			orderItemRepository.insert(orderItem5);
//			orderItemRepository.insert(orderItem6);
//
//		};
//	}
}
