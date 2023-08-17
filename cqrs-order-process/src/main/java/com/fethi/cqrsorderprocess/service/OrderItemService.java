package com.fethi.cqrsorderprocess.service;

import com.fethi.cqrsorderprocess.document.Order;
import com.fethi.cqrsorderprocess.document.OrderItem;
import com.fethi.cqrsorderprocess.document.Product;
import com.fethi.cqrsorderprocess.repository.OrderItemRepository;
import com.fethi.cqrsorderprocess.service.vm.OrderItemVM;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> getAllWithPagination(int pageNo, int pageSize, String orderNo){
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
       return orderItemRepository.findByOrderId(orderNo,pageable).orElseThrow( () -> new RuntimeException("Order id Not Found"));
    }

    public void saveOrderItem(List<OrderItemVM> orderItemVMList, Order order){
        OrderItem orderItem;
        Product product;
        for (OrderItemVM orderItemVM : orderItemVMList){
            product = new Product(orderItemVM.getProductVM().getName(),orderItemVM.getProductVM().getDescription(),orderItemVM.getProductVM().getPrice(),
                    orderItemVM.getProductVM().getQuantity(), orderItemVM.getProductVM().getRating(), orderItemVM.getProductVM().getCreateTime());
            orderItem = new OrderItem(orderItemVM.getQuantity(),orderItemVM.getPrice(),product,order);
            orderItemRepository.insert(orderItem);
        }
    }

}
