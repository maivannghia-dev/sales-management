package com.example.sales_management.repository;

import com.example.sales_management.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findByCustomerNameContainingIgnoreCase(String name, Pageable pageable);
}