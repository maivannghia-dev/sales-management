package com.example.sales_management.controller;

import com.example.sales_management.repository.CustomerRepository;
import com.example.sales_management.repository.OrderRepository;
import com.example.sales_management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/stats")
    public Map<String, Object> getStats() {
        long totalProducts = productRepository.count();
        long totalCustomers = customerRepository.count();
        long totalOrders = orderRepository.count();
        BigDecimal totalRevenue = orderRepository.findAll()
                .stream()
                .map(order -> order.getTotalAmount() != null ? order.getTotalAmount() : BigDecimal.ZERO)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return Map.of(
                "totalProducts", totalProducts,
                "totalCustomers", totalCustomers,
                "totalOrders", totalOrders,
                "totalRevenue", totalRevenue
        );
    }
}