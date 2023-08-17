package com.fethi.productsalesteamB.Service;

import com.fethi.productsalesteamB.Service.dto.OrderDTO;
import com.fethi.productsalesteamB.Service.dto.OrderItemDTO;
import com.fethi.productsalesteamB.domain.Order;
import com.fethi.productsalesteamB.domain.OrderItem;
import com.fethi.productsalesteamB.domain.OrderStatus;
import com.fethi.productsalesteamB.domain.Product;
import com.fethi.productsalesteamB.eventstore.EventStoreService;
import com.fethi.productsalesteamB.eventstore.vm.OrderCreatedEventVM;
import com.fethi.productsalesteamB.eventstore.vm.OrderItemVM;
import com.fethi.productsalesteamB.eventstore.vm.OrderVM;
import com.fethi.productsalesteamB.eventstore.vm.ProductVM;
import com.fethi.productsalesteamB.repository.OrderRepository;
import com.fethi.productsalesteamB.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final EventStoreService eventStoreService;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, EventStoreService eventStoreService, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.eventStoreService = eventStoreService;
        this.productRepository = productRepository;
    }

    public Long save(List<OrderItemDTO> orderItemDTOS, String customerIdentiyNo) throws Exception {

        BigDecimal total = BigDecimal.ZERO;
        for (OrderItemDTO item : orderItemDTOS) {
            if (item.getProductId() != null && item.getQuantity() <= 0)
                throw new Exception("please check the quantity/productId information");
            total = total.add(item.getPrice());
        }
        List<OrderItem> orderItemList = toEntity(orderItemDTOS);
        Order order = createOrderObject(orderItemList, total, customerIdentiyNo);
        OrderDTO dto = toDto(orderRepository.save(order));
        eventStoreService.saveOrder(createOrderCreatedEventVM(dto,orderItemDTOS));
        return dto.getId();
    }

    private OrderCreatedEventVM createOrderCreatedEventVM(OrderDTO orderDTO, List<OrderItemDTO> orderItemDTOS) {
        OrderVM orderVM = new OrderVM();
        orderVM.setOrderStatus(orderDTO.getOrderStatus());
        orderVM.setOrderDate(orderDTO.getOrderDate());
        orderVM.setCustomerIdentity(orderDTO.getCustomerIdentity());
        orderVM.setTotalCost(orderDTO.getTotalCost());

        List<OrderItemVM> orderItemVMList = new ArrayList<>();
        OrderItemVM orderItemVM;
        ProductVM productVM;
        for (OrderItemDTO dto : orderItemDTOS) {
            orderItemVM = new OrderItemVM();
            productVM = new ProductVM();
            orderItemVM.setPrice(dto.getPrice());
            orderItemVM.setQuantity(dto.getQuantity());

            Optional<Product> product = productRepository.findById(dto.getProductId());
            if (product.isPresent()) {
                productVM.setCreateTime(product.get().getCreateTime());
                productVM.setName(product.get().getName());
                productVM.setDescription(product.get().getDescription());
                productVM.setPrice(product.get().getPrice());
                productVM.setQuantity(product.get().getQuantity());
                productVM.setRating(product.get().getRating());
            }
            orderItemVM.setProductVM(productVM);
            orderItemVMList.add(orderItemVM);
        }
        OrderCreatedEventVM orderCreatedEventVM = new OrderCreatedEventVM();
        orderCreatedEventVM.setOrderVM(orderVM);
        orderCreatedEventVM.setOrderItemVMList(orderItemVMList);
        return orderCreatedEventVM;
    }

    private Order createOrderObject(List<OrderItem> orderItemList, BigDecimal total, String customerIdentiyNo) {
        Order order = new Order();
        order.setOrderDate(LocalDate.now());
        order.setOrderStatus(OrderStatus.PAID);
        order.setOrderItems(new HashSet<>(orderItemList));
        order.setTotalCost(total);
        order.setCustomerIdentity(customerIdentiyNo);
        return order;
    }

    private List<OrderItem> toEntity(List<OrderItemDTO> orderItemDTOS) {
        List<OrderItem> orderItemList = new ArrayList<>();
        OrderItem orderItem;
        for (OrderItemDTO orderItemDTO : orderItemDTOS) {
            orderItem = new OrderItem();
            orderItem.setPrice(orderItemDTO.getPrice());
            orderItem.setQuantity(orderItemDTO.getQuantity());
            orderItem.setProduct(new Product(orderItemDTO.getProductId()));
            orderItemList.add(orderItem);
        }
        return orderItemList;
    }

    private OrderDTO toDto(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setOrderStatus(order.getOrderStatus());
        orderDTO.setCustomerIdentity(order.getCustomerIdentity());
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setTotalCost(order.getTotalCost());
        return orderDTO;
    }
}
