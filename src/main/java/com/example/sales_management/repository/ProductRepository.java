package com.example.sales_management.repository;

import com.example.sales_management.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Tìm theo tên (không phân biệt hoa thường)
    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);

    // Lọc theo giá nhỏ hơn hoặc bằng
    Page<Product> findByPriceLessThanEqual(BigDecimal price, Pageable pageable);
}