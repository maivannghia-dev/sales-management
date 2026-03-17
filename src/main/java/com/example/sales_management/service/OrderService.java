package com.example.sales_management.service;

import com.example.sales_management.entity.Order;
import com.example.sales_management.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Page<Order> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return orderRepository.findAll(pageable);
    }

    public Optional<Order> getById(Long id) {
        return orderRepository.findById(id);
    }

    public Order save(Order order) {
        // Set order reference cho từng OrderDetail
        order.getOrderDetails().forEach(detail -> detail.setOrder(order));
        // Tính totalAmount tự động từ orderDetails
        if(order.getOrderDetails() != null && !order.getOrderDetails().isEmpty()){
            BigDecimal total = order.getOrderDetails()
                    .stream()
                    .map(detail -> detail.getPrice()
                            .multiply(new BigDecimal(detail.getQuantity())))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            order.setTotalAmount(total);
        }
        return orderRepository.save(order);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}