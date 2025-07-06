package org.example.prostorazvlecaus.service;

import org.example.prostorazvlecaus.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrder();
    void addOrder(Order order);
    void deleteOrder(Long id);
    Order getOrder(Long id);
}
