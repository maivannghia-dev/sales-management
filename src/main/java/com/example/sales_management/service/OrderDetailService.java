package com.example.sales_management.service;

import com.example.sales_management.entity.OrderDetail;
import com.example.sales_management.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public Page<OrderDetail> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return orderDetailRepository.findAll(pageable);
    }

    public Optional<OrderDetail> getById(Long id) {
        return orderDetailRepository.findById(id);
    }

    public OrderDetail save(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    public void delete(Long id) {
        orderDetailRepository.deleteById(id);
    }
}