package com.example.sales_management.controller;

import com.example.sales_management.entity.OrderDetail;
import com.example.sales_management.service.OrderDetailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order-details")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping
    public Page<OrderDetail> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return orderDetailService.getAll(page, size);
    }

    @GetMapping("/{id}")
    public OrderDetail getById(@PathVariable Long id) {
        return orderDetailService.getById(id);
    }

    @PostMapping
    public OrderDetail create(@Valid @RequestBody OrderDetail orderDetail) {
        return orderDetailService.save(orderDetail);
    }

    @PutMapping("/{id}")
    public OrderDetail update(@PathVariable Long id, @Valid @RequestBody OrderDetail orderDetail) {
        orderDetail.setId(id);
        return orderDetailService.save(orderDetail);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orderDetailService.delete(id);
    }
}