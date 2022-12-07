package com.example.springsecurityapplication.services;

import com.example.springsecurityapplication.models.Order;
import com.example.springsecurityapplication.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    // Данный метод позволяет получить все заказы
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    // Данный метод позволяет получить заказ по номеру, где конец равен определенной последовательности
    public List<Order> getOrderByNumberEndingWith(String ending_with){
        List<Order> optionalOrders = orderRepository.findByNumberEndingWithIgnoreCase(ending_with);
        return optionalOrders;
    }


}